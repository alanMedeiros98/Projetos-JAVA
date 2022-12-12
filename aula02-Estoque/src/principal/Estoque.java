package principal;

public class Estoque {

	private String descricao;
 	private int quantidade;
 	
 	public Estoque(int quantidade) {
 		this.setQuantidade(quantidade);
 	}
	
 	public Estoque(String descricao, int quantidade) {
 		this(quantidade);
 		this.descricao = "";
 		if (descricao != null) {
 			this.descricao = descricao;
 		}
 	}
 	
	public void setQuantidade(int quantidade) {
		
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}else {
			System.out.println("A quantidade nao pode ser nula!");
		}
		
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	void transferirPara(Estoque outroEstoque, int quantidadeTransferida) {
		
		if(this.quantidade > 0 ) {
			outroEstoque.quantidade += quantidadeTransferida;
			this.quantidade -= quantidadeTransferida;
		}
		
		
	}
	
}
