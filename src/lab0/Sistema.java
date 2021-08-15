package lab0;

import java.time.LocalDate;

import javax.swing.JOptionPane;
public class Sistema {
	
	static Functions funcoes = new Functions();
	
	public static void main(String[]args) {

		Aluno aluno_logado;
		boolean sair = false;
		while (sair == false){
		
		Object[] opcoes = { "FAZER LOGIN", "SE CADASTRAR"};
		int op = JOptionPane.showOptionDialog(null, "Bem-vindo!", "Sistema de Avalia��o de Disciplinas", JOptionPane.DEFAULT_OPTION, 1, null, opcoes, opcoes[0]);
		
		if (op == 0) {
			
			if(funcoes.alunos_vazios()) {JOptionPane.showMessageDialog(null, "N�o h� cadastros no sistema.\n"); continue;}
			
			int _mat = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matr�cula"));
			String _senha = JOptionPane.showInputDialog("Digite sua senha");
			aluno_logado = funcoes.logar(_mat, _senha);
			if (aluno_logado == null) {
				JOptionPane.showMessageDialog(null, "Falha no login!");
				continue;
			}
			else {
				JOptionPane.showMessageDialog(null, "Bem vindo,  " + aluno_logado.getNome().split(" ")[0] + "!");
				
				boolean deslogar = false;
				while (deslogar == false) {
					
				int opc = funcoes.menu.menuPrincipal();
				
				if (opc == 1) { //ADD DISCIPLINA
					
					String nome = JOptionPane.showInputDialog("Nome da disciplina");
					int id = Integer.parseInt(JOptionPane.showInputDialog("ID da disciplina"));
					if (funcoes.disciplinas_vazias()) {
						Curso curso = funcoes.escolherCurso();
						Disciplina disc = new Disciplina(nome, id, curso);
						funcoes.addDisciplina(disc, curso);
						JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso");
						continue;
					}else {
						if (funcoes.verificaIdDisciplina(id)) {
							JOptionPane.showMessageDialog(null, "J� existe uma disciplina com esse ID");
						}else {
							Curso curso = funcoes.escolherCurso();
							Disciplina disc = new Disciplina(nome, id, curso);
							funcoes.addDisciplina(disc, curso);
							JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso");
							continue;
						}
					}
					
				}
				
				//Avaliar uma disciplina
				else if (opc == 2) {
					if (funcoes.disciplinas_vazias()) {
						JOptionPane.showMessageDialog(null, "Ainda n�o h� disciplinas cadastradas no sistema.");
						continue;
					}
					
					Disciplina discAvaliar = funcoes.escolherDisciplina();
					
					if (discAvaliar == null) {continue;}
					
					if (funcoes.verificaAvaliou(aluno_logado, discAvaliar)) {
						int opcao = JOptionPane.showConfirmDialog(null, "Voc� j� deixou um coment�rio sobre esta disciplina\n"
								+ "Coment�rio: " + discAvaliar.comentarioAluno(aluno_logado).getTexto() + "\n"
								+ "Data: " + discAvaliar.comentarioAluno(aluno_logado).getData() + "\n\n"
								+ "Deseja retir�-lo?", null, JOptionPane.YES_NO_OPTION);
						
						if (opcao == JOptionPane.YES_OPTION) {funcoes.removeComentario(aluno_logado, discAvaliar);}
						else {continue;}
					}else {

						String comentario = JOptionPane.showInputDialog("Coment�rio");
						String data = LocalDate.now().toString();
						Comentario _c = new Comentario(aluno_logado, comentario, data);
						funcoes.addComentario(aluno_logado, discAvaliar, _c);
						JOptionPane.showMessageDialog(null, "Coment�rio adicionado com sucesso!");
						
					}
					
					if (funcoes.verificaGostou(aluno_logado, discAvaliar)) {
						
						int opcao = JOptionPane.showConfirmDialog(null, "Voc� j� deixou o like nesta disciplina\n"
								+ "Deseja retir�-lo?", null, JOptionPane.YES_NO_OPTION);
						if (opcao == JOptionPane.YES_OPTION) {funcoes.removeLike(aluno_logado, discAvaliar);}
						
					} else {
						int deixarLike = JOptionPane.showConfirmDialog(null, "Deseja deixar o like nesta disciplina?", null, JOptionPane.YES_NO_OPTION);
						if (deixarLike == JOptionPane.YES_NO_OPTION) {funcoes.addLike(aluno_logado, discAvaliar);;}
						else if (deixarLike == JOptionPane.NO_OPTION) {continue;}
						else {continue;}
					
					}
				
				}
					
				else if(opc == 3) { //Avalia��es de todos os alunos numa determinada disciplina
					if(funcoes.disciplinas_vazias()) {
						JOptionPane.showMessageDialog(null, "Ainda n�o h� disciplinas cadastradas no sistema.");
						continue;
					}
					
					Disciplina _d = funcoes.escolherDisciplina();
					if(_d == null) {continue;}
					
					if(_d.getComentarios().size() == 0) {
						JOptionPane.showMessageDialog(null, "Esta disciplina ainda n�o tem nenhum coment�rio");
						continue;
					}
					
					JOptionPane.showMessageDialog(null, "Curtidas: " + _d.getLikes() + "\n\n"
							+ "Coment�rios: \n"
							+ funcoes.comentariosNaDisciplinaStr(_d));
					
				}
				else if (opc == 4) {//Todas avalia��es do aluno logado
					int opcao = funcoes.menu.menuAvaliacoes();
					
					if (opcao == 1) {
						if (aluno_logado.getComentarios().size() == 0) {
							JOptionPane.showMessageDialog(null, "Voc� ainda n�o comentou em nenhuma disciplina");
							continue;
						}
						JOptionPane.showMessageDialog(null, "Voc� comentou em " + aluno_logado.getComentarios().size() + " disciplinas.\n\n" + funcoes.comentariosDoAluno(aluno_logado));
					}
					else if (opcao == 2) {
						if (aluno_logado.getLista_UPs().size() == 0) {
							JOptionPane.showMessageDialog(null, "Voc� ainda n�o deixou like em nenhuma diciplina");
							continue;
						}
						JOptionPane.showMessageDialog(null, funcoes.disciplinasCurtidas(aluno_logado));
					}else {
						continue;
					}
				}
					
				else {//Saindo do sistema
					JOptionPane.showMessageDialog(null, "Deslogando...");
					deslogar = true;
					op = 3;
				}
				
				
			}
			
			}
		}
		
		else if (op == 1) {		
			String _nome = JOptionPane.showInputDialog("Digite seu nome");
			int _matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matr�cula"));
			boolean existe = funcoes.verifica_matricula(_matricula);
			if (existe) JOptionPane.showMessageDialog(null, "Matr�cula j� cadastrada!");
			
			else {
				String _senha = JOptionPane.showInputDialog(null, "Digite uma senha para logar no sistema.");
				Curso curso = funcoes.escolherCurso();
				Aluno _aluno = new Aluno(_nome, _matricula, _senha, curso);
				funcoes.addAluno(_aluno);
				curso.addAluno(_aluno);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				
			}
			
			
		}else if(op == 2) {
			sair = true;
		}
		else {
			break;
		}
		}
		
		
		
		
	}

}
