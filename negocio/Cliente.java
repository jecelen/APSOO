package negocio;

public class Cliente {

	private String CPF;
	private String RG;
	private String endereco;
	private String telefone;
	private String nome; 
	
	
	public Cliente(String cPF, String rG, String endereco, String telefone, String nome) {
		super();
		CPF = cPF;
		RG = rG;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nome = nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		this.RG = rG;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
