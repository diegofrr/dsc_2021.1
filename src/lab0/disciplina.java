package lab0;

import java.util.ArrayList;

public class Disciplina {
	
	private String nome;
	private int id;
	private Curso curso;
	private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();
	
	public Disciplina(String nome, int id, Curso curso) {
		this.nome = nome;
		this.id = id;
		this.curso = curso;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int _id) {
		this.id = _id;
	}
	
	public Curso getCurso() {
		return this.curso;
		
	}
	
	public void setCurso(Curso _curso) {
		this.curso = _curso;
	}
	
	public String toString() {
		return "Disciplina: " + this.nome + "(" + this.id + ") - " + this.curso;
	}
	
	public String getComentarios() {
		String text = "";
		
		for (Comentario coments : lista_comentarios) {
			text += coments.toString() + "\n";
		}
		return text;	
	}
	
	public void addComentario(Comentario _coment) {
		lista_comentarios.add(_coment);
	}
	
}
