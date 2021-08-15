package lab0att;


public class Aluno {
	
	private String nome;
	private String email;
	private String senha;
	
	public Aluno(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String _email) {
		this.email = _email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String _s) {
		this.senha = _s;
	}
	
}

	