package br.com.senai.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.domain.Aluno;

public class BaseDeDados {

	private 
	
	private List<Aluno> alunos;
	
	public BaseDeDados() {
		this.alunos = new ArrayList<>();
	}
	
	public void inserir(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public void remover(Aluno aluno) {
		this.alunos.remove(aluno);
	}
	
	public Aluno buscarPor(int codigo) {
		for (Aluno aluno : alunos) {
			if(aluno.getCodigo() == codigo) {
				return aluno;
			}
		}
		return null;
	}
	
	private List<Aluno> carregarDoArquivo(){
		List<Aluno> alunosDoArquivo = new ArrayList<>();
		try{
			InputStream is = new FileinputStream(PATH_ARQUIVO);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			BufferedWriter br = new BufferedWriter(osw);
			String linha = br 
		}catch() {
			
		}
	}
	
	private void salvarnNomeArquivo(Aluno aluno) {
		BufferedWriter bw = null;
		try {
			OutputStream os = new FileOutputStream("C:\\arquivos-senai\\alunos.txt", true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			bw.write(aluno.toString());
		}catch(FileNotFoundException ffe) {
			ffe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally{
			if(bw != null) {
				try {
					bw.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
	
}
