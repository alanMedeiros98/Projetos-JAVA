package classes;

public class Livro {

	public String nome;
	public String descricao;
	public String isbn;
	public Double preco;
	public String autor;
	public String dataPub;
	
	public Livro() {
		
	}
	
	public Livro(String nome, String descricao, String isbn, Double preco, String autor, String dataPub) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.isbn = isbn;
		this.preco = preco;
		this.autor = autor;
		this.dataPub = dataPub;
	}

	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDataPub() {
		return dataPub;
	}

	public void setDataPub(String dataPub) {
		this.dataPub = dataPub;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", descricao=" + descricao + ", isbn=" + isbn + ", preco=" + preco + ", autor="
				+ autor + ", dataPub=" + dataPub + "]";
	}

	public void dadosLivro() {
		System.out.println("Nome: " + nome);
		System.out.println("Preço: " + preco);
		System.out.println("Autor: " + autor);
		System.out.println("Data de publicação: " + dataPub + "\n");
	}
	
}
