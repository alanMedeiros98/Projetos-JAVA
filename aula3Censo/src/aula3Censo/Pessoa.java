package aula3Censo;

public class Pessoa {

	private char sexo;
	private int idade;
	private double renda;
	private boolean isEmpregado;
	
	public Pessoa() {
		
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public boolean isEmpregado() {
		return isEmpregado;
	}

	public void setEmpregado(boolean isEmpregado) {
		this.isEmpregado = isEmpregado;
	}
	
	
	
}
