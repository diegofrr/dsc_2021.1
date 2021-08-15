package lab0att;

import javax.swing.JOptionPane;

public class Menus {
	
	public int menuInicial() {
		Object[] opcoes = { "FAZER LOGIN", "SE CADASTRAR"};
		int op = JOptionPane.showOptionDialog(null, "Bem-vindo!", "Sistema de Avaliação de Disciplinas", JOptionPane.DEFAULT_OPTION, 1, null, opcoes, opcoes[0]);
		if (op != 0 && op != 1) {return 404;}
		return op;
	}
	
	public int menuPrincipal() {
		while (true){
			String op = JOptionPane.showInputDialog(
					"1. ADICIONAR DISCIPLINA\n"
					+ "2. VER DISCIPLINAS\n"
					+ "3. AVALIAR DISCIPLINA\n"
					+ "4. ATUALIZAR NOME DA DISCIPLINA\n"
					+ "5. MINHAS AVALIAÇÕES\n"
					+ "6. SAIR");
			
			
			if (op == null) {
				return 5;
			}
			
			else if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5")) {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}else {
				return Integer.parseInt(op);
			}	
		}
	}
	
}
