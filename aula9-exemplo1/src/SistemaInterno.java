
public class SistemaInterno {

	public void autorizarAcessoDo(Autenticavel usuario) {
		
		if(usuario.autenticar(123)) {
			System.out.println("o funcionario esta autorizado!!");
		} else {
			System.out.println("o funcionario foi barrado!!");
		}
	}
	
}
