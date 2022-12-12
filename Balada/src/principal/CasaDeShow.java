package principal;

public class CasaDeShow {

	boolean isEntradaLiberadaPara(Baladeiro baladeiro) {
		return baladeiro.idade >= 18 && baladeiro.documento != null;
	}
	
}
