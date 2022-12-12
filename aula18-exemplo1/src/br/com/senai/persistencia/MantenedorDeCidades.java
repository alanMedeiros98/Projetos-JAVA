package br.com.senai.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.domain.Cidade;

public class MantenedorDeCidades {
	
	private List<Cidade> cidades;
	
	public MantenedorDeCidades() {
		this.cidades = new ArrayList<Cidade>();
	}
	
	public void inserir(Cidade cidade) {
		if (cidade != null) {
			this.cidades.add(cidade);
		}else {
			throw new IllegalArgumentException(
					"A cidade não pode ser nula");
		}
	}

}
