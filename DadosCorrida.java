import java.util.ArrayList;

public class DadosCorrida {
	private static ArrayList <Corrida> vetCorrida= new ArrayList<Corrida>();
	
	public static void cadastrarCorrida(Corrida c) {
		if (c!= null) 
			vetCorrida.add(c);
	}
	
	public static void listarCorrida() {
		for (Corrida c : vetCorrida) {
			c.exibirDadosCorrida();
		}
	}
	
	public static ArrayList<Corrida> buscarCorrida(Cliente cliente) {
		ArrayList<Corrida> lista = new ArrayList<Corrida>();
		
		for (Corrida c : vetCorrida) {
			if (c.getCliente().equals(cliente))
				lista.add(c);
		}
		return lista;
	}
	
	public static boolean excluirCorrida(Corrida c) {
		if (c!= null) {
			vetCorrida.remove(c);
			return true;
		}
		return false;
	}
	

}
