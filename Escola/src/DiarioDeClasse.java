
public class DiarioDeClasse {

	private Aluno[] turma;
	private int codAluno;
	
	public DiarioDeClasse() {
		this.turma = new Aluno[100];
		this.codAluno = 0;
	}
	
	public void registrarAluno(Aluno aluno) {
		this.turma[codAluno] = aluno;
		this.codAluno++;
	}
	
}
