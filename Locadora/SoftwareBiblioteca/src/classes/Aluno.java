package classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import telas.TlCadastroAlu;

public class Aluno {
	
	private static Integer proximoId = 1;
	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	
	
	
	public Aluno() {
	
	}

	public Aluno(Integer id, String nome, String cpf, Integer idade) {
		super();
		this.id = proximoId++;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}

	public static Integer getProximoId() {
		return proximoId++;
	}

	public static void setProximoId(Integer proximoId) {
		Aluno.proximoId = proximoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	
	public String toString() {
		return "Id: " + id + " | Nome: " + nome + " | Cpf: " + cpf + " | Idade: " + idade;
	}
	
	
	public Aluno cadastrar (String nome, String cpf, Integer idade ) {
		
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdade(idade);
		this.setId(getProximoId());
		
		return this;
	}
	
	public String listar(ArrayList<Aluno>alunos) {
		
		String listaAluno = "";
		for (Aluno aluno : alunos) {
			listaAluno += aluno + "\n";
			}
		return listaAluno;
		
		
	}
	

	
	public Aluno alterar (Integer id, String nome, String cpf, Integer idade ) {
		
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdade(idade);
		
		return this;
	}
	
	public void remover (Integer id) {
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		for (int i = 0; i < alunos.size(); i++) {
			if (id.equals(alunos.get(i).getId())) {
				alunos.remove(alunos.get(i));
				
			}
		}
		
	}
	
	public  Aluno consultarPorId(ArrayList<Aluno> alunos, Integer id) {
		
		for (Aluno aluno : alunos) {
			if(aluno.getId().equals(id)) {
				return aluno;
			}
		}
		return null;
	}
	
	
	
}
