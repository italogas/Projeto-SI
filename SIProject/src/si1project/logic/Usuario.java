package si1project.logic;

import java.lang.reflect.Method;

public class Usuario {
	private String login;
	private String email;
	private String senha;
	private String nome;
	private String endereco;

	public Usuario(String login, String senha, String nome, String endereco, String email) throws Exception{
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
		//TODO falta verificar se a string login é valida
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		//TODO falta verificar se o email é valido
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		//TODO Decidir e verificar o que é uma senha valida
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		//TODO 
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		//TODO verificar se o endereço é valido
		this.endereco = endereco;
	}

	public Object getAtributo( String nomeAtributo) throws Exception {
		// TODO: eh melhor usar a estrategia indicada por Athur monitor: fazer com if-else?
		if(nomeAtributo==null)
			throw new Exception("Atributo inválido");
		
		Method m1 = Usuario.class.getMethod("get" + nomeAtributo, String.class);
		return (String)m1.invoke(/*objetoUsuario*/this, /*listaArgumentos*/this);
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	
	
}
