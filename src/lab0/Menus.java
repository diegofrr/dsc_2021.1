package lab0;

import javax.swing.JOptionPane;

public class Menus {
	
	public int menuPrincipal() {
		while (true){
			String op = JOptionPane.showInputDialog("MENU\n\n"
					+ "1. AVALIAR DISCIPLINA\n"
					+ "2. VER TODAS AVALIA��ES\n"
					+ "3. MINHAS AVALIA��ES\n"
					+ "4. SAIR");
			
			if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4")) {
				JOptionPane.showMessageDialog(null, "OP��O INV�LIDA!");
			}else {
				return Integer.parseInt(op);
			}
			
			
		}
	}

}
