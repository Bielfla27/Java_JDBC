import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "Monitor";
		String descricao = "AOC 27 FHD";
		
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConecao();
		
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)"
				, Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		//PreparedStatement ele deixa o c�digo mais seguro e tr�s a responsabilidade da montagem da query para ele
		// Uma das vantagens em se utilizar o PreparedStatement � que o mesmo evita o SQL injection.
		//O PreparedStatement mant�m a consulta compilada no banco de dados, para o usu�rio que necessitar realizar a mesma consulta, diversas vezes, com par�metros diferentes.
		
		ResultSet rst = stm.getGeneratedKeys(); 
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id doi: " + id);
		}
		
	}

}
