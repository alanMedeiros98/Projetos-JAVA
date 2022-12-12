
public class Principal {

	public static void main(String[] args) {
		
		Veterinario veterinario = new Veterinario();
		veterinario.setCodigo(1);
		veterinario.setNomeCompleto("João Silveira Burgues");
		
		Cachorro cachorro = new Cachorro();
		cachorro.setCodigo(1);
		cachorro.setNome("Bidu");
		cachorro.setPeso(5.0);
		cachorro.setPorte(Porte.MEDIO);
		
		DragaoDeKomodo dragao = new DragaoDeKomodo();
		dragao.setCodigo(2);
		dragao.setNome("Mike");
		dragao.setPeso(80.0);
		dragao.setQtdeDeDentes(50);
		dragao.setComprimento(2.60);
		
		veterinario.atender(dragao);
		veterinario.atender(cachorro);

	}

}
