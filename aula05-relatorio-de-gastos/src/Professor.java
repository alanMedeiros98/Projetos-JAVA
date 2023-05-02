
public class Professor extends FuncionarioAdministrativo {

	private int horasAula;

	public Professor() {
		
	}
	
	public int getHorasAula() {
		return horasAula;
	}

	public void setHorasAula(int horasAula) {
		this.horasAula = horasAula;
	}
	
	public double getGasto() {
		return super.getGasto() + horasAula * 10;
	}
	
	public String getInfo() {
		String apresentacao = super.getInfo();
		return apresentacao + " - " + horasAula;
	}
	
}
