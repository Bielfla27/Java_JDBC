package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID,NOME,DESCRICAO FROM PRODUTO");
		stm.execute();
		
		
		ResultSet resultset = stm.getResultSet();  //aqui estou pegando o resultado da consulta do stm.execute
		
		while(resultset.next()) {
			Integer id = resultset.getInt("ID");//colocando o valor do param?tro ID da consulta na vati?vel id 
			System.out.println(id);
			String nome = resultset.getString("NOME");
			System.out.println(nome);
			String descricao = resultset.getString("DESCRICAO");
			System.out.println(descricao);
		}
		connection.close();

	}

}
