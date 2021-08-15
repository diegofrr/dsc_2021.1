package lab0att;

import java.util.ArrayList;

public class Database {
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	private ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	private ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
	
	
	
	public Database() {
		Aluno a = new Aluno("Diêgo Ferreira", "diego", "123"); this.getListaAlunos().add(a);
		Disciplina d = new Disciplina("POO", 11111); this.getListaDisciplinas().add(d);
	}
	
	public ArrayList<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public ArrayList<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public ArrayList<Comentario> getListaComentarios() {
		return listaComentarios;
	}

	
}
