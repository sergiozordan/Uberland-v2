
public class RegrasUberLand {

	private static final int corridasclientevip = 10;
	private static final double porcentagemUberLand = 0.6;
	
	public static Cliente verificarClientevip (Cliente cliente) {
		if (cliente instanceof ClienteVip)  //evita criar cliente vip mais de uma vez
			return cliente;
		
		if (cliente.getQtdecorridas() >= corridasclientevip) {
			return new ClienteVip (cliente);
		}
		return cliente;
		
	}
	
	public static float regraDescontovip(ClienteVip clientevip) {
		if (clientevip.getQtdecorridas() >= 50) {
			return  0.2f;
		}else if (clientevip.getQtdecorridas() >= 30) {
			return  0.15f;
		}else {
			return  0.1f;
		}
		
	}
	
	public static void calcularDivisaoCorrida(Corrida corrida) {
		corrida.setValorUberLand( corrida.getValorTotal() * porcentagemUberLand);
		corrida.setValorMotorista(corrida.getValorTotal() - corrida.getValorUberLand());
	}
	
}
