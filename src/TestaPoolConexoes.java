import java.sql.SQLException;
import java.util.Iterator;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao criaConexao = new CriaConexao();
		
		for (int i = 0; i < 20; i++) {
			criaConexao.recuperarConexao();
			System.out.println("Conexão de número: " + i);
			
		}
	}

}
