package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConexao();
		
		System.out.println("Fechando conex?o!!");
		connection.close();
	}

}
