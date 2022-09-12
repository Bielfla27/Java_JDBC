import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConecao();
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Teclado', 'Teclado sem fio')"
				, Statement.RETURN_GENERATED_KEYS);
				  //Retorna a ultimo id criado	
		
		ResultSet rst = stm.getGeneratedKeys(); //pegando id
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id doi: " + id);
		}
		
		
	}

}
