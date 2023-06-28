package dbVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Produto;


public class ProdutoDAO {
	
	public Produto buscarProduto(int codigo) throws SQLException { //Só até agora
	    Connection conexao = DB.getConnection();

	    String sql = "SELECT * FROM produtos WHERE codigo = ?";
	    PreparedStatement stmt = conexao.prepareStatement(sql);
	    stmt.setString(1, Integer.toString(codigo));

	    ResultSet rs = stmt.executeQuery();
	    Produto produto = null; 
	    if (rs.next()) {
	        produto = new Produto(
	           rs.getInt("codigo"), 
	           rs.getString("descricao"),
	           rs.getFloat("valorUnitario"), 
	           rs.getInt("qtdEstoque")
	            
	            
	          
	        );
	    } 
	    rs.close();
	    stmt.close();
	    //DB.cloeConnection();
	    return produto;
	}
	
	public void atualizarProduto(int codigo, int attQtdEstoque) throws SQLException {
	    Connection conexao = DB.getConnection();

	    String sql = "UPDATE produtos SET  qtdEstoque = ? WHERE codigo = ?";
	    PreparedStatement stmt = conexao.prepareStatement(sql);
	    stmt.setInt(1, attQtdEstoque);
	    stmt.setInt(2, codigo);
	    
	   

	    stmt.execute();
	    stmt.close();
	    //DB.cloeConnection();
	}
	
	

}
