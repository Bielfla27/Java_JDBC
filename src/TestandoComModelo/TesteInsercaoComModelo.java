package TestandoComModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ProdutoDAO;
import Modelo.Produto;
import br.com.alura.jdbc.CriaConexao;

public class TesteInsercaoComModelo {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Xbox", "Xbox Sereis S");
		
		try(Connection connection = new CriaConexao().recuperarConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvarProduto(produto);
		}
		
		System.out.println(produto);
		
	}

}
