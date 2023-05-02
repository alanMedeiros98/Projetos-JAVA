
public class Principal {

	public static void main(String[] args) {
		
		DiarioDeClasse diario = new DiarioDeClasse(1, "Programação de Aplicativos", 10);
		
		Aluno aluno1 = new Aluno();
		aluno1.setCodigo(1);
		aluno1.setNomeCompleto("Marcos da Silva");
		aluno1.getSituacao().setPrimeiraNota(8);
		aluno1.getSituacao().setSegundaNota(9);
		aluno1.getSituacao().setTerceiraNota(10);
		
		diario.registrar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setCodigo(2);
		aluno2.setNomeCompleto("Romário Antunes");
		aluno2.getSituacao().setPrimeiraNota(3);
		aluno2.getSituacao().setSegundaNota(5);
		aluno2.getSituacao().setTerceiraNota(7);
		
		diario.registrar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setCodigo(3);
		aluno3.setNomeCompleto("Roberval das neves");
		aluno3.getSituacao().setPrimeiraNota(2);
		aluno3.getSituacao().setSegundaNota(3);
		aluno3.getSituacao().setTerceiraNota(8);
		
		diario.registrar(aluno3);
		
		diario.fechar();
		
		Aluno[] turma = diario.listarAlunos();
		
		System.out.println("Fechamento do diário: " + diario.getCodigo() + " - " + diario.getUnidadeCurricular());
		for (Aluno aluno : turma) {
			System.out.println("Aluno: " + aluno.getCodigo() + " - " 
					+ aluno.getNomeCompleto() + " \n Média: " + aluno.getSituacao().getMedia()
					+ " - Situação: " + aluno.getSituacao().getStatus());
		}
		

	}

}
