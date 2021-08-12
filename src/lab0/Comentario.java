package lab0;

public class Comentario {
	private Aluno autor;
	private String texto;
	
	public Comentario(Aluno autor, String texto) {
		this.autor = autor;
		this.texto = texto;
	}
	
	public Aluno getAutor() {
		return this.autor;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public void setTexto(String _texto) {
		this.texto = _texto;
	}
	
	public String toString() {
		return this.autor + "\n" + this.texto;
	}

}
