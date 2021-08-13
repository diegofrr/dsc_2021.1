package lab0;

import javax.swing.JOptionPane;

public class Menus {
	
	public int menuPrincipal() {
		while (true){
			String op = JOptionPane.showInputDialog("MENU\n\n"
					+ "1. AVALIAR DISCIPLINA\n"
					+ "2. VER TODAS AVALIAÇÕES\n"
					+ "3. MINHAS AVALIAÇÕES\n"
					+ "4. SAIR");
			
			if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4")) {
				JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
			}else {
				return Integer.parseInt(op);
			}
			
			
		}
	}

}
