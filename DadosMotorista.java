import java.util.ArrayList;

public class DadosMotorista {

	private static ArrayList<Motorista> vetMotorista = new ArrayList<Motorista>();
	
	
	public static void cadastrarMotorista (Motorista m) {
		if(m != null)
			vetMotorista.add(m);
	}
	
	public static void listarMotorista() {
		for (Motorista m : vetMotorista)
			m.exibirDadosMOTORISTA();
	}
	
	public static Motorista buscarMotorista(String cpf) {
		for (Motorista m: vetMotorista) {
			if(m.getCpf().equals(cpf)) {
				return m;
			}
		}
		return null;	
	}
	
	public static boolean excluirMotorista(String cpf) {
		Motorista aux = buscarMotorista(cpf);
		if (aux != null) {
			vetMotorista.remove(aux);
			return true;
		}else
			return false;
	}
}

