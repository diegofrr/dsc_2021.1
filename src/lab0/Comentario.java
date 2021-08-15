package lab0;

public class Comentario {
	private Aluno autor;
	private String texto;
	private String data;
	
	public Comentario(Aluno autor, String texto, String data) {
		this.autor = autor;
		this.texto = texto;
		this.data = data;
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
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String _data) {
		this.data = _data;
	}
	
	public String toString() {
		return this.autor + " (" + this.data + ")"+ "\n" + this.texto;
	}

}
