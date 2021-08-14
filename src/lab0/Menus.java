package lab0;

import javax.swing.JOptionPane;

public class Menus {
	
	public int menuPrincipal() {
		while (true){
			String op = JOptionPane.showInputDialog("MENU\n\n"
					+ "1. ADICIONAR DISCIPLINA\n"
					+ "2. AVALIAR DISCIPLINA\n"
					+ "3. VER TODAS AVALIAÇÕES\n"
					+ "4. MINHAS AVALIAÇÕES\n"
					+ "5. SAIR");
			
			
			if (op == null) {
				return 5;
			}
			
			else if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5")) {
				JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
			}else {
				return Integer.parseInt(op);
			}
			
			
		}
	}

}
