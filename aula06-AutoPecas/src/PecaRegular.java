
public class PecaRegular {

	private int codPeca;
	private String descCurta;
	private String descLonga;
	private double preco;
	
	public void PecaRegular() {
		
	}
	
	public PecaRegular(int codPeca, String descCurta, String descLonga, double preco) {
		this.codPeca = codPeca;
		this.descCurta = descCurta;
		this.descLonga = descLonga;
		this.preco = preco;
	}


	public int getCodPeca() {
		return codPeca;
	}
	public void setCodPeca(int codPeca) {
		this.codPeca = codPeca;
	}
	public String getDescCurta() {
		return descCurta;
	}
	public void setDescCurta(String descCurta) {
		this.descCurta = descCurta;
	}
	public String getDescLonga() {
		return descLonga;
	}
	public void setDescLonga(String descLonga) {
		this.descLonga = descLonga;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	// Metodos
	
	public String Mostrar() {
		String txtTela = "\ncódigo da peça: " + this.getCodPeca()
					   + "\nnome da peça: " + this.getDescCurta()
					   + "\ndescrição da peça: " + this.getDescLonga()
					   + "\npreço da peça: " + this.getPreco();
		
		return txtTela;
	}
	
}
