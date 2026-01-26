import java.time.LocalDateTime;


public class Corrida{

	public static final int SOLICITADA = 0;
    public static final int EM_ANDAMENTO = 1;
    public static final int FINALIZADA = 2;
    public static final int CANCELADA_ANTES = 3;   // novo
    public static final int CANCELADA_DURANTE = 4;  // novo
    public static final double valorExtra = 5.00;
    public static final int CANCELADA_POR_CLIENTE = 1;  // novo
    public static final int CANCELADA_POR_MOTORISTA = 2;  //novo
	
	private Cliente cliente;
	private Veiculos veiculo;
	private String origem;
	private String destino;
	private LocalDateTime dataHoraSolicitacao;
	private String horaInicio;  // novo usar string para hora do inicio
	private String horaChegada; // novo usar string para hora da cehgada
	private int duracaoViagem;
	private double distanciaRealKm;
	private double valorTotal;
	private boolean pagarValorExtra;
	private double valorMotorista;
	private double valorUberLand;
	private int statusCorrida; // 0 - solicitada, 1 - em andamento, 2 - finalizada, 3 - cancelada antes, 4 - cancelada durante
	private int canceladaPor;
	private String formasPagamento;


	//Construtor

	public Corrida( Cliente cliente, Veiculos veiculo, String origem, String destino, LocalDateTime dataHoraSolicitacao, String formasPagamento){

		setCliente(cliente);
		setVeiculo(veiculo);	
		setOrigem(origem);
		setDestino(destino);
		setFormasPagamento(formasPagamento);
		this.dataHoraSolicitacao = dataHoraSolicitacao;
		this.statusCorrida = SOLICITADA;
	}
	//Getters e Setters
	public Cliente getCliente() {
	 	return cliente;
	}

	 public void setCliente(Cliente cliente) {
	 	if(cliente != null)
	 		this.cliente = cliente;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		if(veiculo !=null)
			this.veiculo = veiculo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		if(origem != null && origem.length() > 0)
			this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		if(destino != null && destino.length() > 0)
			this.destino = destino;
	}
	public LocalDateTime getDataHoraSolicitacao() {
		return dataHoraSolicitacao;
	}
	
	public int getStatusCorrida() {
		return statusCorrida;
	}
	
	public String getHoraInicio() { // novo
		return horaInicio;
	}
	
	public String getHoraChegada() { // novo
		return horaChegada;
	}
	
	public int getDuracaoViagem() {
		return duracaoViagem;
	}
	
