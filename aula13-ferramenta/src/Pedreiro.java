
public class Pedreiro {

	private int codigo;
	
	private String nomeCompleto;
	
	public Pedreiro() {
		
	}

	public void usar(Ferramenta ferramenta) {
		System.out.println("Ferrameta sendo usada: " + ferramenta.getDescricaoCurta());
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	
	
}
