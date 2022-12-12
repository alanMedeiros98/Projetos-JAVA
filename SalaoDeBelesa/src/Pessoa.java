import javax.swing.JOptionPane;

public abstract class Pessoa {

	private int codigo;
	
	private String nomeCompleto;
	
	private String cpf;
	
	public Pessoa() {
		
	}

	public Pessoa(int codigo, String nomeCompleto, String cpf) {
		if(!nomeCompleto.isEmpty() && !cpf.isEmpty()) {
			this.codigo = codigo;
			this.nomeCompleto = nomeCompleto;
			this.cpf = cpf;
		} else {
			JOptionPane.showMessageDialog(null, "Esta faltando dados!!");
		}
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
