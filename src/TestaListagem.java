import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "gabriel");
		
		Statement stm = connection.createStatement();
		stm.execute("SELECT ID,NOME,DESCRICAO FROM PRODUTO");

		
		ResultSet resultset = stm.getResultSet();  //aqui estou pegando o resultado da consulta do stm.execute
		
		while(resultset.next()) {
			Integer id = resultset.getInt("ID");//colocando o valor do paramêtro ID da consulta na vatiável id 
			System.out.println(id);
			String nome = resultset.getString("NOME");
			System.out.println(nome);
			String descricao = resultset.getString("DESCRICAO");
			System.out.println(descricao);
		}
		connection.close();

	}

}
