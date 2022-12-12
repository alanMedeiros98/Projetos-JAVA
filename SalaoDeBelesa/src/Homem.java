
public class Homem extends Pessoa {

	private TipoBarba barba;
	
	public Homem() {
		
	}
	
	public Homem(int codigo, String nomeCompleto, String cpf, TipoBarba barba) {
		super(codigo, nomeCompleto, cpf);
		this.barba = barba;
	}

	public TipoBarba getBarba() {
		return barba;
	}

	public void setBarba(TipoBarba barba) {
		this.barba = barba;
	}
	
	
	
}
