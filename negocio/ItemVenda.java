package negocio;

public class ItemVenda {

	private int quantidade;   //quantidade do mesmo produto que foi comprada em determinada venda.
	private int precoVendido; //o valor vendido pode ser diferente do "valorUnitário" cadastrado.
	private String id;
	private Produto item;
	
	/*public ItemVenda proximo() { //método que passa pelo arraylist de itens de uma venda e decrementado estoque
								//a quantidade que foi comprada
								
		
	}*/
	
	
	
	public ItemVenda(int quantidade, int precoVendido, String id, Produto item) {
		super();
		this.quantidade = quantidade;
		this.precoVendido = precoVendido;
		this.id = id; //Ser um default temporárioo até acrescentar no BD e retornar esse valor
		this.item = item;
	}
	
	public Produto getProuto() {
		return item;
		
	}

	public int getQtdEstoque()	{
		return item.getQtdEstoque();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getPrecoVendido() {
		return precoVendido;
	}

	public void setPrecoVendido(int precoVendido) {
		this.precoVendido = precoVendido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Produto getItem() {
		return item;
	}
	
	public String getNomeItem() {
		return item.getDescricao();
	}

	public void setItem(Produto item) {
		this.item = item;
	}
}
