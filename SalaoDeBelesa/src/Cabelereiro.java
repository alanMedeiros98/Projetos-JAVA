
public class Cabelereiro extends Pessoa {

	private double tempoExp;
	
	public Cabelereiro() {
		
	}

	
	
	public Cabelereiro(int codigo, String nomeCompleto, String cpf, double tempoExp) {
		super(codigo, nomeCompleto, cpf);
		this.tempoExp = tempoExp;
	}



	public double getTempoExp() {
		return tempoExp;
	}

	public void setTempoExp(double tempoExp) {
		this.tempoExp = tempoExp;
	}
	
	
	
}
