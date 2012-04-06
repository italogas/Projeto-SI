package si1project2.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Usuario {
	private String idUsuario;
	private String login;
	private String email;
	private String senha;
	private String nome;
	private String endereco;

	private Map<String, Carona> mapIdCaronasPegas = new TreeMap<String, Carona>();
	private Map<String, Carona> mapIdCaronasOferecidas = new TreeMap<String, Carona>();

	public Usuario(String login, String senha, String nome, String endereco, String email) throws Exception{
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		setIdUsuario(this.hashCode() + "");
	}
	
	public Usuario(String login2, String senha2, String nome2, String endereco2) throws Exception {
		setLogin(login2);
		setSenha(senha2);
		setNome(nome2);
		setEndereco(endereco2);
		setIdUsuario(this.hashCode() + "");
	}

	private void setIdUsuario(String string) {
		this.idUsuario = string;
	}
	
	public String getIdUsuario() {
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
		//TODO criar validador de emails
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

	public String cadastrarCarona(String idUsuario, String origem, String destino, String data,
			String hora, String vagas) throws Exception {
		
		Carona carona = new Carona(idUsuario, origem, destino, data, hora, vagas);
		//System.out.println("Carona cadastrada id: " + carona.getIdCarona() + " origem: " + origem + " destino: " + destino);
		mapIdCaronasOferecidas.put(carona.getIdCarona(), carona);
		
		return carona.getIdCarona();
	}

	public boolean validaSenha(String senha){
		return this.senha.equals(senha);
	}

	public List<String> localizarCarona(String origem, String destino) {
		List<String> caronas = new LinkedList<String>();
		
		if(origem.equals("") && !destino.equals("")) {
			for(Carona c : mapIdCaronasOferecidas.values()) {
				if(c.getDestino().equals(destino)){
					caronas.add(c.getIdCarona());
				}
			}
		}
		else if(!origem.equals("") && destino.equals("")) {
			for(Carona c : mapIdCaronasOferecidas.values()) {
				if(c.getOrigem().equals(origem)){
					caronas.add(c.getIdCarona());
				}
			}
		}
		else if(!origem.equals("") && !destino.equals("")){
			for(Carona c : mapIdCaronasOferecidas.values()) {
				if(c.getOrigem().equals(origem) && c.getDestino().equals(destino)){
					caronas.add(c.getIdCarona());
				}
			}
		}
		else {
			for(Carona c : mapIdCaronasOferecidas.values()) {
				caronas.add(c.getIdCarona());
			}
		}
			
		return caronas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (endereco == null) {
			if (other.endereco != null) {
				return false;
			}
		} else if (!endereco.equals(other.endereco)) {
			return false;
		}
		if (idUsuario == null) {
			if (other.idUsuario != null) {
				return false;
			}
		} else if (!idUsuario.equals(other.idUsuario)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	public Object getAtributoCarona(String idCarona, String nomeAtributo) throws Exception {
		return mapIdCaronasOferecidas.get(idCarona).getAtributo(nomeAtributo);
	}
	
	public String sugerirPontoEncontro(String origem, String destino, String idDonoDaCarona,
			String idDonoDaSolicitacao, String ponto) {
		Solicitacao s = new Solicitacao(origem, destino, idDonoDaCarona, idDonoDaSolicitacao, ponto);
		return s.getIdSolicitacao();
	}

	public Map<String, Carona> getMapIdCaronasOferecidas() {
		return this.mapIdCaronasOferecidas;
	}
	
	public String getTrajeto(String idCarona) throws Exception {
		return mapIdCaronasOferecidas.get(idCarona).getTrajeto(); 
	}

	public String getCarona(String idCarona) throws Exception {
			
		return mapIdCaronasOferecidas.get(idCarona).getCarona();
	}

	public void zerarSistema() {
		mapIdCaronasOferecidas.clear();
		mapIdCaronasPegas.clear();
	}
}
