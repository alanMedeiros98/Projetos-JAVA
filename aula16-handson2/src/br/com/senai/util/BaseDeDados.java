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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.domain.Livro;

public class BaseDeDados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String PATH_ARQUIVO = "C:\\arquivos-senai\\livros.txt",
			             FINALIZADOR_LINHA = "\n";	
	
	private List<Livro> livros;
	
	public BaseDeDados() {
		this.livros = new ArrayList<Livro>();
		this.carregarDoArquivo();
	}
	
	public List<Livro> getLivros(){
		return livros;
	}
	
	public void inserir(Livro livro) {
		this.livros.add(livro);
		this.salvarNoArquivo(livro);
	}
	
	private void salvarNoArquivo(Livro livro) {
		BufferedWriter bw = null;
		try {
			OutputStream os = new FileOutputStream(PATH_ARQUIVO, true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			bw.write(livro.toString() + FINALIZADOR_LINHA);
		}catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			this.liberarEscritor(bw);
		}
	}
	
	private void carregarDoArquivo(){
		BufferedReader br = null;
		try {
			InputStream is = new FileInputStream(PATH_ARQUIVO);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String linha = br.readLine();
			while (linha != null) {
				Livro livro = new Livro(linha);
				this.livros.add(livro);
				linha = br.readLine();
			}
		}catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			this.liberarLeitor(br);
		}
	}
	
	public void liberarLeitor(BufferedReader br) {
		if (br != null) {
			try {
				br.close();
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}				
		}
	}
	
	public void liberarEscritor(BufferedWriter bw) {
		if (bw != null) {
			try {
				bw.close();
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}				
		}
	}

}
