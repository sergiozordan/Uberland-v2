
public abstract class  Veiculos { 

	  // --- Definindo os Status como constantes ---
    public static final int DISPONIVEL = 1;
    public static final int NAO_DISPONIVEL = 2;
    public static final int EM_VIAGEM = 3;
    public static final int FINALIZANDO_VIAGEM = 4;

    private String placa;
    private String chassi;
    private String cor;
    private int capacidade;
    private int ano;
    private String marca;
    private String modelo;
    private int status; 
    private boolean ativo;    //carro inativo => ativo = false e deletado=false
	private boolean deletado; // carro ativo => ativo = true e deletado=false
                              // carro deletado=> ativo=false e deletado = true	
	private Motorista motorista; // vincular motorista ao veiculo
    
    public Veiculos(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo) {
        setPlaca(placa);
        setChassi(chassi);
        setCor(cor);
        setCapacidade(capacidade); 
        setAno(ano);
        setMarca(marca);
        setModelo(modelo);
        this.status = DISPONIVEL;
        ativo = false;
		deletado = false;
    }
    
    // Getters:
    public int getStatus() {
        return status;
    }
    public String getPlaca() {
        return placa;
    }
    public String getChassi() {
        return chassi;
    }
    public String getCor() {
        return cor;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public int getAno() {
        return ano;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public Motorista getMotorista() {  
    	return motorista;
    }
    

    //Setters:
    public void setPlaca(String placa) {
		if(placa != null && placa.length() == 7)
			this.placa = placa;
	}
	public void setChassi(String chassi) {
		if(chassi != null && chassi.length() == 17 )
			this.chassi = chassi;
	}
	public void setCor(String cor) {
		if(cor != null && cor.length() > 0)
			this.cor = cor;
	}
	public void setCapacidade(int capacidade) {
		if(capacidade >= 3)
			this.capacidade = capacidade;
	}
	public void setAno(int ano) {
		if (ano > 2016 && ano < 2026)
			this.ano = ano;
	}
	public void setMarca(String marca) {
		if(marca != null && marca.length() > 0)
			this.marca = marca;
	}
	public void setModelo(String modelo) {
		if (modelo != null && modelo.length() > 0)
			this.modelo = modelo;
	}
	public void setStatus(int status) {
		if (deletado== false)
	        this.status = status;
	    }
		
	public boolean isAtivo() {
		return ativo;
	}

	public void ativar() {
		if (deletado == false)
			ativo = true;
	}
	public void desativar() {
		ativo = false;
		status = NAO_DISPONIVEL; 
	}

	public boolean isDeletado() {
		return deletado;
	}

	public void deletar () {
		deletado = true;
		ativo = false;
		status = NAO_DISPONIVEL;
	}
	
	protected void setMotorista(Motorista motorista) { 
		this.motorista = motorista;
	}
	
	protected abstract double getTarifaMinima(); //nao retorna valor nenhum
	
	protected abstract double getCustoKm();  // nao retorna valor nenhum
	
	public double calcularCustoViagem(double distanciaKm) {
	    if (distanciaKm < 0)
	        return getTarifaMinima();
	    
	    return (distanciaKm * getCustoKm()) + getTarifaMinima();
	}
	

	
	  // Método base para exibir dados:
    public void exibirDadosV(){
        System.out.println("\nPlaca: " + placa);
        System.out.println("Chassi: " + chassi);
        System.out.println("Cor: " + cor);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Ano: " + ano);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
    
    public String getStatusDescricao() {
    	switch (status) {
    		case DISPONIVEL: return "DISPONÍVEL";
    		case NAO_DISPONIVEL: return "NÃO DISPONÍVEL";
    		case EM_VIAGEM: return "EM VIAGEM";
    		case FINALIZANDO_VIAGEM: return "FINALIZANDO VIAGEM";
    		default: return "STATUS DESCONHECIDO";
    	}
    }

}
