package classes;

public class DevolucaoLivro {

	private static Integer proximoId = 1;
	private Integer id;
	private AlugarLivro locacao;
	private String dataEntregue;
	
	public DevolucaoLivro() {
		// 
	}
	
	public DevolucaoLivro(Integer id, AlugarLivro locacao, String dataEntregue) {
		
		this.id = id;
		this.locacao = locacao;
		this.dataEntregue = dataEntregue;
	}

	public static Integer getProximoId() {
		return proximoId++;
	}

	public static void setProximoId(Integer proximoId) {
		DevolucaoLivro.proximoId = proximoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlugarLivro getLocacao() {
		return locacao;
	}

	public void setLocacao(AlugarLivro locacao) {
		this.locacao = locacao;
	}

	public String getDataEntregue() {
		return dataEntregue;
	}

	public void setDataEntregue(String dataEntregue) {
		this.dataEntregue = dataEntregue;
	}

	
	public String toString() {
		return "Id: " + id + " | Locacao: " + locacao + " | Data entregue: " + dataEntregue;
	}
	
	public DevolucaoLivro devolver (AlugarLivro alugado,  String dataEntregue) {
		
		this.setId(getProximoId());
		this.locacao = alugado;
		this.locacao.getLivro().setAlugado(false);
		this.dataEntregue = dataEntregue;
		this.locacao.setStatus(true);
		
		
		return this;
	}
	
	


}

