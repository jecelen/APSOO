package negocio;

public class Pagamento {
	
    private String formaDePagamento;
    
    
	
	public Pagamento(String formaDePagamento) {
		super();
		this.formaDePagamento = formaDePagamento;
	}



	public void Pagamento(String pagt) { //parâmetro "pagt" vem do método "setPagamento" da classe Venda.
		this.formaDePagamento = pagt;
	}

}
