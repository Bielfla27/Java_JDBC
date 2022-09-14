package TestandoComModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.Produto;
import br.com.alura.jdbc.CriaConexao;

public class TesteInsercaoComModelo {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Xbox", "Xbox Sereis S");
		
		try(Connection connection = new CriaConexao().recuperarConexao()){
			String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		}
		
		System.out.println(produto);
		
	}

}
