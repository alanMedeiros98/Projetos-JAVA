package br.com.senai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("C:\\arquivos-senai\\dados.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		String linha = br.readLine();
		
		while(linha != null) {
			System.out.println(br.readLine());
			linha = br.readLine();
		}
		br.close();
		
		OutputStream os = new FileOutputStream("C:\\arquivos-senai\\dados.txt", true);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("\nMuriscleison");
		bw.close();
		
	}

}
