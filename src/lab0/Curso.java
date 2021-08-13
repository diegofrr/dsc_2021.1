package lab0;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Curso {
	
	private String nome;
	private int id;
	private ArrayList<Aluno> lista_alunos = new ArrayList<Aluno>();
	private ArrayList<Disciplina> lista_disciplinas = new ArrayList<Disciplina>();
	
	public Curso(String nome, int id) {
		this.nome = nome;
		this.id = id;
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
	
	public ArrayList<Disciplina> getDisciplinas(){
		return this.lista_disciplinas;
	}
	
	public ArrayList<Aluno> getAlunos(){
		return lista_alunos;
	}
	
	public void addAluno(Aluno _aluno) {
		lista_alunos.add(_aluno);
	}
	
	public void removeAluno(int _matricula) {
		for (Aluno aluno : lista_alunos) {
			if (aluno.getMatricula() == _matricula) {
				lista_alunos.remove(aluno);
				JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
			}
		}
	}
	
	
	public void addDiscplinas(Disciplina _disc) {
		lista_disciplinas.add(_disc);
	}
	
	public String toString() {
		return this.nome;

	}
	
	public String toStringAll() {
		return this.nome + "(" + this.id + ")";
	}
	
}
