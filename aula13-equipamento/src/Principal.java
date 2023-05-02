
public class Principal {

	public static void main(String[] args) {
		
		Tecnico tecnico = new Tecnico();
		tecnico.setCodigo(1);
		tecnico.setNomeCompleto("Roberto Carlos");
		
		Monitor monitor = new Monitor();
		monitor.setCodigo(1);
		monitor.setCor(Cor.BRANCO);
		monitor.setDescricaoCurta("Monitor Boladão");
		monitor.setFabricante("Dell");
		monitor.setPeso(4.0);
		monitor.setPolegadas(24.0);
		monitor.setVoltagem(Voltagem.V220);
		
		Notebook notebook = new Notebook();
		notebook.setCodigo(2);
		notebook.setDescricaoCurta("Notebook brabo");
		notebook.setDiscoRigido(1000);
		notebook.setFabricante("Seagate");
		notebook.setMemoriaRam(12);
		notebook.setModelo("AZ-666");
		notebook.setProcessador("i5-10110K");
		notebook.setVoltagem(Voltagem.V220);
		
		tecnico.reparar(notebook);
		tecnico.reparar(monitor);

	}

}
