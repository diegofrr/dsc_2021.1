package lab0;

import java.util.ArrayList;

public class Aluno {
	
	private String nome;
	private int mat;
	private String senha;
	private Curso curso;
	private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();
	private ArrayList<Disciplina> lista_UPs = new ArrayList<Disciplina>();
	
	public Aluno(String nome, int mat, String senha, Curso curso) {
		this.nome = nome;
		this.mat = mat;
		this.senha = senha;
		this.curso = curso;		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public int getMatricula() {
		return this.mat;
	}
	
	public void setMatricula(int _mat) {
		this.mat = _mat;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String _s) {
		this.senha = _s;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public ArrayList<Disciplina> getLista_UPs(){
		return this.lista_UPs;
	}
	
	public void removeLike(Disciplina _d) {
		this.getLista_UPs().remove(_d);
	}
	
	public String toString() {
		return this.nome + " (" + this.mat + ") - " + this.curso;
	}
	
	public ArrayList<Comentario> getComentarios(){
		return this.lista_comentarios;
	}

	
	public void addComentario(Comentario _coment) {
		lista_comentarios.add(_coment);
	}
	
	
}
