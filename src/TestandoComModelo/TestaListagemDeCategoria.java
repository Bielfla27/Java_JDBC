package TestandoComModelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import Modelo.Categoria;
import br.com.alura.jdbc.CriaConexao;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new CriaConexao().recuperarConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.ListaCategoria();
			listaDeCategorias.stream().forEach(lp -> System.out.println(lp));
		}
	}

}
