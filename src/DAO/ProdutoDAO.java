package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import Modelo.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarProduto(Produto produto) throws SQLException {
		
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
	
	public List<Produto> listar() throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID,NOME,DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(produto);
				}
			}
		}
		
		return produtos;	
	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID,NOME,DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, ct.getId());
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(produto);
				}
			}
		}
		
		return produtos;	
	}

}