	public double getDistaciaRealKm() {
		return distanciaRealKm;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public boolean isPagarValorExtra() {
		return pagarValorExtra;
	}
	public void setPagarValorExtra(boolean pagarValorExtra) {
		if(statusCorrida == SOLICITADA)
			this.pagarValorExtra = pagarValorExtra;
	}
	
	public double getValorMotorista() {
		return valorMotorista;
	}
	public void setValorMotorista(double valorMotorista) {
		this.valorMotorista = valorMotorista;
	}
	public double getValorUberLand() {
		return valorUberLand;
	}
	public void setValorUberLand(double valorUberLand) {
		this.valorUberLand = valorUberLand;
	}
	
	public int getCanceladaPor() { // novo
		return canceladaPor;
	}
	
	public String getFormasPagamento() {
		return formasPagamento;
	}
	public void setFormasPagamento(String formasPagamento) {
		if (formasPagamento != null && formasPagamento.length()>0)
				this.formasPagamento = formasPagamento;
	}
	

	
	
	//metodos
	public void iniciarCorrida(String horaInicio) { // novo verifica se o veiculo esta disponivel, ativo  e nao deletado
		if (statusCorrida == SOLICITADA && veiculo.isAtivo() && !veiculo.isDeletado() && veiculo.getStatus() == Veiculos.DISPONIVEL) {
			this.statusCorrida = EM_ANDAMENTO;
			this.horaInicio = horaInicio;
			veiculo.setStatus(Veiculos.EM_VIAGEM); // novo - usar estatus do veiculo em corrida
		}
	}

	public void finalizarCorrida(double distanciaRealKm, String horaChegada) {
		if (statusCorrida != EM_ANDAMENTO || distanciaRealKm <= 0 || horaInicio == null)
			return;
		
		this.horaChegada = horaChegada;
		this.duracaoViagem = calcularDuracaoViagem(horaInicio, horaChegada);
		
		if (duracaoViagem <= 5)
			veiculo.setStatus(Veiculos.FINALIZANDO_VIAGEM); // novo - usar status finalizando viagem
		else
			veiculo.setStatus(Veiculos.DISPONIVEL);  // novo - usar estatus do veiculo em corrida
				
		this.statusCorrida = FINALIZADA;
		this.distanciaRealKm = distanciaRealKm;
		calcularValorViagem();
		RegrasUberLand.calcularDivisaoCorrida(this);
		veiculo.getMotorista().incrementaQtdecorridas(); // novo incrementar corrida ao motorista
		cliente.incrementaQtdecorridas();              // novo incrementar corrida a cliente
		cliente = RegrasUberLand.verificarClientevip(cliente); // novo verificar se tornou vip
	}
	
	private int converterHoraParaMinutos(String horario) {  // novo para converter hora em minutos
		String[] partes = horario.split(":");
		int horas = Integer.parseInt(partes[0]);
		int minutos = Integer.parseInt(partes[1]);
		return horas * 60 + minutos;
	}
	
	private int calcularDuracaoViagem(String inicio, String fim) { // novo corrigir metodo usando string
		int minInicio = converterHoraParaMinutos (inicio);
		int minFim = converterHoraParaMinutos (fim);
		
		if (minInicio > minFim)
			minFim += 24*60;
		
		return minFim - minInicio;
	}
		
	public void cancelarCorrida(int canceladaPor) {
		if (statusCorrida == FINALIZADA) // novo nao pode cancelar corrida finalizada
			return;
		
		if (statusCorrida == SOLICITADA) 
			this.statusCorrida = CANCELADA_ANTES;	//novo cancelada antes ou durante
		else if (statusCorrida == EM_ANDAMENTO) {
			this.statusCorrida = CANCELADA_DURANTE;   //novo cancelada antes ou durante
			veiculo.setStatus(Veiculos.DISPONIVEL);   // novo tornar veiculo disponivel novamente
		}
		setCanceladaPor(canceladaPor);
	}

	public boolean isCanceladaPorCliente() {
		return (statusCorrida == CANCELADA_ANTES || statusCorrida == CANCELADA_DURANTE) && canceladaPor == CANCELADA_POR_CLIENTE; // novo cancelado antes ou durante
	}
	
	public boolean isCanceladaPorMotorista() {
		return (statusCorrida == CANCELADA_ANTES || statusCorrida == CANCELADA_DURANTE) && canceladaPor == CANCELADA_POR_MOTORISTA;   //novo cancelado antes ou durante
	}
	
	public void setCanceladaPor(int canceladaPor) {  // novo
		if (canceladaPor == CANCELADA_POR_CLIENTE || canceladaPor == CANCELADA_POR_MOTORISTA)
			this.canceladaPor = canceladaPor; 		
	}
	

	private void calcularValorViagem() {              // novo - calcular desconto para cliente vip
		valorTotal = veiculo.calcularCustoViagem(distanciaRealKm);
		
		if(pagarValorExtra) {
			this.valorTotal += valorExtra;
		}
		
		if (cliente instanceof ClienteVip) {
			ClienteVip vip = (ClienteVip)cliente;
			this.valorTotal = valorTotal - (valorTotal * vip.getDescontovip());
		}
		
		
	}
	
	public void exibirDadosCorrida(){
		System.out.println("----- Dados da Corrida -----");
		System.out.println("Origem: " + getOrigem());
		System.out.println("Destino: " + getDestino());
		System.out.println("Data e Hora da Solicitação: " + getDataHoraSolicitacao());
		System.out.println("Status da Corrida: " + getStatusCorridaDescricao());
		System.out.println("cliente: " + cliente.getNome());
		System.out.println("veiculo: " + veiculo.getPlaca());	
		System.out.println("Motorista: " + veiculo.getMotorista().getNomesocial());
	}
	
	public String getStatusCorridaDescricao() {
		switch (statusCorrida) {
			case SOLICITADA: return "SOLICITADA";
			case EM_ANDAMENTO: return "EM ANDAMENTO";
			case FINALIZADA: return "FINALIZADA";
			case CANCELADA_ANTES: return "CANCELADA ANTES";
			case CANCELADA_DURANTE: return "CANCELADA DURANTE";
			default: return "STATUS DESCONHECIDO";
		}
	}

	
}
