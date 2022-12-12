
public class Relatorio {

	private double totalGeral;
	private double totalSingle;
	private double totalSuiteLuxo;
	private double totalLuxoDuplo;
	
	public Relatorio(double totalGeral, double totalSingle, double totalSuiteLuxo, double totalLuxoDuplo) {
		super();
		this.totalGeral = totalGeral;
		this.totalSingle = totalSingle;
		this.totalSuiteLuxo = totalSuiteLuxo;
		this.totalLuxoDuplo = totalLuxoDuplo;
	}

	public double getTotalGeral() {
		return totalGeral;
	}

	public double getTotalSingle() {
		return totalSingle;
	}

	public double getTotalSuiteLuxo() {
		return totalSuiteLuxo;
	}

	public double getTotalLuxoDuplo() {
		return totalLuxoDuplo;
	}
	
	
	
}
