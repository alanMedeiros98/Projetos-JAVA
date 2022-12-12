
public class PecaMoto extends PecaRegular {
	
	private int cilind;
	
	public void PecaMoto() {
		
	}

	
	
	public PecaMoto(int codPeca, String descCurta, String descLonga, double preco, int cilind) {
		super(codPeca, descCurta, descLonga, preco);
		this.cilind = cilind;
	}



	public int getCilind() {
		return cilind;
	}

	public void setCilind(int cilind) {
		this.cilind = cilind;
	}
	
	// Metodos
	
	public String Mostrar() {
		String encremento = "\ncilindrada da moto: " + this.getCilind();
		
		return super.Mostrar() + encremento;
		
	}
	
}
