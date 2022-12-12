package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Equipamento;

public interface DaoEquipamento {

	public void inserir(Equipamento equipamento);
	
	public void alterar(Equipamento equipamento);
	
	public void excluirPor(int id);
	
	public Equipamento buscarPor(int id);
	
	public List<Equipamento> listarPor(String descricaoCurta);
	
}
