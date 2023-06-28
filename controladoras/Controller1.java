package controladoras;

import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import dbVenda.*;
import dbVenda.ProdutoDAO;
import negocio.*;
import java.util.ArrayList;






public class Controller1 {
	
	ProdutoDAO prodDAO = new ProdutoDAO();  
	ClienteDAO cliDAO = new ClienteDAO();
	VendaDAO vendaDAO = new VendaDAO();
	ItemVendaDAO itemDAO = new ItemVendaDAO();
	Produto produto;
	Cliente cli;
	Venda venda;
	ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
	
	
	public Controller1() {
		
		
		
	}
	
	
	public boolean existeProduto(int codigoProduto) {
		
		try {
			
			if(prodDAO.buscarProduto(codigoProduto) != null) {
				produto = prodDAO.buscarProduto(codigoProduto);
				
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; 
		
}
	
	public String retornaNome(int codProd) {
		
		if(codProd == this.produto.getCodigo()) {
			
			return this.produto.getDescricao();
		
		} else {
			
			return "Erro";
		}
		
	}
	
	public String retornaValorUnit(int codProd) {
		
		  if(codProd == this.produto.getCodigo()) {
					
					return Float.toString(this.produto.getValorUnitario());
				
		  } else {
					
			return "Erro";
	    
		  }
	}
	
	public boolean consultaEstoque(int codProduto, int qtd) {
		
	      if(codProduto == this.produto.getCodigo()) {
				
	    	  if(qtd > this.produto.getQtdEstoque()) {
	    		  
	    		  return false;
	    		  
	    	  }else {
	    		  
	    		  return true;
	    	  }
				
			
			} else {
				
				return false;
			}
	}
	

	public void adicionarItemVenda(int codProd, int qtdProd) throws SQLException { //Fazer todas as ligações
		
		
		Produto tempProd = prodDAO.buscarProduto(codProd);
		
		ItemVenda tempItem = new ItemVenda(qtdProd , 0 , "null", tempProd );
		
		itensVenda.add(tempItem); 
		
		
		
		
	} 
	
	
	// Parte da ClienteDAO
	
   public boolean existeCliente(String CPF) {
		
		try {
			
			if(cliDAO.buscarCliente(CPF) != null) {
				cli = cliDAO.buscarCliente(CPF);
				
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; 
		
 }
   
  public String getNomeCli(String CPF) { 
	  	  
		  return this.cli.getNome();
		   
  }
  
  //Parte final -> RealizarVenda
  
  public void realizarVenda(String pagamento, String CPF) throws SQLException {
	  
	  
	  int idVenda = vendaDAO.adicionarVenda(0,  cli.getCPF(), 1, this.getDateTime() );
	  
	  venda = vendaDAO.buscarVenda(idVenda); //idVenda 
	  
	  for(ItemVenda e : itensVenda){
		  
		  
		  Produto temp = e.getProuto();
		  
		  float valorNormal = temp.getValorUnitario();
		  
		  
		  itemDAO.adicionarItemVenda(0, e.getQuantidade(), valorNormal, temp.getCodigo(), idVenda);
		  
	  }
	  
	  venda.setItensVenda(itensVenda); //Settando conforme o Diagrama de Comunicação
	  
	  //Criando pagamento 
	  
	  Pagamento pag = new Pagamento(pagamento);
	  
	  venda.setPag(pag); //Settando o pagamento -> pag
	  
	  //Parte de Alterar a qtd do Produto após a venda
	  
      for(ItemVenda e : venda.getItensVenda()){
		  
		  
		  Produto temp = e.getProuto();
		  
		  int dec = e.getQuantidade();
		  
		  temp.decrementarQtdEstoque(dec);
		  
		  //Att o DB
		  
		  prodDAO.atualizarProduto(temp.getCodigo(), temp.getQtdEstoque());
	   }
      
      
	  
	  
	  
	  
	  
  }
  
	

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public boolean diferenteDeNull() {
		
		if(this.itensVenda.isEmpty() == false) {
			
			return true;
			
		}else {
			
			return false;
		}
	}
	
	
		

}
