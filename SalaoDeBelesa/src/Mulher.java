
public class Mulher extends Pessoa {

	private String corTinta;
	
	private Cabelereiro cabelereiro;
	
	public Mulher() {
		
	}

	public Mulher(int codigo, String nomeCompleto, String cpf, String corTinta) {
		super(codigo, nomeCompleto, cpf);
		this.corTinta = corTinta;
	}

	public String getCorTinta() {
		return corTinta;
	}

	public void setCorTinta(String corTinta) {
		this.corTinta = corTinta;
	}

	public Cabelereiro getCabelereiro() {
		return cabelereiro;
	}
	
	
	
}
