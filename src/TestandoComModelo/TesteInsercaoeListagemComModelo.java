package TestandoComModelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDAO;
import Modelo.Produto;
import br.com.alura.jdbc.CriaConexao;

public class TesteInsercaoeListagemComModelo {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Xbox", "Xbox Sereis S");
		
		try(Connection connection = new CriaConexao().recuperarConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvarProduto(produto);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
		
		
		
	}

}
