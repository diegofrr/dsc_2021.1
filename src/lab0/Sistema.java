package lab0;

import javax.swing.JOptionPane;
public class Sistema {
	
	static Functions funcoes = new Functions();
	
	public static void main(String[]args) {
		while (true){
		
		Object[] opcoes = { "FAZER LOGIN", "SE CADASTRAR"};
		int op = JOptionPane.showOptionDialog(null, "Bem-vindo!", "Sistema de Avalia��o de Disciplinas", JOptionPane.DEFAULT_OPTION, 1, null, opcoes, opcoes[0]);
		
		if (op == 0) {
			int _mat = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matr�cula"));
			String _senha = JOptionPane.showInputDialog("Digite sua senha");
			Aluno aluno_logado = funcoes.logar(_mat, _senha);
			if (aluno_logado == null) {
				JOptionPane.showMessageDialog(null, "Falha no login!");
				continue;
			}
			else {
				JOptionPane.showMessageDialog(null, "ENTRANDO NO SISTEMA COMO" + aluno_logado.getNome());
			}
			
			
		}
		
		if (op == 1) {
			
			if (funcoes.cursos_vazios()) {
				JOptionPane.showMessageDialog(null, "Ainda n�o existe nenhuma curso cadastrado no sistema. Cadastre um agora mesmo.");
				String _nome = JOptionPane.showInputDialog("Digite o nome do curso").toUpperCase();
				int _id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do curso"));
				boolean existe = funcoes.verifica_curso(_id);
				if (existe) {
					JOptionPane.showMessageDialog(null, "J� existe um curso com o ID " + _id + ".");
				}else {
					JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
				}
			}
			
			
			
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
				
			}
			
			
			
			
		}else {
			break;
		}
		}
		
		
		
		
	}

}
