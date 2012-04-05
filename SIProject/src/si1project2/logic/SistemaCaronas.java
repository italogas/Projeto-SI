package si1project2.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SistemaCaronas {
	private Map<String, Usuario> mapLoginUser = new TreeMap<String, Usuario>();
	private Map<String, Sessao> mapIdSessao = new TreeMap<String, Sessao>(); // contem apenas sessoes abertas
	private Map<String, Carona> mapIdCarona = new TreeMap<String, Carona>();

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		Usuario user = new Usuario(login, senha, nome, endereco, email);

		for (Usuario u : mapLoginUser.values())
			if (u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");

		if (!mapLoginUser.containsKey(login)) {
			mapLoginUser.put(user.getLogin(), user);
		} else {
			throw new Exception("Já existe um usuário com este login");
		}
	}

	public void criarUsuario(String login, String nome, String endereco)
			throws Exception {
		Usuario user = new Usuario(login, nome, endereco);
		if (!mapLoginUser.containsKey(login)) {
			mapLoginUser.put(user.getLogin(), user);
		} else {
			throw new Exception("Já existe um usuário com este login");
		}
	}

	public void criarUsuario(String login, String nome, String endereco,
			String email) throws Exception {
		Usuario user = new Usuario(login, nome, endereco, email);

		for (Usuario u : mapLoginUser.values())
			if (u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");

		if (!mapLoginUser.containsKey(login)) {
			mapLoginUser.put(user.getLogin(), user);
		} else {
			throw new Exception("Já existe um usuário com este login");
		}
	}

	public String cadastrarCarona(String idSessao, String origem, String destino,
			String data, String hora, String vagas) throws Exception {
		if(idSessao == null || idSessao.equals(""))
			throw new Exception("Sessão inválida");
		if(data == null || data.equals("") || !DateUtil.validaData(data) || DateUtil.datajapassou(data)){
			throw new Exception("Data inválida");
		}
		if(!mapIdSessao.containsKey(idSessao))
			throw new Exception("Sessão inexistente");
		Carona carona = new Carona(idSessao, origem, destino, data, hora, vagas);
		mapIdCarona.put(carona.getIdCarona(), carona);
		return carona.getIdCarona();
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

		if( !mapLoginUser.containsKey(login) )
			throw new Exception("Usuário inexistente");
		else {
			user = mapLoginUser.get(login);
			s = new Sessao(user.getIdUsuario());
			if(user.validaSenha(senha)){
				mapIdSessao.put(s.getIdSessao(), s);
				return s.getIdSessao();
			} else {
				throw new Exception("Login inválido");
			}
		}
	}

	public Object getAtributoUsuario(String login, String atributo)
			throws Exception {
		if (login == null || login.equals("")) {
			throw new Exception("Login inválido");
		}
		if (!mapLoginUser.containsKey(login))
			throw new Exception("Usuário inexistente");
		return mapLoginUser.get(login).getAtributo(atributo);
	}

	/*
	 * Retorna uma lista de id's de caronas. Localiza
	 * caronas na sessao identificada por idSessao
	 */
	public List<String> localizarCarona(String idSessao, String origem,
			String destino) throws Exception {
		
		if(idSessao == null)
			throw new Exception("IdSessao nulo");
		if(origem == null)
			throw new Exception("Origem inválida");
		if(destino == null)
			throw new Exception("Destino inválido");
		
		List<String> caronasLocalizadas = new LinkedList<String>();
		
		// se origem=="" e destino!="" ==> retorna todas as caronas para aquele destino
		
		// se origem!="" e destino=="" ==> retorna todas as caronas daquela origem
		
		for (String idCarona : mapIdCarona.keySet()) {
			Carona carona = mapIdCarona.get(idCarona);
			if (carona.getOrigem().equalsIgnoreCase(origem)
					&& carona.getDestino().equalsIgnoreCase(destino)) {
				caronasLocalizadas.add(idCarona);
			}
		}
		return caronasLocalizadas;
	}

	public Object getAtributoCarona(String idCarona, String nomeAtributo)
			throws Exception {
		if(idCarona == null || idCarona.equals(""))
			throw new Exception("Identificador do carona é inválido");
		if(!mapIdCarona.containsKey(idCarona))
			throw new Exception("Item inexistente");
		return mapIdCarona.get(idCarona).getAtributo(nomeAtributo);
	}

	public String getTrajeto(String idCarona) throws Exception {
		if(idCarona == null)
			throw new Exception("Trajeto Inválida");
		if(idCarona.equals("") || !mapIdCarona.containsKey(idCarona))
			throw new Exception("Trajeto Inexistente");
		return mapIdCarona.get(idCarona).getTrajeto();
	}

	public String getCarona(String idCarona) throws Exception {
		if(idCarona == null)
				throw new Exception("Carona Inválida");
		if(idCarona.equals("") || !mapIdCarona.containsKey(idCarona))
			throw new Exception("Carona Inexistente");
		return mapIdCarona.get(idCarona).getCarona();
	}
	
	public void encerrarSessao(String login) {
		//TODO
		//mapIdSessao.remove(key);
	}

	/*
	 * torna null todos os objetos que estao sendo manipulados atualmente pelo
	 * sistema
	 */
	public void zerarSistema() {
		mapLoginUser.clear();
		mapIdSessao.clear();
		mapIdCarona.clear();
	}

	public void encerrarSistema() {
		// System.exit(0)?;
	}

	/*
	 * Retorna id da Mensagem enviada
	 */
	public int sugerirPontoEncontro(int idSessao, int idCarona, String ponto) {
		// return gerenciadorDeMensagens.sugerirPontoEncontro(idSessao,
		// idCarona, ponto);
		// TODO
		return -1;
	}

	public void responderSugestaoPontoEncontro(int idSessao, int idCarona,
			int idSugestao, String pontos) {
		// TODO
	}

	/*
	 * Retorna id da Mensagem enviada
	 */
	public int solicitarVagaPontoEncontro(int idSessao, int idCarona,
			String ponto) {
		// TODO
		return -1;
	}

	public Object getAtributoSolicitacao(int idSolicitacao, String atributo) {
		// TODO
		// return gerenciadorDeMensagens.getAtributoSolicitacao(idSolicitacao,
		// atributo);
		return null;
	}

	public void aceitarSolicitacaoPontoEncontro(int idSessao, int idSolicitacao) {
		// TODO
	}

	public void desistirRequisicao(int idSessao, int idCarona, int idSugestao) {
		// TODO
	}

	public int solicitarVaga(int idSessao, int idCarona) {
		// TODO
		return -1;
	}

	public void rejeitarSolicitacao(int idSessao, int idSolicitacao) {
		// TODO
	}

	public void aceitarSolicitacao(int idSessao, int idSolicitacao) {
		// TODO
	}
}
