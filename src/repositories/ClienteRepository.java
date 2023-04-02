package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// metodo para receber e cadastrar cliente com tratativa de falha
	public void create(Cliente cliente) throws Exception {

		// abrir conexão com bd
		ConnectionFactory connectionFatory = new ConnectionFactory();

		Connection connection = connectionFatory.getConnection();
		// preparedStatement é usado para "escrever" dentro do banco de dados.

		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(nome, email,telefone,cpf) values(?,?,?,?)");
		// o 1° interrogação, será substituido pelo que for escrito; ISSO É O NOME QUE
		// ESTA NA CLASSE CLIENTE
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		// EXECUTA/SALVA
		statement.execute();
		// FECHA
		statement.close();

		// SEGUE PARA CONTROLLER - EXECUTA A GRAVAÇÃO NO BD.

	}

	// Método para ATUALIZAR UM CLIENTE no bd
	public void update(Cliente cliente) throws Exception {
		ConnectionFactory connectionFatory = new ConnectionFactory();
		Connection connection = connectionFatory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome=?, email =?, telefone=?, cpf=? where idcliente=?");

		// ATENÇÃO A ORDEM QUE FOI DETERMINADA NO PREPARESTATEMENT 1 = NOME
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.setInt(5, cliente.getIdCliente());

		statement.execute();
		statement.close();
		connection.close();

	}

	// MÉTODO PARA DELETAR
	public void delete(Cliente cliente) throws Exception {
		ConnectionFactory connectionFatory = new ConnectionFactory();
		Connection connection = connectionFatory.getConnection();

		// PREPARAR PARA ESCREVER NO POSTEGREQSL
		PreparedStatement statement = connection.prepareStatement("delete from where idcliente=?"); // O VALOR SERÁ
																									// INSERIDO PELO
																									// USUARIO.
		statement.setInt(1, cliente.getIdCliente());

		statement.execute();
		statement.close();

		connection.close();

	}

	// Método de CONSULTA - COMPREENDENDO QUE PODEMOS TER VARIOS CLIENTES
	// CADASTRADOS
	// PRECISAMOS QUE ESTA CONSULTA RETORNE UMA LISTA

	public List<Cliente> findAll() throws Exception {

		ConnectionFactory connectionFatory = new ConnectionFactory();
		Connection connection = connectionFatory.getConnection();

		// comando para escrever dentro no banco.
		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		ResultSet resultSet = statement.executeQuery();

		List<Cliente> lista = new ArrayList<Cliente>();
		while (resultSet.next()) {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setCpf(resultSet.getString("cpf"));

			// adicionar cada objeto cliente dentro da lista.
			lista.add(cliente);
		}
		connection.close();
		return lista;

	}

}
