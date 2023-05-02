package br.com.senai;

import br.com.senai.domain.Formato;
import br.com.senai.domain.Video;
import br.com.senai.util.BaseDeDados;

public class Principal {

	public static void main(String[] args) {
		
		BaseDeDados bd = new BaseDeDados();
		
		Video primeiroVideo = new Video(1, "Titulo 1", "Descrição curta 1", "url1", 100, Formato.AVI);
		Video segundoVideo = new Video(2, "Titulo 2", "Descrição curta 2", "url2", 200, Formato.MP4);
		Video terceiroVideo = new Video(3, "Titulo 3", "Descrição curta 3", "url3", 300, Formato.RMVB);
		Video quartoVideo = new Video(4, "Titulo 4", "Descrição curta 4", "url4", 400, Formato.AVI);
		
		bd.inserir(primeiroVideo);
		bd.inserir(segundoVideo);
		bd.inserir(terceiroVideo);		
		bd.inserir(quartoVideo);
		
		System.out.println(bd.getVideos());
		
		System.out.println("Sistema finalizado com sucesso");
			
	}

}
