package br.com.senai.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.domain.Aluno;

public class BaseDeDados {
	
	private final String PATH_ARQUIVO = "C:\\arquivos-senai\\alunos.txt";
	
	private List<Aluno> alunos;
	
	public BaseDeDados() {
		this.alunos = new ArrayList<Aluno>();
		this.carregarDoArquivo();
	}
	
	public void inserir(Aluno aluno) {
		//Adicionar regras de negócio
		this.alunos.add(aluno);
		this.salvarNoArquivo(aluno);
	}
	
	public void remover(Aluno aluno) {
		this.alunos.remove(aluno);
	}
	
	public Aluno buscarPor(int codigo) {
		for (Aluno aluno : alunos) {
			if (aluno.getCodigo() == codigo) {
				return aluno;
			}
		}
		return null;
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
	private List<Aluno> carregarDoArquivo(){
		List<Aluno> alunosDoArquivo = new ArrayList<Aluno>();
		BufferedReader br = null;
		try{
			InputStream is = new FileInputStream(PATH_ARQUIVO);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String linha = br.readLine();
			while (linha != null) {
				Aluno aluno = new Aluno(linha);
				this.alunos.add(aluno);
				linha = br.readLine();
			}
		}catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				}catch (IOException ioe) {
					ioe.printStackTrace();
				}				
			}
		}
		return alunosDoArquivo;
	}
	
	private void salvarNoArquivo(Aluno aluno) {
		BufferedWriter bw = null;
		try {
			OutputStream os = new FileOutputStream(PATH_ARQUIVO, true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			bw.write(aluno.toString());
		}catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if (bw != null) {
				try {
					bw.close();
				}catch (IOException ioe) {
					ioe.printStackTrace();
				}				
			}
		}
	}

}
