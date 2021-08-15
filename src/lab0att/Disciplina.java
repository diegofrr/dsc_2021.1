package lab0att;

import java.util.ArrayList;

public class Disciplina {
	
	private int id;
	private String nome;
	private ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
	private int likes = 0;
	private double nota = 0;
	private int quantAvl = 0;
	
	public Disciplina(String nome, int id) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLikes() {
		return this.likes;
	}
	
	public void addLike() {
		this.likes += 1;
	}
	
	public String toString() {
		return this.nome + " (" + this.id + ") Likes: " + this.likes;
	}
	
	public double getNota() {
		return this.nota / this.quantAvl;
	}
	
	public void setNota(double nota) {
		this.nota += nota;
	}
	
	public int getQuantAval() {
		return this.quantAvl;
	}
	
	public void addAvaliacao() {
		this.quantAvl += 1;
	}
	
	public ArrayList<Comentario> getComentarios(){
		return this.listaComentarios;
	}

}
