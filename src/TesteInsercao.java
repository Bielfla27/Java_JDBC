import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {
		CriaConexao criarConexao = new CriaConexao();
		Connection connection = criarConexao.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Teclado', 'Teclado sem fio')"
				, Statement.RETURN_GENERATED_KEYS);
				  //Retorna a ultimo id criado	
		
		//Um dos problemas de se utilizar o Statement é que, quando o usuário insere uma string em um formulário, utilizando um apóstrofo, ele não diferencia na hora de concatenar na query, causando uma SQLException
		
		ResultSet rst = stm.getGeneratedKeys(); //pegando id
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id doi: " + id);
		}
		
		connection.close();

		
	}

}
