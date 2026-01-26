
public class ClienteVip extends Cliente{

	private float descontovip;

	public ClienteVip (Cliente cliente) {
		super(cliente.getNome(),cliente.getCpf(),cliente.getDataNasc(),cliente.getCel(),cliente.getEmail(), cliente.getSexo());
		this.qtdecorridas = cliente.getQtdecorridas(); //novo
		this.qtdeavaliacoes = cliente.getQtdeAvaliacoes(); // novo
		this.avaliacao = cliente.getAvaliacao();       // novo
		setPagamento(cliente.getPagamento());
		this.descontovip = RegrasUberLand.regraDescontovip(this);
	}

	public float getDescontovip() {
		return descontovip;
	}

		
}
