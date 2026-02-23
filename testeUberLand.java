
import java.time.LocalDateTime;

public class testeUberLand {

	public static void main(String[] args) {

		//TelaCliente cl = new TelaCliente();
		
		//TelaMotorista m1 = new TelaMotorista();
		
		//TelaVeiculos v1 = new TelaVeiculos();
		
		//TelaCorrida cor1 = new TelaCorrida();
		
		// 1. Criar Cliente
		Cliente cliente = new Cliente(
				"Ana Paula",
				"12345678909",
				"15031998",
				"11988887777",
				"ana@email.com",
				'F'
		);
		DadosCliente.cadastrarCliente(cliente);

		// 2. Criar Motorista
		Motorista motorista = new Motorista(
				"Marcos Lima",
				"98765432100",
				"20051990",
				"Rua Central, 100",
				"12345678901",
				"Marcos"
		);
		DadosMotorista.cadastrarMotorista(motorista);

		// 3. Criar Veículos
		Veiculos uberX = new UberX(
				"ABC1234",
				"11111111111111111",
				"Branco",
				4,
				2021,
				"Fiat",
				"Argo",
				true,
				false
		);
		DadosVeiculo.cadastrarVeiculos(uberX);
		
		Veiculos uberComfort = new UberComfort(
				"DEF5678",
				"22222222222222222",
				"Preto",
				4,
				2022,
				"Honda",
				"Civic",
				true,
				true,
				true
		);
		DadosVeiculo.cadastrarVeiculos(uberComfort);

		Veiculos uberBlack = new UberBlack(
				"GHI9012",
				"33333333333333333",
				"Preto",
				4,
				2023,
				"BMW",
				"320i",
				true,
				true,
				3
		);
		DadosVeiculo.cadastrarVeiculos(uberBlack);

		// 4. Vincular veículos ao motorista
		motorista.adicionarVeiculo(uberX);
		motorista.adicionarVeiculo(uberComfort);
		motorista.adicionarVeiculo(uberBlack);

		// 5. Ativar motorista e veículos
		motorista.ativar();

		uberX.ativar();
		uberX.setStatus(Veiculos.DISPONIVEL);

		uberComfort.ativar();
		uberComfort.setStatus(Veiculos.DISPONIVEL);

		uberBlack.ativar();
		uberBlack.setStatus(Veiculos.DISPONIVEL);

		// 6. Deletar um veículo
		uberBlack.deletar();

		System.out.println("\n=== VEÍCULO DELETADO ===");
		System.out.println("UberBlack ativo? " + uberBlack.isAtivo());
		System.out.println("UberBlack deletado? " + uberBlack.isDeletado());

		// 7. Exibir dados do motorista e veículos
		System.out.println("\n=== DADOS DO MOTORISTA ===");
		DadosMotorista.listarMotorista();
		
		System.out.println("\n=== VEÍCULOS DO MOTORISTA ===");
		DadosVeiculo.listarVeiculos();
		
		// 8. Criar Corrida (usar UberX)
		Cliente clientebuscado = DadosCliente.buscarCliente("12345678909");
		if(clientebuscado == null) {
			System.out.println("\nCliente nao encontrado");
			return;
		}
		
		Veiculos veiculobuscado = DadosVeiculo.buscarVeiculo("ABC1234");
		if(veiculobuscado == null) {
			System.out.println("\nVeiculo nao encontrado");
			return;
		}
		
		Corrida	corrida = new Corrida(
				clientebuscado,
				veiculobuscado,
				"Shopping Center",
				"Universidade",
				LocalDateTime.now(),
				clientebuscado.getPagamento()
			);
		DadosCorrida.cadastrarCorrida(corrida);
		
		// 9. Iniciar Corrida
		corrida.iniciarCorrida("10:30");

		System.out.println("\n=== CORRIDA INICIADA ===");
		System.out.println("Status da corrida: " + corrida.getStatusCorridaDescricao());
		System.out.println("Status do veículo: " + uberX.getStatusDescricao());

		// 10. Finalizar Corrida
		corrida.finalizarCorrida(8.0, "10:50"); // 20 minutos

		// 11. Resultados finais
		System.out.println("\n===== RESULTADOS =====");

		motorista.calculaAvalicao(9);
		cliente.calculaAvalicao(10);

		System.out.println("Avaliação final do motorista: " + motorista.getAvaliacao());
		System.out.println("Avaliação final do cliente: " + cliente.getAvaliacao());

		corrida.exibirDadosCorrida();

		System.out.println("Status da corrida: " + corrida.getStatusCorridaDescricao());
		System.out.println("Status do veículo: " + uberX.getStatusDescricao());

		System.out.println("Distância percorrida: " + corrida.getDistaciaRealKm() + " km");
		System.out.println("Duração da viagem: " + corrida.getDuracaoViagem() + " minutos");

		System.out.printf("Valor total: R$ %.2f%n", corrida.getValorTotal());
		System.out.printf("Valor motorista: R$ %.2f%n", corrida.getValorMotorista());
		System.out.printf("Valor UberLand: R$ %.2f%n", corrida.getValorUberLand());

		System.out.println("\nCliente - Corridas: " + cliente.getQtdecorridas());
		System.out.println("Motorista - Corridas: " + motorista.getQtdecorridas());

		Cliente clienteatual = DadosCliente.buscarCliente("12345678909");
		if (clienteatual instanceof ClienteVip) {
			System.out.println("Cliente é VIP");
		} else {
			System.out.println("Cliente ainda não é VIP");
		}

		// 12. Testar corrida cancelada antes de iniciar
		System.out.println("\n=== TESTE CORRIDA CANCELADA ===");

		Corrida corridaCancelada = new Corrida(
		        cliente,
		        uberX,
		        "Casa",
		        "Trabalho",
		        LocalDateTime.now(),
		        cliente.getPagamento()
		);
		DadosCorrida.cadastrarCorrida(corridaCancelada);

		corridaCancelada.cancelarCorrida(Corrida.CANCELADA_POR_CLIENTE);

		System.out.println("Status da corrida: " + corridaCancelada.getStatusCorridaDescricao());
		System.out.println("Cancelada por cliente? " + corridaCancelada.isCanceladaPorCliente());

		// 13. Testar corrida com veículo deletado
		System.out.println("\n=== TESTE CORRIDA COM VEÍCULO DELETADO ===");

		System.out.println("Veículo deletado? " + uberBlack.isDeletado());
		System.out.println("Veículo ativo? " + uberBlack.isAtivo());
		
		Corrida corridaComCarroDeletado = new Corrida(
		        cliente,
		        uberBlack,
		        "Centro",
		        "Aeroporto",
		        LocalDateTime.now(),
		        cliente.getPagamento()
		);
		DadosCorrida.cadastrarCorrida(corridaComCarroDeletado);

		corridaComCarroDeletado.iniciarCorrida("11:00");

		System.out.println("Status da corrida: " + corridaComCarroDeletado.getStatusCorridaDescricao());
		System.out.println("Status do veículo: " + uberBlack.getStatusDescricao());

		//14 Teste do DAO - Dados da Corrida
		System.out.println("\n=== LISTANDO TODAS AS CORRIDAS ===");
		DadosCorrida.listarCorrida();
		
		System.out.println("\n===== FIM DO TESTE =====");
	}
}
