
public class Programador {

	private int codigo;
	
	private String nomeCompleto;
	
	private LinguagemDeProgramacao linguagem;
	
	public Programador() {
		
	}

	public void desenvolver(LinguagemDeProgramacao linguagem) {
		System.out.println("O programador esta desenvolvendo na linguagem: " + linguagem.getDescricao());
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
	
	public LinguagemDeProgramacao getLinguagem() {
		return linguagem;
	}
	
}
