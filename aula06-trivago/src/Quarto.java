
public abstract class Quarto {

	private int codigo;
	private String descricao;
	private double valorDiaria;
	
	
	public Quarto(int codigo, String descricao, double valorDiaria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorDiaria = valorDiaria;
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


	public double getValorDiaria() {
		return valorDiaria;
	}


	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	
	public abstract double aplicarDesconto();
	
	
}
