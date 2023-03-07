import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SistemaDeCadastro sistema = new SistemaDeCadastro();
		
		try {
			Cliente cliente = new Cliente(1, "Alan Duarte de Medeiros", "65453215");
			sistema.registrar(cliente);
		}catch(ErroNoRegistroException ere){
			ere.printStackTrace();
			JOptionPane.showMessageDialog(null, ere.getMessage());
		}catch (NomeObrigatorioException noe) {
			noe.printStackTrace();
			JOptionPane.showMessageDialog(null, noe.getMessage());
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}
