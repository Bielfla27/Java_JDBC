import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConecao();
		connection.setAutoCommit(false); // com isso eu estou assumindo o controle e dizendo que só vou commita quando eu quiser
		
		//PreparedStatement ele deixa o código mais seguro e trás a responsabilidade da montagem da query para ele
		// Uma das vantagens em se utilizar o PreparedStatement é que o mesmo evita o SQL injection.
		//O PreparedStatement mantém a consulta compilada no banco de dados, para o usuário que necessitar realizar a mesma consulta, diversas vezes, com parâmetros diferentes.
		
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)"
					, Statement.RETURN_GENERATED_KEYS);
			adicionarVariavel("SmartTV", "50 Polegadas", stm);
			adicionarVariavel("Controle", "Controle Xbox", stm);
			connection.commit();
			stm.close();	
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROOLBACK EXECUTADO");
			connection.rollback();
		}finally {
			connection.close();
		}
	}	
	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys(); 
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id doi: " + id);
		}
	}

}
