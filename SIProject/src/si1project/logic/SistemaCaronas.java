package si1project.logic;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SistemaCaronas {
	private Map<String, Usuario> mapLoginUser = new TreeMap<String, Usuario>();
	private Map<String, Sessao> mapIdSessao = new TreeMap<String, Sessao>(); // contem apenas sessoes abertas
	private Map<Integer, Carona> mapIdCarona = new TreeMap<Integer, Carona>();

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

	public Integer cadastrarCarona(String idSessao, String origem, String destino,
			String data, String hora, Integer vagas) throws Exception {
		if(idSessao == null || idSessao.equals(""))
			throw new Exception("Sessão inválida");
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
	public List<Integer> localizarCarona(String idSessao, String origem,
			String destino) throws Exception {
		if(idSessao == null)
			throw new Exception("IdSessao nulo");
		if(origem == null || destino.equals(""))
			throw new Exception("Origem inválida");
		if(destino == null || destino.equals(""))
			throw new Exception("Destino inválido");
		for(Usuario u : mapLoginUser.values()) {
			if(u.getIdUsuario() == mapIdSessao.get(idSessao).getIdUser()) {
				return u.localizarCarona(origem, destino);
			}
		}
		return null; 
	}

	public Object getAtributoCarona(Integer idCarona, String nomeAtributo)
			throws Exception {
		return mapIdCarona.get(idCarona).getAtributo(nomeAtributo);
	}

	public String getTrajeto(int idCarona) {
		return mapIdCarona.get(idCarona).getTrajeto();
	}

	public String getTrajeto(Integer idCarona) {
		return mapIdCarona.get(idCarona).getTrajeto();
	}

	public String getCarona(int idCarona) throws Exception {
		return mapIdCarona.get(idCarona).getCarona();
	}
	
	public String getCarona(Integer idCarona) throws Exception {
		return mapIdCarona.get(idCarona).toString();
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
