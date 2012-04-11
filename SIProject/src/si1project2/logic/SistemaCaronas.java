package si1project2.logic;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import si1project2.util.DateUtil;

public class SistemaCaronas {
	private Map<String, Sessao> mapIdSessao = new TreeMap<String, Sessao>(); // contem apenas sessoes abertas
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
		if(data == null || data.equals("") || !DateUtil.validaData(data)){
			throw new Exception("Data inválida");
		}
		if(DateUtil.datajapassou(data)){
//			XXX CONSERTAR E DESCOBRIR QUAL O PROBLEMA COM ESSE IF
			throw new Exception("Data inválida");
		}
		if(hora == null || hora.equals("") || !hora.contains(":")){
			throw new Exception("Hora inválida");
		}
		if(vagas==null || !vagas.toUpperCase().equals(vagas)){
			throw new Exception("Vaga inválida");
		}
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
		if(origem == null  ||(!origem.equals("") && origem.toUpperCase().equals(origem)))
			throw new Exception("Origem inválida");
		if(destino == null || (!destino.equals("") && destino.toUpperCase().equals(destino)))
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
	}

	public void encerrarSistema() {
		System.exit(0);
	}

	/**
	 * 
	 * @param idSessao: id do usuario q faz a solicitacao/sugestao
	 * @param idCarona: carona a qual está destinada a solicitacao
	 * @param pontos : ponto de encontro sugerido
	 * @return id da solicitacao feita
	 * @throws Exception
	 */
	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos) throws Exception {
		if(idSessao == null || !mapIdSessao.containsKey(idSessao))
			throw new Exception("Ponto Inválido");
		
		Usuario solicitante = null;
		for(Sessao s : mapIdSessao.values()) { // procura solicitante
			if(s.getIdSessao().equals(idSessao)) {
				solicitante = mapIdUsuario.get(s.getIdUser());
				break;
			}
		}
		if(solicitante == null)
			throw new Exception("IdSessao Inválido");
		
		Usuario donoDaCarona = null;
		for(Usuario u : mapIdUsuario.values()) { // procura donoDaCarona
			if(u.getMapIdCaronasOferecidas().containsKey(idCarona)) {
				donoDaCarona = u;
				break;
			}
		}
		if(donoDaCarona == null)
			throw new Exception("IdCarona inválido");
		
		return donoDaCarona.sugerirPontoEncontro(idCarona, donoDaCarona.getIdUsuario(), solicitante.getIdUsuario(),
				pontos);
	}

	/**
	 * 
	 * @param idSessao: id do usuario q responde a solicitacao/sugestao
	 * @param idCarona: carona a qual está destinada a solicitacao
	 * @param idSolicitacao: id da solicitacao feita por outro usuario
	 * @param ponto : ponto de encontro sugerido pelo dono da carona
	 * @throws Exception
	 * 
	 * o ponto encontro da carona eh setado como esse q eh respondido
	 * pelo dono da carona. O ponto pode ser identico ou nao ao ponto sugerido
	 * pelo usuario solicitante.
	 */
	public void responderSugestaoPontoEncontro(String idSessao, String idCarona,
			String idSugestao, String pontos) throws Exception {
		if(idSessao == null)
			throw new Exception("IdSessao inválido");
		if(idCarona == null)
			throw new Exception("IdCarona inválido");
		if(idSugestao == null)
			throw new Exception("IdSessao inválido");
		if(pontos == null || pontos.equals(""))
			throw new Exception("Ponto Inválido");
			
		for(Sessao s : mapIdSessao.values()) { // procura donoDaCarona
			if(s.getIdSessao().equals(idSessao)) {
				Usuario donoDaCarona = mapIdUsuario.get(s.getIdUser()); 
				donoDaCarona.responderSugestaoPontoEncontro(idCarona, idSugestao, pontos);
			}
		}
	}

	/**
	 * 
	 * @param idSessao: id do usuario q faz a solicitacao/sugestao
	 * @param idCarona: carona a qual está destinada a solicitacao
	 * @param pontos : ponto de encontro sugerido
	 * @return id da solicitacao feita
	 * @throws Exception
	 */
	public String solicitarVagaPontoEncontro(String idSessao, String idCarona,
			String pontos) throws Exception {
		if(idSessao == null || !mapIdSessao.containsKey(idSessao))
			throw new Exception("Ponto Inválido");
		
		Usuario solicitante = null;
		for(Sessao s : mapIdSessao.values()) { // procura pelo usuario solicitante
			if(s.getIdSessao().equals(idSessao)) {
				solicitante = mapIdUsuario.get(s.getIdUser());
				break;
			}
		}
		if(solicitante == null)
			throw new Exception("IdSessao Inválido");
		
		Usuario donoDaCarona = null;
		for(Usuario u : mapIdUsuario.values()) { // procura pelo donoDaCarona
			if(u.getMapIdCaronasOferecidas().containsKey(idCarona)) {
				donoDaCarona = u;
				break;
			}
		}
		if(donoDaCarona == null)
			throw new Exception("IdCarona inválido");
		
		//TODO erro: DONODACARONA x SOLICITANTE
		return donoDaCarona.solicitarVagaPontoEncontro(idCarona, donoDaCarona.getIdUsuario(), solicitante.getIdUsuario(),
				pontos);
	}

	// ESTAH SABENDO DEMAIS ==> VAI DE ENCONTRO AO PADRAO INFORMATION-EXPERT
	public Object getAtributoSolicitacao(String idSolicitacao, String atributo) throws Exception {
		for(Usuario u : mapIdUsuario.values()) {
			for(Carona c : u.getMapIdCaronasOferecidas().values()) {
				if(c.getMapIdSolicitacao().containsKey(idSolicitacao)) {
					if(atributo.equals("Dono da solicitacao"))
						return mapIdUsuario.get(c.getAtributoSolicitacao(idSolicitacao, atributo)).getNome();
					else if(atributo.equals("Dono da carona"))
						return mapIdUsuario.get(c.getAtributoSolicitacao(idSolicitacao, atributo)).getNome();
					return c.getAtributoSolicitacao(idSolicitacao, atributo);
				}
			}
		}
		throw new Exception("Solicitação inexistente");
	}

	/**
	 * 
	 * 
	 * @param idSessao : id da sessao do usuario dono da carona
	 * @param idSolicitacao
	 * @throws Exception 
	 */
	public void aceitarSolicitacaoPontoEncontro(String idSessao, String idSolicitacao) throws Exception {
		if(idSolicitacao == null)
			throw new Exception("Solicitação inexistente");
		
		Usuario donoDaCarona = mapIdUsuario.get(mapIdSessao.get(idSessao).getIdUser());
		String[] resp = donoDaCarona.aceitarSolicitacaoPontoEncontro(idSolicitacao);
		String idDonoDaSolicitacao = resp[0];
		String idCarona = resp[1];
		mapIdUsuario.get(idDonoDaSolicitacao).adicionarIdCaronaPega(idCarona);
	}
	
	/**
	 * Aceita solicitacao
	 * 
	 * @param idSessao : id da sessao do usuario dono da carona
	 * @param idSolicitacao
	 * @throws Exception 
	 */
	public void aceitarSolicitacao( String idSessao, String idSolicitacao) throws Exception {
		if(idSessao == null || idSolicitacao == null)
			throw new Exception("Solicitação inexistente");
		
		Usuario donoDaCarona = mapIdUsuario.get(mapIdSessao.get(idSessao).getIdUser());
		String[] resp = donoDaCarona.aceitarSolicitacao(idSolicitacao);
		String idDonoDaSolicitacao = resp[0];
		String idCarona = resp[1];
		mapIdUsuario.get(idDonoDaSolicitacao).adicionarIdCaronaPega(idCarona);
	}

	/**
	 * Adiciona solicitacao a lista de solicitacoes
	 * associadas a uma carona, indicada por idCarona.
	 * A solicitacao eh feita pelo usuario indicado
	 * por idSessao.
	 * 
	 * @param idSessao
	 * @param idCarona
	 * @return id da solicitacao feita
	 * @throws Exception
	 */
	public String solicitarVaga(String idSessao, String idCarona) throws Exception {
		if(idSessao == null || !mapIdSessao.containsKey(idSessao))
			throw new Exception("IdSessao inválido");
		
		Usuario solicitante = null;
		for(Sessao s : mapIdSessao.values()) { // procura pelo usuario solicitante dentre os usuarios
			if(s.getIdSessao().equals(idSessao)) {
				solicitante = mapIdUsuario.get(s.getIdUser());
				break;
			}
		}
		if(solicitante == null)
			throw new Exception("IdSessao Inválido");
		
		Usuario donoDaCarona = null;
		for(Usuario u : mapIdUsuario.values()) { // procura pelo donoDaCarona
			if(u.getMapIdCaronasOferecidas().containsKey(idCarona)) {
				donoDaCarona = u;
				break;
			}
		}
		if(donoDaCarona == null)
			throw new Exception("IdCarona inválido");
		
		return donoDaCarona.solicitarVaga(idCarona, donoDaCarona.getIdUsuario(), solicitante.getIdUsuario());
	}

	/**
	 * Usuario dono da carona, indicado por idSessao, rejeita solicitacao,
	 * indicada por idSolicitacao.
	 * 
	 * @param idSessao
	 * @param idSolicitacao
	 * @throws Exception 
	 */
	public void rejeitarSolicitacao(String idSessao, String idSolicitacao) throws Exception {
		if(idSessao == null)
			throw new Exception("IdSessao inválido");
		if(idSolicitacao == null)
			throw new Exception("IdSolicitacao inválida");
		
		for(Sessao s : mapIdSessao.values()) { // procura pelo donoDaCarona
			if(s.getIdSessao().equals(idSessao)) {
				Usuario donoDaCarona = mapIdUsuario.get(s.getIdUser()); 
				donoDaCarona.rejeitarSolicitacao(idSolicitacao);
			}
		}
	}
	
	/**
	 * Remove a solicitacao, indicada por idSolicitacao, da lista de
	 * solicitacoes da carona indicada por idCarona, feita ao usuario
	 * indicado por idSessao.
	 * 
	 * @param idSessao
	 * @param idCarona
	 * @param idSolicitacao
	 * @throws Exception 
	 */
	public void desistirRequisicao(String idSessao, String idCarona, String idSolicitacao) throws Exception {
		if(idSessao == null)
			throw new Exception("IdSessao inválido");
		if(idCarona == null)
			throw new Exception("IdCarona inválido");
		if(idSolicitacao == null)
			throw new Exception("IdSolicitacao inválido");
		
		Usuario donoDaCarona = mapIdUsuario.get(mapIdSessao.get(idSessao).getIdUser()); // O(2*logn)
		donoDaCarona.removerSolicitacao(idCarona, idSolicitacao);
	}
	
	public Perfil visualizarPerfil(String idSessao, String login) throws Exception {
		for(Usuario u : mapIdUsuario.values())
			if(u.getLogin().equals(login)) 
				return (Perfil)u.getAtributo("perfil");

		//caso nao tenha nenhum usuario compativel com o login dado
		throw new Exception("Login inválido");

	}
	
	public String getAtributoPerfil(String login, String atributo) throws Exception {
		for(Usuario u : mapIdUsuario.values())
			if(u.getLogin().equals(login)) 
				return ((Perfil)u.getAtributo("perfil")).getAtributo(atributo).toString();

		//caso nao tenha nenhum usuario compativel com o login dado
		throw new Exception("Login inválido");
	}
}
