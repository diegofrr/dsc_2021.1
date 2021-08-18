package lab0att;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Sistema {
	
	public static final String NAO_HA_DISCIPLINAS = "Ainda não há disciplinas cadastradas no sistema.";
	public static final String ID_INVALIDO = "ID inválido!";
	public static final String DISCIPLINA_NAO_ENCONTRADA = "Disciplina não encontrada";
	
	
	public static void main(String[]args) {
		Fachada funcoes = new Fachada();
		Aluno alunoLogado;
		
		Disciplina d = funcoes.escolherDisciplina();
		JOptionPane.showMessageDialog(null, d.getLikes());
		
		boolean sair = false;
		while(sair == false) {
			
			int opcao = funcoes.menu.menuInicial();
			if (opcao == 0) { // FAZER LOGIN
				String email = JOptionPane.showInputDialog("Seu e-mail");
				String senha = JOptionPane.showInputDialog("Sua senha");
				alunoLogado = funcoes.login(email, senha);
				if(alunoLogado == null) {JOptionPane.showMessageDialog(null, "Falha no login.");}
				else {
					JOptionPane.showMessageDialog(null, "Bem vindo, " + alunoLogado.getNome().split(" ")[0] + "!");
					
					
					boolean deslogar = false;
					while(deslogar == false) {
						int opcaoSecundaria = funcoes.menu.menuPrincipal();
						
						if (opcaoSecundaria == 1) {
							try {
								
								String nome = JOptionPane.showInputDialog("Nome da disciplina"); if (nome == null) continue;
								int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID"));
								if (funcoes.verificaId(id)) {
									JOptionPane.showMessageDialog(null, "Já existe uma disciplina com esse mesmo ID.");
									continue;
								}
								Disciplina novaDisciplina = new Disciplina(nome, id);
								funcoes.addDisciplina(novaDisciplina);
								JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
								continue;
								
							}catch(NumberFormatException e) {
								
							}					
							
						}else if (opcaoSecundaria == 2) {
							if (funcoes.database.getListaDisciplinas().size() == 0) {
								JOptionPane.showMessageDialog(null, NAO_HA_DISCIPLINAS);
								continue;
							}
							JOptionPane.showMessageDialog(null, funcoes.disciplinasCadastradas());
						}
						
						
						
						
						else if (opcaoSecundaria == 3) {
							if (funcoes.database.getListaDisciplinas().size() == 0) {
								JOptionPane.showMessageDialog(null, NAO_HA_DISCIPLINAS);
								continue;
							} 
							
							try {
								String idStr = JOptionPane.showInputDialog("ID da disciplina");
								if (idStr == null) {continue;}
								int id = Integer.parseInt(idStr);
								Disciplina disciplina = funcoes.buscaDisciplina(id);							
								if (disciplina == null) {
									JOptionPane.showMessageDialog(null, DISCIPLINA_NAO_ENCONTRADA);
									continue;
								}else if (funcoes.verificaComentou(alunoLogado, disciplina)) {
									JOptionPane.showMessageDialog(null, "Você já deixou avaliou esta disciplina");
									continue;
								}
								
								String texto = JOptionPane.showInputDialog("Comentário sobre a disciplina");
								
								if (texto == null) {continue;}
								
								int idComentario = Integer.parseInt(JOptionPane.showInputDialog("ID do comentário"));
								String data = LocalDate.now().toString();
								Comentario coment = new Comentario(texto, idComentario, alunoLogado);
								double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota da disciplina"));
								funcoes.addComentario(coment, disciplina, nota);							
								int deixarLike = JOptionPane.showConfirmDialog(null, "Deseja deixar o like nesta disciplina?", null, JOptionPane.YES_NO_OPTION);
								if (deixarLike == JOptionPane.YES_NO_OPTION) {funcoes.addLike(disciplina);}
								JOptionPane.showMessageDialog(null, "Avaliação registrada com sucesso");
								
							}catch(NumberFormatException e) {
								JOptionPane.showMessageDialog(null, ID_INVALIDO);
							}
				
							
						}else if (opcaoSecundaria == 4) {
							if (funcoes.database.getListaDisciplinas().size() == 0) {
								JOptionPane.showMessageDialog(null, NAO_HA_DISCIPLINAS);
								continue;
							}
							
							try {
								int id = Integer.parseInt(JOptionPane.showInputDialog("ID da disciplina"));
								Disciplina disciplina = funcoes.buscaDisciplina(id);
								
								if (disciplina == null) {
									JOptionPane.showMessageDialog(null, "Nenhum disciplina encontrada");
									continue;
								}
								
								String nome = JOptionPane.showInputDialog("Digite o novo nome"); if(nome == null) continue;
								disciplina.setNome(nome);
								JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
								
							}catch(NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "ID inválido!");
							}			
						}
						
						
						
						else if (opcaoSecundaria == 5) {
							try {
								int id = Integer.parseInt(JOptionPane.showInputDialog("ID do comentário"));
								Comentario c = funcoes.buscaComentario(id);
								if (c == null) {
									JOptionPane.showMessageDialog(null, "Nenhum comentário encontrado");
									continue;
								}
								funcoes.removeComentario(c);
								JOptionPane.showMessageDialog(null, "Comentário removido!");
								
							}catch(NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "ID inválido!");
							}

							
						}else if (opcaoSecundaria == 6) {
							JOptionPane.showMessageDialog(null, funcoes.diciplinasMaisVotadas());
							
							
						}else if(opcaoSecundaria == 7) {
							break;
						}
						
						
						
						else {
							JOptionPane.showMessageDialog(null, "Opção inválida!");
							continue;
						}
					}
					
					
					
				}
			}
			else if (opcao == 1) {// SE CADASTRAR
				
			}else if (opcao == 404) {// SAIR DO SISTEMA
				break;
			}else {
				break;
			}
		
		
	}
	
		
		
		
		

	
}

}
