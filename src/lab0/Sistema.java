package lab0;

import javax.swing.JOptionPane;
public class Sistema {
	
	static Functions funcoes = new Functions();
	
	public static void main(String[]args) {
		
		Aluno aluno_logado;
		
		while (true){
		
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
				
				int opc = funcoes.menu.menuPrincipal();
				JOptionPane.showMessageDialog(null, opc);
				
			}
			
			
		}
		
		if (op == 1) {		
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
			
			
			
			
		}else {
			break;
		}
		}
		
		
		
		
	}

}
