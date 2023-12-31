package dbVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Cliente;


public class ClienteDAO {
	
	public Cliente buscarCliente(String CPF) throws SQLException { 
	    Connection conexao = DB.getConnection();

	    String sql = "SELECT * FROM clientes WHERE CPF = ?";
	    PreparedStatement stmt = conexao.prepareStatement(sql);
	    stmt.setString(1, CPF);

	    ResultSet rs = stmt.executeQuery();  //String cPF, String rG, String endereco, String telefone
	    Cliente cli = null; 
	    if (rs.next()) {
	        cli = new Cliente(
	           rs.getString("CPF"), 
	           rs.getString("RG"),
	           rs.getString("endereco"), 
	           rs.getString("telefone"), 
	           rs.getString("nome")
	            
	            
	          
	        );
	    } 
	    rs.close();
	    stmt.close();
	    //DB.cloeConnection();
	    return cli;
	}

}
