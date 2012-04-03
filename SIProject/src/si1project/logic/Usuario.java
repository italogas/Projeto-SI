package si1project.logic;

import java.util.List;

public class Usuario {
	private int idUsuario;
	private String login;
	private String email;
	private String senha;
	private String nome;
	private String endereco;
	private List<Carona> listaCaronasOferecidas;
	private List<Carona> listaCaronasPegas;

	public Usuario(String login, String senha, String nome, String endereco, String email) throws Exception{
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		setIdUsuario(this.hashCode());
	}
	
	public Usuario(String login2, String nome2, String endereco2) throws Exception {
		setLogin(login2);
		setNome(nome2);
		setEndereco(endereco2);
		setIdUsuario(this.hashCode());
	}

	public Usuario(String login2, String nome2, String endereco2, String email2) throws Exception {
		setLogin(login2);
		setNome(nome2);
		setEndereco(endereco2);
		setEmail(email2);
		setIdUsuario(this.hashCode());
	}

	private void setIdUsuario(int hashCode) {
		this.idUsuario = hashCode;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws Exception {
		if( login == null || login.equals("") )
			throw new Exception("Login inválido");
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if(email == null || email.equals(""))
			throw new Exception("Email inválido");
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws Exception {
		if(senha == null || senha.equals(""))
			throw new Exception("Senha inválida");
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if(nome == null || nome.equals(""))
			throw new Exception("Nome inválido");
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws Exception {
		if(endereco == null || endereco.equals(""))
			throw new Exception("Endereço inválido");
		this.endereco = endereco;
	}

	public String getAtributo(String nomeAtributo) throws Exception {
		if(nomeAtributo == null || nomeAtributo.equals(""))
			throw new Exception("Atributo inválido");
		
		if(nomeAtributo.equals("nome"))
			return this.getNome();
		else if (nomeAtributo.equals("login"))
			return this.getLogin();
		else if(nomeAtributo.equals("email"))
			return this.getEmail();
		else if(nomeAtributo.equals("senha"))
			return this.getSenha();
		else if(nomeAtributo.equals("endereco"))
			return this.getEndereco();
		else
			throw new Exception("Atributo inexistente");
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

	public int sugerirPontoEncontro(int idSessao, int idCarona, String ponto) {
		// TODO Auto-generated method stub
		return -1;
	}

	public void cadastrarCarona(int idSessao, String origem, String destino, String data,
			String hora, int vagas) {
		listaCaronasOferecidas.add(new Carona(idSessao, origem, destino, data, hora, vagas));
	}

	public boolean validaSenha(String senha){
		return this.senha.equals(senha);
	}
	
}
