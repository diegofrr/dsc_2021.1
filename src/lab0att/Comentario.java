package lab0att;

import java.time.LocalDate;

public class Comentario {
	private String texto;
	private int id;
	private Aluno autor;
	private String data;
	
	public Comentario(String texto, int id, Aluno autor) {
		this.texto = texto;
		this.id = id;
		this.autor = autor;
		this.data = LocalDate.now().toString();
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
