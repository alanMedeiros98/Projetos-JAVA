
public class Tecnico {

	private int codigo;
	
	private String nomeCompleto;
	
	private Equipamento equipamento;
	
	public Tecnico() {
		
	}

	public void reparar(Equipamento equipamento) {
		System.out.println("O Técnico está reparando o seguinte equipamento: " + equipamento.getDescricaoCurta());
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

	public Equipamento getEquipamento() {
		return equipamento;
	}

		
}
