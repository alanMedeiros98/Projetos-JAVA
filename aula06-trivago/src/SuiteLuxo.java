
public class SuiteLuxo extends Quarto {

	private final double DESCONTO_CONCEDIDO = 0.08;
	
	public SuiteLuxo(int codigo, String descricao, double valorDiaria) {
		super(codigo, descricao, valorDiaria);
	}
	
	public double aplicarDesconto() {
		double diariaComDesconto = getValorDiaria() - (getValorDiaria() * DESCONTO_CONCEDIDO);
		return diariaComDesconto;
	}
	
}
