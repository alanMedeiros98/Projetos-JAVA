package br.com.senai.dao;

import java.util.List;

import br.com.senai.domain.Paciente;

public interface DaoPaciente {

	public void inserir(Paciente paciente);
	
	public void alterar(Paciente paciente);
	
	public List<Paciente> listarPor(String pacientes);
	
	public void excluir(int id);
	
}
