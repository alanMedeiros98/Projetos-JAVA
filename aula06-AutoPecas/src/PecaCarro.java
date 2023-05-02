
public class PecaCarro extends PecaRegular {

	private int qtdePortas;
	private int potenciaMotor;
	
	public void PecaCarro() {
		
	}

	
	
	public PecaCarro(int codPeca, String descCurta, String descLonga, double preco, int qtdePortas, int potenciaMotor) {
		super(codPeca, descCurta, descLonga, preco);
		this.qtdePortas = qtdePortas;
		this.potenciaMotor = potenciaMotor;
	}



	public int getQtdePortas() {
		return qtdePortas;
	}

	public void setQtdePortas(int qtdePortas) {
		this.qtdePortas = qtdePortas;
	}

	public int getPotenciaMotor() {
		return potenciaMotor;
	}

	public void setPotenciaMotor(int potenciaMotor) {
		this.potenciaMotor = potenciaMotor;
	}
	
	// metodos
	
	public String Mostrar() {
		String encremento = "\nQuantidade de portas: " + this.getQtdePortas();
		encremento += "\nPotencia do Motor: " + this.getPotenciaMotor();
		
		return super.Mostrar() + encremento;
		
	}
	
}
