package dbVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import negocio.ItemVenda;


/*codigo int AI PK 
qtdProduto int 
precoVendido float 
prodCod int 
idVenda int*/

public class ItemVendaDAO {
	
	 public void adicionarItemVenda(int codigo, int qtdProduto, float precoVendido, int prodCod, int idVenda) throws SQLException {
		 Connection conexao = DB.getConnection();
		 
		  String sql = "INSERT INTO itemvendas (codigo, qtdProduto, precoVendido, prodCod, idVenda) VALUES (?,?,?,?,?)";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, null); //Auto generete
	        stmt.setInt(2, qtdProduto );
	        stmt.setFloat(3, precoVendido);
	        stmt.setInt(4, prodCod );
	        stmt.setInt(5, idVenda );
	        
	        
	        stmt.execute();
	        stmt.close();
	           
		 
	 }

}
