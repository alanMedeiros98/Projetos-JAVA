
public class Principal {

	public static void main(String[] args) {

		Pedreiro pedreiro = new Pedreiro();
		pedreiro.setCodigo(1);
		pedreiro.setNomeCompleto("Randolf Rodrigues");
		
		Serrote serrote = new Serrote();
		serrote.setCodigo(1);
		serrote.setCor(Cor.BRANCO);
		serrote.setDescricaoCurta("Serrote bom");
		serrote.setPeso(1.5);
		serrote.setQtdeDeDentes(7);
		
		Martelo martelo = new Martelo();
		martelo.setCodigo(2);
		martelo.setDescricaoCurta("Martelo Top");
		martelo.setPeso(0.5);
		martelo.setTipoDeCabo(TipoDeCabo.CABECA_POLIDA);
		
		pedreiro.usar(martelo);
		pedreiro.usar(serrote);

		System.out.println();
		
	}

}
