package negocio;

import java.util.ArrayList;



public class Venda {
	
	private int id;
	private String data; 
	private String status;
	private ArrayList<ItemVenda> itensVenda = null;
	private Pagamento pag;
	
	



	public Venda(int id, String data, String status) {
		super();
		this.id = id;
		this.data = data;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ArrayList<ItemVenda> getItensVenda() {
		return itensVenda;
	}


	public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}


	public Pagamento getPag() {
		return pag;
	}


	public void setPag(Pagamento pag) {
		this.pag = pag;
	}

	
	

}
