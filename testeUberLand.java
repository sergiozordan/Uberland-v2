
import java.time.LocalDateTime;

public class testeUberLand {

	public static void main(String[] args) {

		// 1. Criar Cliente
		Cliente cliente = new Cliente(
				"Ana Paula",
				"12345678909",
				"15031998",
				"11988887777",
				"ana@email.com",
				'F'
		);

		// 2. Criar Motorista
		Motorista motorista = new Motorista(
				"Marcos Lima",
				"98765432100",
				"20051990",
				"Rua Central, 100",
				"12345678901",
				"Marcos"
		);

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
		motorista.exibirDadosMOTORISTA();

		System.out.println("\n=== VEÍCULOS DO MOTORISTA ===");
		uberX.exibirDadosV();
		System.out.println();

		uberComfort.exibirDadosV();
		System.out.println();

		uberBlack.exibirDadosV(); // mesmo deletado, exibindo dados
		System.out.println();

		// 8. Criar Corrida (usar UberX)
		Corrida corrida = new Corrida(
				cliente,
				uberX,
				"Shopping Center",
				"Universidade",
				LocalDateTime.now(),
				cliente.getPagamento()
		);

		// 9. Iniciar Corrida
		corrida.iniciarCorrida("10:30");

		System.out.println("\n=== CORRIDA INICIADA ===");
		System.out.println("Status da corrida: " + corrida.getStatusCorridaDescricao());
		System.out.println("Status do veículo: " + uberX.getStatusDescricao());

		// 10. Finalizar Corrida
		corrida.finalizarCorrida(8.0, "10:50"); // 20 minutos

		// 11. Resultados finais
		System.out.println("\n===== RESULTADOS =====");

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

		if (cliente instanceof ClienteVip) {
			System.out.println("Cliente é VIP");
		} else {
			System.out.println("Cliente ainda não é VIP");
		}

		System.out.println("\n===== FIM DO TESTE =====");
	}
}
