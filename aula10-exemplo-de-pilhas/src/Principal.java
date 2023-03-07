
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Principal.metodo1();
		System.out.println("fim do main");
		
	}

	private static void metodo1() {
		System.out.println("inicio do metodo 1");
		Principal.metodo2();
		System.out.println("Fim do metodo 1");
	}
	
	private static void metodo2() {
		System.out.println("inicio do metodo 2");
		
		try {
			int[] numeros = new int[10];
			for(int i = 0; i < 15; i++) {
				numeros[i] = i;
				System.out.println(i);
			}
			System.out.println("Fim metodo 2");
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("ocorreu um erro: " + aioobe);
			aioobe.printStackTrace();
		}
		
		System.out.println("Fim do metodo 2!!");
		
	}
	
}
