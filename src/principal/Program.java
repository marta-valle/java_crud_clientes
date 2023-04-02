package principal;

import java.util.Scanner;

import controller.ClienteController;

public class Program {

	public static void main(String[] args) {
		System.out.println("(1) CADASTRAR CLIENTE");
		System.out.println("(2) ATUALIZAR CLIENETE");
		System.out.println("(3) EXCLUIR CLIENTE");
		System.out.println("(4) CONSULTAR CLIENTES");

		Scanner scanner = new Scanner(System.in);
		Integer opcao = Integer.parseInt(scanner.nextLine());

		ClienteController clienteController = new ClienteController();

		switch (opcao) {
		case 1:
			clienteController.cadastrarCliente();
			break;
		case 2:
			clienteController.atualizarCliente();
			break;
		case 3:
			clienteController.excluirCliente();
			break;
		case 4:
			clienteController.consultarClientes();
			
			break;
		default:
			System.out.println("\n OP��O INVALIDA. DIGITE UMA OP��O VALIDA");
			opcao = Integer.parseInt(scanner.nextLine());
		}

	}

}
