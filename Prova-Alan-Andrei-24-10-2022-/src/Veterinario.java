
public class Veterinario {

	private Animal animal;
	
	private int codigo;
	
	private String nomeCompleto;
	
	public Veterinario() {
		
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
	
	public void atender(Animal animal) {
		System.out.println("Animal sendo atendido: " + animal.getNome());
	}
	
}
