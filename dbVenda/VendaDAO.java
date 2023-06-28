package dbVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import negocio.Venda;



public class VendaDAO {
	
	 public int adicionarVenda(int idVenda, String cpf, int numeroFunc, String data) throws SQLException {
		 Connection conexao = DB.getConnection();
		 int idGerado = 0;
		 
		 
		  String sql = "INSERT INTO vendas (idVenda, CPF, numeroFuncRef, DataVenda) VALUES (?,?,?,?)"; //Passar obj usar os get
	        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, null); //Auto generete
	        stmt.setString(2, cpf );
	        stmt.setInt(3, numeroFunc);
	        stmt.setString(4, data);

	        stmt.execute();
	        ResultSet result = stmt.getGeneratedKeys();
	        
	        
	        if (result.next()) {
	             idGerado = result.getInt(1);
	            
	        }
	       
	        stmt.close();
	        return idGerado;
	        
		 
	 }
	 
	 public Venda buscarVenda(int idVenda) throws SQLException { 
		    Connection conexao = DB.getConnection();

		    String sql = "SELECT * FROM vendas WHERE idVenda = ?";
		    PreparedStatement stmt = conexao.prepareStatement(sql);
		    stmt.setInt(1, idVenda);

		    ResultSet rs = stmt.executeQuery();  
		    Venda venda = null; 
		    if (rs.next()) {
		        venda = new Venda(
		           rs.getInt("idVenda"),  
		           rs.getString("DataVenda"),
		           "Finalizada"
		          
		        );
		    } 
		    rs.close();
		    stmt.close();
		    //DB.cloeConnection();
		    return venda;
		}
	 
	 
	        
	        

}
