import java.util.ArrayList;

public class DadosVeiculo {
	
	private static ArrayList<Veiculos> vetVeiculo = new ArrayList<Veiculos>();
	
	public static void cadastrarVeiculos(Veiculos v) {
		if(v != null) 
			vetVeiculo.add(v);
	}
	
	public static void listarVeiculos() {
		for(Veiculos v : vetVeiculo)
			v.exibirDadosV();
	}
	
	public static Veiculos buscarVeiculo(String placa) {
		for (Veiculos v : vetVeiculo) {
			if (v.getPlaca().equals(placa))
				return v;
		}
		return null;
	}
	
	public static boolean excluirVeiculo(String placa) {
		Veiculos aux = buscarVeiculo(placa);
		
		if (aux != null) {
			vetVeiculo.remove(aux);
			return true;
		}else
			return false;
	}

}
