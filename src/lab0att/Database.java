package lab0att;

import java.util.ArrayList;

public class Database {
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	private ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	private ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
	
	
	
	public Database() {
		Aluno a = new Aluno("Diêgo Ferreira", "diego", "123"); this.getListaAlunos().add(a);
		Disciplina d;
		d = new Disciplina("POO", 11111); this.listaDisciplinas.add(d);
		d = new Disciplina("BANCO DE DADOS", 22222); this.listaDisciplinas.add(d);
		d = new Disciplina("REDES", 33333); this.listaDisciplinas.add(d);
		
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
	
	public void removeComentario(Comentario c) {
		this.getListaComentarios().remove(c);
	}

	
}
