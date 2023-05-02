
public class Cliente {

	private int id;
	
	private String nomeCompleto;
	
	private String cpf;

	public Cliente(int id, String nomeCompleto, String cpf) {
		this.id = id;
		this.setNomeCompleto(nomeCompleto);
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		if(nomeCompleto != null && !nomeCompleto.isEmpty()) {
			this.nomeCompleto = nomeCompleto;			
		} else {
			throw new NomeObrigatorioException("o nome do cliente deve ser obrigatório!");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf != null && !cpf.isEmpty()) {
			this.cpf = cpf;
		} else {
			throw new CampoObrigatorioException("O CPF é obrigatório!");
		}
	}
	
	
	
}
