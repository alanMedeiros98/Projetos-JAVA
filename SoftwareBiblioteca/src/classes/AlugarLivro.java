package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AlugarLivro {

	private static Integer proximoId = 1;
	private Integer id;
	private Aluno aluno;
	private Livro livro;
	private String dataEntrega;
	private Boolean status = false;
	
	public AlugarLivro() {
	
	}

	public AlugarLivro(Integer id, Aluno aluno, Livro livro, String dataEntrega, Boolean status) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.livro = livro;
		this.dataEntrega = dataEntrega;
		this.status = status;
	}
 
	
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public static Integer getProximoId() {
		return proximoId++;
	}

	public static void setProximoId(Integer proximoId) {
		AlugarLivro.proximoId = proximoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	
	public String toString() {
		return "Id: " + id + " | Aluno: " + aluno.getId() + " - " + aluno.getNome() + " | Livro: " + livro.getId() + " - " + livro.getTitulo() + " | Data entrega: " + dataEntrega + " | Status: " + (status ? "Devolvido" : "Pendente");
	}
	
	public AlugarLivro alugar (Aluno aluno, Livro livro, String dataEntrega) {
		
		this.setId(getProximoId());
		this.aluno = aluno;
		this.livro = livro;
		this.livro.setAlugado(true);
		this.dataEntrega = dataEntrega;

		return this;
		
	}
	
public  AlugarLivro consultarPorId(ArrayList<AlugarLivro> alugueis, Integer id) {
		
		for (AlugarLivro aluguel : alugueis) {
			if(aluguel.getId().equals(id)) {
				return aluguel;
			}
		}
		return null;
	}
	
	
	
	
}
