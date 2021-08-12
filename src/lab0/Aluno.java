package lab0;

public class Aluno {
	
	private String nome;
	private int mat;
	private Curso curso;
	
	public Aluno(String nome, int mat, Curso curso) {
		this.nome = nome;
		this.mat = mat;
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
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public String toString() {
		return this.nome + "(" + this.mat + ") - " + this.curso;
	}
	
	
}
