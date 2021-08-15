package lab0;

import java.time.LocalDate;

import javax.swing.JOptionPane;
public class Sistema {
	
	static Functions funcoes = new Functions();
	
	public static void main(String[]args) {
		
		JOptionPane.showMessageDialog(null, LocalDate.now().toString());
		
		
		Aluno aluno_logado;
		boolean sair = false;
		while (sair == false){
		
		Object[] opcoes = { "FAZER LOGIN", "SE CADASTRAR"};
		int op = JOptionPane.showOptionDialog(null, "Bem-vindo!", "Sistema de Avaliação de Disciplinas", JOptionPane.DEFAULT_OPTION, 1, null, opcoes, opcoes[0]);
		
		if (op == 0) {
			int _mat = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula"));
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
							JOptionPane.showMessageDialog(null, "Já existe uma disciplina com esse ID");
						}else {
							Curso curso = funcoes.escolherCurso();
							Disciplina disc = new Disciplina(nome, id, curso);
							funcoes.addDisciplina(disc, curso);
							JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso");
							continue;
						}
					}
					
				}
				
				//AVALIAR DISC
				else if (opc == 2) {
					if (funcoes.disciplinas_vazias()) {
						JOptionPane.showMessageDialog(null, "Ainda não há disciplinas cadastradas no sistema.");
						continue;
					}
					
					Disciplina discAvaliar = funcoes.escolherDisciplina();
					
					if (discAvaliar == null) {continue;}
					
					if (funcoes.verificaAvaliou(aluno_logado, discAvaliar)) {
						int opcao = JOptionPane.showConfirmDialog(null, "Você já deixou um comentário sobre esta disciplina\n"
								+ "Comentário: " + discAvaliar.comentarioAluno(aluno_logado).getTexto() + "\n"
								+ "Dataa: " + discAvaliar.comentarioAluno(aluno_logado).getData() + "\n\n"
								+ "Deseja retirá-lo?", null, JOptionPane.YES_NO_OPTION);
						
						if (opcao == JOptionPane.YES_OPTION) {funcoes.removeComentario(aluno_logado, discAvaliar);}
						else {continue;}
					}else {
						//CASO NÃO TENHA DEIXADO COMENTÁRIO
						String comentario = JOptionPane.showInputDialog("Comentário");
						String data = LocalDate.now().toString();
						Comentario _c = new Comentario(aluno_logado, comentario, data);
						funcoes.addComentario(aluno_logado, discAvaliar, _c);
						JOptionPane.showMessageDialog(null, "Comentário adicionado com sucesso!");
						
					}
					
					if (funcoes.verificaGostou(aluno_logado, discAvaliar)) {
						
						int opcao = JOptionPane.showConfirmDialog(null, "Você já deixou o like nesta disciplina\n"
								+ "Deseja retirá-lo?", null, JOptionPane.YES_NO_OPTION);
						if (opcao == JOptionPane.YES_OPTION) {funcoes.removeLike(aluno_logado, discAvaliar);}
						
					} else {
						int deixarLike = JOptionPane.showConfirmDialog(null, "Deseja deixar o like nesta disciplina?", null, JOptionPane.YES_NO_OPTION);
						if (deixarLike == JOptionPane.YES_NO_OPTION) {funcoes.addLike(aluno_logado, discAvaliar);;}
						else if (deixarLike == JOptionPane.NO_OPTION) {continue;}
						else {continue;}
					
					}
				
				}
					
				else if(opc == 3) { //VER TODAS AVALIAÇÕES
					if(funcoes.disciplinas_vazias()) {
						JOptionPane.showMessageDialog(null, "Ainda não há disciplinas cadastradas no sistema.");
						continue;
					}
					
					Disciplina _d = funcoes.escolherDisciplina();
					if(_d == null) {continue;}
					
					if(_d.getComentarios().size() == 0) {
						JOptionPane.showMessageDialog(null, "Esta disciplina ainda não tem nenhum comentário");
						continue;
					}
					
					JOptionPane.showMessageDialog(null, "Curtidas: " + _d.getLikes() + "\n\n"
							+ "Comentários: \n"
							+ funcoes.comentariosNaDisciplinaStr(_d));
					
				}
				// MINHAS AVAL
				else if (opc == 4) {
					int opcao = funcoes.menu.menuAvaliacoes();
					
					if (opcao == 1) {
						if (aluno_logado.getComentarios().size() == 0) {
							JOptionPane.showMessageDialog(null, "Você ainda não comentou em nenhuma disciplina");
							continue;
						}
						JOptionPane.showMessageDialog(null, funcoes.comentariosDoAluno(aluno_logado));
					}
					else if (opcao == 2) {
						if (aluno_logado.getLista_UPs().size() == 0) {
							JOptionPane.showMessageDialog(null, "Você ainda não deixou like em nenhuma diciplina");
							continue;
						}
						JOptionPane.showMessageDialog(null, funcoes.disciplinasCurtidas(aluno_logado));
					}else {
						continue;
					}
				}
					
				else {
					JOptionPane.showMessageDialog(null, "Deslogando...");
					deslogar = true;
					op = 3;
					//SAIR DO SISTEMA
				}
				
				
			}
			
			}
		}
		
		else if (op == 1) {		
			String _nome = JOptionPane.showInputDialog("Digite seu nome");
			int _matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula"));
			boolean existe = funcoes.verifica_matricula(_matricula);
			if (existe) JOptionPane.showMessageDialog(null, "Matrícula já cadastrada!");
			
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
