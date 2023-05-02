
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PecaRegular moto = new PecaMoto(1, "pedal", "serve para pedalar", 100, 150);
		System.out.println(moto.Mostrar());
		
		
		PecaRegular carro = new PecaCarro(2, "Volante", "Serve para virar o carro.", 120, 4, 550);
		System.out.println(carro.Mostrar());
	}

}
