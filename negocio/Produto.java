package negocio;

public class Produto {
	
	private int codigo;
	private String descricao;
	private float valorUnitario;
	private int qtdEstoque;
	
	public Produto(int codigo, String descricao, float valorUnitario, int qtdEstoque) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.qtdEstoque = qtdEstoque;
	}
	
	public void decrementarQtdEstoque(int qtdComprada){
		this.qtdEstoque = qtdEstoque - qtdComprada;
			
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}



}
