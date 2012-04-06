package si1project2.logic;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SistemaCaronas {
	//private Map<String, Usuario> mapLoginUser = new TreeMap<String, Usuario>();
	private Map<String, Sessao> mapIdSessao = new TreeMap<String, Sessao>(); // contem apenas sessoes abertas
	//private Map<String, Carona> mapIdCarona = new TreeMap<String, Carona>();
	private Map<String, Usuario> mapIdUsuario = new TreeMap<String, Usuario>();

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		
		for(Usuario u : mapIdUsuario.values())
			if(u.getLogin().equals(login))
				throw new Exception("Já existe um usuário com este login");
		
		for (Usuario u : mapIdUsuario.values())
			if (u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");

		Usuario user = new Usuario(login, senha, nome, endereco, email);
		mapIdUsuario.put(user.getIdUsuario(), user);
	}

	public void criarUsuario(String login, String senha, String nome, String endereco)
			throws Exception {

		for(Usuario u : mapIdUsuario.values())
			if(u.getLogin().equals(login))
				throw new Exception("Já existe um usuário com este login");
		
		Usuario user = new Usuario(login, senha, nome, endereco);
		mapIdUsuario.put(user.getIdUsuario(), user);
	}

	/**
	 * Cadastra carona na listaDeCaronasOferecidas do usuario
	 * cadastrante e no mapa de caronas do sistema.
	 * 
	 * @param idSessao
	 * @param origem
	 * @param destino
	 * @param data
	 * @param hora
	 * @param vagas
	 * @return id da carona cadastrada
	 * @throws Exception
	 * 
	 * @see Usuario
	 */
	public String cadastrarCarona(String idSessao, String origem, String destino,
			String data, String hora, String vagas) throws Exception {
		if(idSessao == null || idSessao.equals(""))
			throw new Exception("Sessão inválida");
		
		if(!mapIdSessao.containsKey(idSessao))
			throw new Exception("Sessão inexistente");
		
		for(String idUsuario : mapIdUsuario.keySet())
			if(idUsuario.equals(mapIdSessao.get(idSessao).getIdUser())) {
				return mapIdUsuario.get(idUsuario).cadastrarCarona(idUsuario, origem, destino, data, hora, vagas);
			}
		return null;
	}

	/*
	 * Retorna o id da sessao aberta
	 */
	public String abrirSessao(String login, String senha) throws Exception {
		Sessao s = null;
		Usuario user = null;
		if(login == null || login.equals(""))
			throw new Exception("Login inválido");
		if(senha == null || senha.equals(""))
			throw new Exception("Senha inválida");
		
		for(Usuario u : mapIdUsuario.values())
			if(u.getLogin().equals(login)) {
				user = u;
				s = new Sessao(user.getIdUsuario());
				if(user.validaSenha(senha)){
					mapIdSessao.put(s.getIdSessao(), s);
					//System.out.println("Sessao aberta com sucesso: login: " + login + " senha: " + senha);
					return s.getIdSessao();
				} else {
					throw new Exception("Login inválido");
				}
			}
		// caso nao exista usuario compativel com o dado login
		throw new Exception("Usuário inexistente");
	}

	public Object getAtributoUsuario(String login, String atributo)
			throws Exception {
		if (login == null || login.equals("")) {
			throw new Exception("Login inválido");
		}
		for(Usuario u : mapIdUsuario.values())
			if(u.getLogin().equals(login)) 
				return u.getAtributo(atributo);

		//caso nao tenha nenhum usuario compativel com o login dado
		throw new Exception("Usuário inexistente");
	}

	/*
	 * Retorna uma lista de id's de caronas. Localiza
	 * caronas cadastradas pelo usuario localizado
	 * na sessao indicada por idSessao.
	 */
	public List<String> localizarCarona(String idSessao, String origem,
			String destino) throws Exception {
		
		if(idSessao == null)
			throw new Exception("IdSessao nulo");
		if(origem == null)
			throw new Exception("Origem inválida");
		if(destino == null)
			throw new Exception("Destino inválido");
		
		Usuario user = mapIdUsuario.get(mapIdSessao.get(idSessao).getIdUser());
		return user.localizarCarona(origem, destino);
	}

	public Object getAtributoCarona(String idCarona, String nomeAtributo)
			throws Exception {
		if(idCarona == null || idCarona.equals(""))
			throw new Exception("Identificador do carona é inválido");
		
		for(Usuario u : mapIdUsuario.values()) {
			if(u.getMapIdCaronasOferecidas().containsKey(idCarona))
				return u.getAtributoCarona(idCarona, nomeAtributo);
		}
		throw new Exception("Item inexistente");
	}
	
	/**
	 * Retorna trajeto da carona oferecida
	 * pelo usuario que a registrou (Dono da carona).
	 * 
	 * @param idCarona
	 * @return trajeto
	 * @throws Exception
	 */
	public String getTrajeto(String idCarona) throws Exception {
		if(idCarona == null)
			throw new Exception("Trajeto Inválida");
		if(idCarona.equals(""))
			throw new Exception("Trajeto Inexistente");
		
		for(Usuario u : mapIdUsuario.values())
			if(u.getMapIdCaronasOferecidas().containsKey(idCarona))
				return u.getTrajeto(idCarona);
		
		throw new Exception("Trajeto Inexistente");
	}
	
	/**
	 * Retorna a carona resumida oferecida pelo
	 * usuario que a registrou.
	 * 
	 * @param idCarona
	 * @return
	 * @throws Exception
	 */
	public String getCarona(String idCarona) throws Exception {
		if(idCarona == null)
			throw new Exception("Carona Inválida");
		if(idCarona.equals(""))
			throw new Exception("Carona Inexistente");
		
		for(Usuario u : mapIdUsuario.values())
			if(u.getMapIdCaronasOferecidas().containsKey(idCarona))
				return u.getCarona(idCarona);
		throw new Exception("Carona Inexistente");
	}
	
	/**
	 * Remove sessao do mapa de sessoes do sistema.
	 * 
	 * @param login
	 */
	public void encerrarSessao(String login) {
		Iterator<Sessao> it = mapIdSessao.values().iterator(); 
		while(it.hasNext()) {
			if(mapIdUsuario.get(it.next().getIdUser()).getLogin().equals(login)) {
				it.remove();
				break;
			}
		}
	}

	/*
	 * torna null todos os objetos que estao sendo manipulados atualmente pelo
	 * sistema
	 */
	public void zerarSistema() {
		mapIdUsuario.clear();
		mapIdSessao.clear();
		for(Usuario u : mapIdUsuario.values())
			u.zerarSistema();
		//System.out.println("Sistema zerado com sucesso.");
	}

	public void encerrarSistema() {
		// System.exit(0)?;
	}

	/*
	 * Retorna id da Mensagem enviada
	 */
	public String sugerirPontoEncontro(String idSessao, String idCarona, String ponto) throws Exception {
		if(idSessao == null || !mapIdSessao.containsKey(idSessao))
			throw new Exception("Ponto Inválido");
		//if(idCarona == null || !mapIdCarona.containsKey(idCarona))
			//throw new Exception("IdCarona inválido");
		
		//TODO validar ponto encontro
		
		//for(Usuario u : mapLoginUser.values()) { // u == requerente, solicitante
			//if(u.getIdUsuario().equals(mapIdSessao.get(idSessao).getIdUser())) {
				//return u.sugerirPontoEncontro(mapIdCarona.get(idCarona).getOrigem(), mapIdCarona.get(idCarona).getDestino(),
			//			mapIdUsuario .get(mapIdCarona.get(idCarona).getIdDonoDaCarona()), u.getIdUsuario(), ponto);
			//}
		//}
		return null;
	}

	public void responderSugestaoPontoEncontro(String idSessao, String idCarona,
			String idSugestao, String pontos) {
		// TODO
	}

	/*
	 * Retorna id da Mensagem enviada
	 */
	public int solicitarVagaPontoEncontro(String idSessao, String idCarona,
			String ponto) {
		// TODO
		return -1;
	}

	public Object getAtributoSolicitacao(String idSolicitacao, String atributo) {
		//if()
		//TODO
		return null;
	}

	public void aceitarSolicitacaoPontoEncontro(String idSessao, String idSolicitacao) {
		// TODO
	}

	public void desistirRequisicao(String idSessao, String idCarona, String idSugestao) {
		// TODO
	}

	public int solicitarVaga(String idSessao, String idCarona) {
		// TODO
		return -1;
	}

	public void rejeitarSolicitacao(String idSessao, String idSolicitacao) {
		// TODO
	}

	public void aceitarSolicitacao(String idSessao, String idSolicitacao) {
		// TODO
	}
}
