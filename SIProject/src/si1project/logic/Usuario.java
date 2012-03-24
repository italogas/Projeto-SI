package si1project.logic;

import java.lang.reflect.Method;

public class Usuario {
	private String login;
	private String email;
	private String senha;
	private String nome;
	private String endereco;

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) 
			throws Exception {
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String abrirSessao(String login2, String senha2) {
		//TODO
		return null;
		
	}
	
	public String fecharSessao(String login2) {
		//TODO
		return null;
	}

	public String getAtributoUsuario(String login2, String nomeAtributo) throws Exception {
		if(login2==null || login2.equals(""))
			throw new Exception("Login inválido");
		if(nomeAtributo==null)
			throw new Exception("Atributo inválido");
		
		Method m1 = Usuario.class.getMethod("get" + nomeAtributo, String.class);
		return (String)m1.invoke(login2, this);
	}
}
