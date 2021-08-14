package lab0;

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
				
				//AVALIAR DISC
				else if (opc == 2) {
					if (funcoes.disciplinas_vazias()) {
						JOptionPane.showMessageDialog(null, "Ainda n�o h� disciplinas cadastradas no sistema.");
						continue;
					}
					
					Disciplina discAvaliar = funcoes.escolherDisciplina();
					
				
				}
					
				else if(opc == 3) { //VER TODAS AVALIA��ES
					if(funcoes.disciplinas_vazias()) {
						JOptionPane.showMessageDialog(null, "Ainda n�o h� disciplinas cadastradas no sistema.");
						continue;
					}
					
					Disciplina _d = funcoes.escolherDisciplina();
					
					if(_d.getComentarios().size() == 0) {
						JOptionPane.showMessageDialog(null, "Esta disciplina ainda n�o tem nenhum coment�rio");
					}
					
					funcoes.comentariosStr(_d);
					JOptionPane.showMessageDialog(null, "Curtidas: " + _d.getLikes() + "\n"
							+ "Coment�rios: \n"
							+ funcoes.comentariosStr(_d));
					
				}
				
				else if (opc == 4) {
					// MINHAS AVAL
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
