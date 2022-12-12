package principal;

import java.util.ArrayList;

import classes.Cliente;
import telas.tlInicial;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Cliente> clientes = new ArrayList<>();
		tlInicial telaInicial = new tlInicial(clientes);
		telaInicial.setVisible(true);
		
	}

}
