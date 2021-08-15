package lab0;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Functions {
	
	Base database = new Base();
	Menus menu = new Menus();
	
	
	public Disciplina discMaisCurtida() {
		int maisLikes = 0;
		Disciplina disc = new Disciplina();
		for (Disciplina d : database.get_lista_disciplinas()) {
			if (d.getLikes() > maisLikes) {
				maisLikes = d.getLikes();
				disc = d;		
			}
		}
		return disc;
	}
	
	public Curso escolherCurso() {
		ArrayList<Curso> listaCursos = database.get_lista_cursos();
		Object[] cursos = new Object[listaCursos.size()];
		for (int k = 0; k < listaCursos.size(); k++) { cursos[k] = listaCursos.get(k); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Escolha o curso", "Opção", JOptionPane.INFORMATION_MESSAGE, null, cursos, cursos[0]);
		return (Curso) valorSelecionado;	
	}
	
	public Disciplina escolherDisciplina() {
		ArrayList<Disciplina> listaDisc = database.get_lista_disciplinas();
		Object[] disciplinas = new Object[listaDisc.size()];
		for (int k = 0; k < listaDisc.size(); k++) { disciplinas[k] = listaDisc.get(k); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Escolha a disciplina", "Opção", JOptionPane.INFORMATION_MESSAGE, null, disciplinas, disciplinas[0]);
		return (Disciplina) valorSelecionado;
	}
	
	public boolean alunos_vazios() {
		if (database.get_lista_alunos().size() == 0) {
			return true;
		}return false;
		}
	
	public boolean cursos_vazios() {
		if (database.get_lista_cursos().size() == 0) {
			return true;
		}return false;
	}
	
	public boolean disciplinas_vazias() {
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
	
	public void addDisciplina(Disciplina _d, Curso _c) {
		database.get_lista_disciplinas().add(_d);
		_c.getDisciplinas().add(_d);
	}
	
	public Aluno logar(int mat, String senha){
		for (Aluno a : database.get_lista_alunos()) {
			if (a.getMatricula() == mat && a.getSenha().equals(senha)) {
				return a;
			}
		}return null;
	}
	
	public boolean verifica_curso(int _id) {
		for (Curso c : database.get_lista_cursos()) {
			if (c.getId() == _id) {
				return true;
			}
		}return false;
	}
	
	public String listarDisciplinas(Curso curso) {
		String listaStr = "";
		for (Disciplina d : curso.getDisciplinas()) {
			listaStr += d.toString() + "\n";
		}
		return listaStr;
	}
	
	public boolean verificaIdDisciplina(int id) {
		for (Disciplina d : database.get_lista_disciplinas()) {
			if (d.getId() == id) {
				return true;
			}
		}return false;
	}
	
	public String comentariosNaDisciplinaStr(Disciplina d) {
		String comentariosStr = "";
		for (Comentario c : d.getComentarios()) {
			comentariosStr += c.toString();
		}
		return comentariosStr;
	}
	
	public boolean verificaAvaliou(Aluno _a, Disciplina _d) {
		for (Comentario c : _d.getComentarios()) {
			if (c.getAutor() == _a) {
				return true;
			}
		}return false;
	}
	
	public boolean verificaGostou(Aluno _a, Disciplina _d) {
		for (Disciplina disc : _a.getLista_UPs()) {
			if (disc == _d) {
				return true;
			}
		}
		return false;
	}
	
	public void removeLike(Aluno _a, Disciplina _d) {
		_d.removeLike();
		_a.removeLike(_d);
		
	}
	
	public void removeComentario(Aluno _a, Disciplina _d) {
		for (Comentario c : _d.getComentarios()) {
			if (c.getAutor() == _a) {
				_d.getComentarios().remove(c);
			}
		}
	}
	
	public void addComentario(Aluno _a, Disciplina _d, Comentario _c) {
		_a.addComentario(_c);
		_d.addComentario(_c);
	}
	
	public void addLike(Aluno _a, Disciplina _d) {
		_a.getLista_UPs().add(_d);
		_d.addLike();
	}
	
	public String disciplinasCurtidas(Aluno _a) {
		String txt = "";
		for (Disciplina d : _a.getLista_UPs()) {
			txt += d.toString();
		}return txt;
	}
	
	public String comentariosDoAluno(Aluno _a) {
		String txt = "";
		for (Disciplina d : database.get_lista_disciplinas()) {
			for (Comentario c : d.getComentarios()) {
				if (c.getAutor().equals(_a)) {
					txt += d.getNome()  + " (" + d.getId() + ") -  " + c.getData() + "\n"
							+ "Comentário: " + c.getTexto() + "\n\n";
				}
			}
			
		}return txt;
		
	}
		
}
