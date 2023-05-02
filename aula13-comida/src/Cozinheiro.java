
public class Cozinheiro {

	private int codigo;
	
	private String nomeCompleto;
	
	public Cozinheiro() {
		
	}
	
	public void preparar(Massa massa) {
		System.out.println("O cozinheiro esta preparando a massa: " + massa.getDescricaoCurta());
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
