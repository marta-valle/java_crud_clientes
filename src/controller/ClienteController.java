package controller;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {
	// CADASTRO DO CLIENTE -
	// AQUI É ONDE IMPRIME A PERGUNTA AO CLIENTE E PERMITE QUE SEJA INSERIDA A
	// RESPOSTA

	public void cadastrarCliente() {

		System.out.println("\n*******CADASTRAR CLIENTE*********");
		Cliente cliente = new Cliente();
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nNome do cliente..........:");
		cliente.setNome(scanner.nextLine());

		System.out.println("\nEmail..........:");
		cliente.setEmail(scanner.nextLine());

		System.out.println("\nTelefone..........:");
		cliente.setTelefone(scanner.nextLine());

		System.out.println("\nCPF..........: ");
		cliente.setCpf(scanner.nextLine());

		ClienteRepository clienteRepository = new ClienteRepository();
		try { // CHAMA O REPOSITORIO, ONDE SE COMUNICA COM O BD ATRAVES DO statement GRAVANDO
				// NO BANCO
				// LEMBRANDO QUE É NO CONNECTIONFACTORY QUE ESTÃO OS PARAMETROS E FAZ DE FATO A
				// CONEXÃO DO ECLIPSE COM POSTEGRESQL
			clienteRepository.create(cliente);
			System.out.println("\n CLIENTE CADASTRADO COM SUCESSO!");

		} catch (Exception e) {

			System.out.println("\n FALHA AO CADASTRAR CLIENTE!");
			e.printStackTrace(); // imprimir log de erro.

		}
	} // FIM DO CADASTRO DO CLIENTE - SIGA PARA O PROGRAM

	public void atualizarCliente() {

		System.out.println("\n*** ATUALIZAÇÃO DE CLIENTES ***\n");

		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();

		System.out.print("ID DO CLIENTE......: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));

		System.out.print("NOME DO CLIENTE....: ");
		cliente.setNome(scanner.nextLine());

		System.out.print("EMAIL..............: ");
		cliente.setEmail(scanner.nextLine());

		System.out.print("TELEFONE...........: ");
		cliente.setTelefone(scanner.nextLine());

		System.out.print("CPF................: ");
		cliente.setCpf(scanner.nextLine());

		ClienteRepository clienteRepository = new ClienteRepository();

		try {
			clienteRepository.update(cliente);
			System.out.println("\nCliente ATUALIZADO com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao ATUALIZAR cliente!");
			e.printStackTrace();
		}

	}
	// FIM DO UPDATE/ATUALIZAR CLIENTE

	public void excluirCliente() {

		System.out.println("\n*** EXCLUSÃO DE CLIENTES ***\n");

		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();

		System.out.print("ID DO CLIENTE......: ");

		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));
		ClienteRepository clienteRepository = new ClienteRepository();

		try {
			clienteRepository.delete(cliente);
			System.out.println("\nCliente EXCLUÍDO com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao EXCLUIR cliente!");
			e.printStackTrace();
		}
	}// FIM DO DELETE CLIENTE

	public void consultarClientes() {
		
		System.out.println("\n*** CONSULTA DE CLIENTES ***\n");
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			List<Cliente> lista = clienteRepository.findAll();

			for (Cliente cliente : lista) { // tipo de for: foreach - será lido cliente enquanto : houver dados na lista
				System.out.println("ID DO CLIENTE...: " + cliente.getIdCliente());
				System.out.println("NOME............: " + cliente.getNome());
				System.out.println("EMAIL...........: " + cliente.getEmail());
				System.out.println("TELEFONE........: " + cliente.getTelefone());
				System.out.println("CPF.............: " + cliente.getCpf());
				System.out.println("\t...Next");
			}
		} catch (Exception e) {
			System.out.println("\nFalha para CONSULTAR Cliente!");
			e.printStackTrace();
		}
	} // IR PARA O PROGRAM PERMITIR QUE O USUARIO ESCOLHA A OPCAO

}
