
public class Principal {

	public static void main(String[] args) {
		
		Pessoa homem = new Homem(1, "", "123132132", TipoBarba.CAVANHAQUE);
		
		System.out.println("codigo: " + homem.getCodigo() + "\nNome: " + homem.getNomeCompleto() + "\nCPF: " + homem.getCpf());

	}

}
