package lab0att;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Sistema {
	
	public static final String NAO_HA_DISCIPLINAS = "Ainda não há disciplinas cadastradas no sistema.";
	
	
	public static void main(String[]args) {
		Fachada funcoes = new Fachada();
		Aluno alunoLogado;
		
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
							String nome = JOptionPane.showInputDialog("Nome da disciplina");
							int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID"));
							if (funcoes.verificaId(id)) {
								JOptionPane.showMessageDialog(null, "Já existe uma disciplina com esse mesmo ID.");
								continue;
							}
							Disciplina novaDisciplina = new Disciplina(nome, id);
							funcoes.addDisciplina(novaDisciplina);
							JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
							continue;
							
							
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
							
							Disciplina disciplinaAvaliar = funcoes.escolherDisciplina();
							
							if (funcoes.verificaComentou(alunoLogado, disciplinaAvaliar)) {
								JOptionPane.showMessageDialog(null, "Você já avaliou essa disciplina");
								continue;
							}					
							String texto = JOptionPane.showInputDialog("Comentário sobre a disciplina");
							int id = Integer.parseInt(JOptionPane.showInputDialog("ID do comentário"));
							String data = LocalDate.now().toString();
							Comentario coment = new Comentario(texto, id, alunoLogado, data);
							double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota da disciplina"));
							
							funcoes.addComentario(coment, disciplinaAvaliar, nota);
							
							
							int deixarLike = JOptionPane.showConfirmDialog(null, "Deseja deixar o like nesta disciplina?", null, JOptionPane.YES_NO_OPTION);
							if (deixarLike == JOptionPane.YES_NO_OPTION) {funcoes.addLike(disciplinaAvaliar);;}
							else if (deixarLike == JOptionPane.NO_OPTION) {continue;}
							else {continue;}
							
							
							
							
							
						}else if (opcaoSecundaria == 4) {
							if (funcoes.database.getListaDisciplinas().size() == 0) {
								JOptionPane.showMessageDialog(null, NAO_HA_DISCIPLINAS);
								continue;
							}
							Disciplina disciplina = funcoes.escolherDisciplina();
							String nome = JOptionPane.showInputDialog("Digite o novo nome");
							disciplina.setNome(nome);
							JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
						}
						
						
						
						else if (opcaoSecundaria == 404) {
							
						}else {
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
