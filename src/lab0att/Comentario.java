package lab0att;

public class Comentario {
	private String texto;
	private int id;
	private Aluno autor;
	private String data;
	
	public Comentario(String texto, int id, Aluno autor, String data) {
		this.texto = texto;
		this.id = id;
		this.autor = autor;
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAutor() {
		return autor;
	}

	public void setAutor(Aluno autor) {
		this.autor = autor;
	}
	
	public String getData() {
		return this.data;
	}

}
