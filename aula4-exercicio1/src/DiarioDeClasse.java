
public class DiarioDeClasse {
	
	private int codigo;
	
	private String unidadeCurricular;
	
	private Aluno[] turma;
	
	private int indiceDaTurma;
	
	public DiarioDeClasse(int codigo, String unidadeCurricular, int qtdeDeAlunos) {
		this.codigo = codigo;
		this.unidadeCurricular = unidadeCurricular;
		this.turma = new Aluno[qtdeDeAlunos];
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getUnidadeCurricular() {
		return unidadeCurricular;
	}

	public void registrar(Aluno aluno) {
		this.turma[indiceDaTurma] = aluno;
		this.indiceDaTurma++;
	}
	
	public void fechar() {
		for (Aluno aluno : turma) {
			if (aluno != null && aluno.getSituacao() != null) {
				double media = (aluno.getSituacao().getPrimeiraNota() 
						+ aluno.getSituacao().getSegundaNota()
						+ aluno.getSituacao().getTerceiraNota()) / 3.0;
				aluno.getSituacao().setMedia(media);
				if (media > 7) {
					aluno.getSituacao().setStatus('A');
				}else {
					aluno.getSituacao().setStatus('R');
				}
			}
		}
	}
	
	public Aluno[] listarAlunos() {
		
		Aluno[] turmaFinalizada = new Aluno[indiceDaTurma];
		
		for (int i = 0; i < indiceDaTurma; i++) {
			Aluno aluno = turma[i];
			turmaFinalizada[i] = aluno;
		}
		
		return turmaFinalizada;
		
	}

}
