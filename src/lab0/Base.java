package lab0;

import java.util.ArrayList;

public class Base {
	private ArrayList<Curso> lista_cursos = new ArrayList<Curso>();
	private ArrayList<Aluno> lista_alunos = new ArrayList<Aluno>();
	private ArrayList<Disciplina> lista_disciplinas = new ArrayList<Disciplina>();
	
	public ArrayList<Curso> get_lista_cursos(){
		return lista_cursos;
	}
	
	public ArrayList<Aluno> get_lista_alunos(){
		return lista_alunos;
	}
	
	public ArrayList<Disciplina> get_lista_disciplinas(){
		return lista_disciplinas;
	}

}
