package lab0;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Functions {
	
	Base database = new Base();
	
	
	public Curso escolherCurso() {
		ArrayList<Curso> listaCursos = database.get_lista_cursos();
		Object[] cursos = new Object[listaCursos.size()];
		for (int k = 0; k < listaCursos.size(); k++) { cursos[k] = listaCursos.get(k); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Curso", "Op��o", JOptionPane.INFORMATION_MESSAGE, null, cursos, cursos[0]);
		return (Curso) valorSelecionado;	
	}
	
	public boolean verifica_alunos() {
		if (database.get_lista_alunos().size() == 0) {
			return true;
		}return false;
		}
	
	public boolean verifica_cursos() {
		if (database.get_lista_cursos().size() == 0) {
			return true;
		}return false;
	}
	
	public boolean verifica_disciplinas() {
		if (database.get_lista_disciplinas().size() == 0) {
			return true;
		}return false;
	}
	
	public boolean verifica_matricula(int matricula) {
		for (Aluno a : database.get_lista_alunos()) {
			if (a.getMatricula() == matricula) {
				return true;
			}
		}return false;
	}
	
	public void addAluno(Aluno _a) {
		database.get_lista_alunos().add(_a);
	}
	
	public void addCurso(Curso _c) {
		database.get_lista_cursos().add(_c);
	}
	
	public void addDisciplina(Disciplina _d) {
		database.get_lista_disciplinas().add(_d);
	}
	
	
}