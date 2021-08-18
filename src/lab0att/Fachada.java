package lab0att;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Fachada {

	Database database = new Database();
	Menus menu = new Menus();
	
	public Aluno login(String email, String senha) {
		for (Aluno a : database.getListaAlunos()) {
			if(a.getEmail().equals(email) && a.getSenha().equals(senha)) {
				return a;
			}
		}return null;
	}	
	
	public void addDisciplina(Disciplina disciplina) {
		database.getListaDisciplinas().add(disciplina);
	}
	
	public String disciplinasCadastradas() {
		String disciplinas = "";
		for (Disciplina d : database.getListaDisciplinas()) {
			disciplinas += d.toString() + "\n";
		}return disciplinas;
	}
	
	
	public boolean verificaId(int id) {
		for (Disciplina d : database.getListaDisciplinas()) {
			if (d.getId() == id) {
				return true;
			}
		}return false;
	}
	
	public Disciplina escolherDisciplina() {
		ArrayList<Disciplina> listaDisc = database.getListaDisciplinas();
		Object[] disciplinas = new Object[listaDisc.size()];
		for (int k = 0; k < listaDisc.size(); k++) { disciplinas[k] = listaDisc.get(k); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Escolha a disciplina", "Opção", JOptionPane.INFORMATION_MESSAGE, null, disciplinas, disciplinas[0]);
		return (Disciplina) valorSelecionado;
	}
	
	public void addLike(Disciplina d){
		d.addLike();
	}
	
	public boolean verificaComentou(Aluno aluno, Disciplina disc) {
		for (Disciplina d : database.getListaDisciplinas()) {
			for (Comentario c : d.getComentarios()) {
				if (c.getAutor() == aluno) {
					return true;
				}
			}
		}return false;
	}
	
	public void addComentario(Comentario c, Disciplina d, double nota) {
		d.getComentarios().add(c);
		d.setNota(nota);
		d.addAvaliacao();
		database.getListaComentarios().add(c);
		
	}
	
	public Disciplina buscaDisciplina(int id) {
		for (Disciplina d : database.getListaDisciplinas()) {
			if (d.getId() == id) {
				return d;
			}
		}return null;
	}
	
	public String diciplinasMaisVotadas() {
		String txt = "";
		ArrayList<Disciplina> disc = database.getListaDisciplinas();
		double maiorNota = 0.0;
		for (Disciplina d : disc) {
			if (d.getNota() >= maiorNota) {
				maiorNota = d.getNota();
				txt += d.toString() + "\n";
				disc.remove(d);
			}
		}return txt;
		
	}
	
	public Comentario buscaComentario(int id) {
		for (Comentario c : database.getListaComentarios()) {
			if (c.getId() == id) {
				return c;
			}
		}return null;
	}
	
	public void removeComentario(Comentario c) {
		for (Disciplina d : database.getListaDisciplinas()) {
			if (d.getComentarios().contains(c)) {
				d.removeComentario(c);
				database.removeComentario(c);
			}
		}
	}
	
}
