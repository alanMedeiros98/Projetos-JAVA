
public class GeradorDeFuncionarios {

	public static final int TIPO_GERENTE = 1;
	
	public static final int TIPO_SUPERVISOR = 2;
	
	public Funcionario criarPor(int tipo) {
		
		Funcionario funcionarioCriado = null;
		
		if(tipo == TIPO_GERENTE) {
			funcionarioCriado = new Gerente();
		} else if(tipo == TIPO_SUPERVISOR) {
			funcionarioCriado = new Supervisor(); 
		}
		
		return funcionarioCriado;
	}
	
}
