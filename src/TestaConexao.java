import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConecao();
		
		System.out.println("Fechando conexão!!");
		connection.close();
	}

}
