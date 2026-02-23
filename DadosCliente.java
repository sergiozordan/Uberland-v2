import java.util.ArrayList;

public class DadosCliente {
	
	private static ArrayList<Cliente> vetCliente = new ArrayList<Cliente>();
	
	public static void cadastrarCliente(Cliente c) {
		if (c != null)
			vetCliente.add(c);
	}
	
	public static void listarCliente() {
		for(Cliente c: vetCliente) {
			c.exibirDadosCLIENTE();
		}
	}
	public static void substituirCliente(Cliente antigo, Cliente vip) {
		vetCliente.remove(antigo);
		vetCliente.add(vip);
	}
	
	public static Cliente buscarCliente(String cpf) {
		for (Cliente c: vetCliente) {
			if (c.getCpf().equals(cpf))
				return c;
		}
		return null;	
	}
	
	public static boolean excluirCliente(String cpf) {
		Cliente aux = buscarCliente(cpf);
		
		if(aux != null) {
			vetCliente.remove(aux);
			return true;
		}else
			return false;
	}

}
