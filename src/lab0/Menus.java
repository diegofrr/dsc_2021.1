package lab0;

import javax.swing.JOptionPane;

public class Menus {
	
	public int menuPrincipal() {
		while (true){
			String op = JOptionPane.showInputDialog("MENU\n\n"
					+ "1. ADICIONAR DISCIPLINA\n"
					+ "2. AVALIAR DISCIPLINA\n"
					+ "3. VER TODAS AVALIA��ES\n"
					+ "4. MINHAS AVALIA��ES\n"
					+ "5. SAIR");
			
			
			if (op == null) {
				return 5;
			}
			
			else if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5")) {
				JOptionPane.showMessageDialog(null, "OP��O INV�LIDA!");
			}else {
				return Integer.parseInt(op);
			}
			
			
		}
	}

}
