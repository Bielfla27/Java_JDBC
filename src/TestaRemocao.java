import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConecao();
		
		Statement stm = connection.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
		
	}

}
