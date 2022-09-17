package TestandoComModelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import Modelo.Categoria;
import Modelo.Produto;
import br.com.alura.jdbc.CriaConexao;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new CriaConexao().recuperarConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.ListaCategoriaComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}

}
