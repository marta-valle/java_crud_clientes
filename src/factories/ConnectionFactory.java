package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// PREPARANDO A CONEXÃO COM O BANCO DE DADOS
	/*
	 * CRIA-SE UMA VARIAVEL PARA RECEBER OS DADOS DE CONEXAO AO BANCO "connection"
	 * // thows é usado para obrigar que quando essa variavel for iniciada, é //
	 * obrigatório que seja dentro do try/catch para tratativa de excessões.
	 * 
	 * /* public Connection getConection() throws Exception{
	 * Class.forName("org.postgresql.driver"); return DriverManager.getConnection(
	 * "jdbc:postegresql://localhost:5432/bd_java_projeto03", "postegresql",
	 * "0902");
	 * 
	 * }
	 */
	// melhor forma de executar esse comando:

	public Connection getConnection() throws Exception {
		String driver = "org.postgresql.Driver";
		String host = "jdbc:postgresql://localhost:5432/bd_java_projeto03";
		String user = "postgres";
		String password = "0902";

		// class.forNome conecta a biblioteca instalada e passa os "parametros" para
		// conexão ao banco.
		Class.forName(driver);
		return DriverManager.getConnection(host, user, password);
	}

}
