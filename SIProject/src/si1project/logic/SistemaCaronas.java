package si1project.logic;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SistemaCaronas {
	Map<String, Usuario> mapLoginUser = new TreeMap<String, Usuario>();
	Map<Integer, Carona> mapCaronas = new TreeMap<Integer, Carona>();
	Map<Integer, Sessao> mapSessoes = new TreeMap<Integer, Sessao>();

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		// TODO refatorar codigo para a criação de usuarios
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

	public Integer cadastrarCarona(Integer idSessao, String origem, String destino,
			String data, String hora, Integer vagas) throws Exception {
		Carona carona = new Carona(idSessao, origem, destino, data, hora, vagas);
		mapCaronas.put(carona.getIdCarona(), carona);
		return carona.getIdCarona();
	}

	/*
	 * Retorna o id da sessao aberta
	 */
	public int abrirSessao(String login, String senha) throws Exception {
		Sessao s = null;
		Usuario user = null;
		if (login == null || login.equals(""))
			throw new Exception("Login inválido");
		else if (senha == null || senha.equals(""))
			throw new Exception("Senha inválida");

		else if (!mapLoginUser.containsKey(login))
			throw new Exception("Usuário inexistente");

		else if (mapLoginUser.containsKey(login)) {
			user = mapLoginUser.get(login);
			s = new Sessao(user.getIdUsuario());
			if (user.validaSenha(senha)) {
				return s.getIdSessao();
			} else {
				throw new Exception("Login inválido");
			}
		} else {
			mapSessoes.put(s.getIdSessao(), s);
			return s.getIdSessao();
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
	 * Retorna uma lista de id's de caronas
	 */
	public Map<Integer, Carona> localizarCarona(Integer idSessao, String origem,
			String destino) throws Exception {

		Map<Integer, Carona> caronasLocalizadas = new TreeMap<Integer, Carona>();
		
		for (Integer idCarona : mapCaronas.keySet()) {
			Carona carona = mapCaronas.get(idCarona);
			if (carona.getOrigem().equalsIgnoreCase(origem)
					&& carona.getDestino().equalsIgnoreCase(destino)) {
				caronasLocalizadas.put(idCarona, carona);
			}
		}
		System.out.println(caronasLocalizadas.keySet());
		return caronasLocalizadas;
	}

	public Object getAtributoCarona(Integer idCarona, String nomeAtributo)
			throws Exception {
		return mapCaronas.get(idCarona).getAtributo(nomeAtributo).toString();
	}

	public String getTrajeto(Integer idCarona) {
		return mapCaronas.get(idCarona).getTrajeto();
	}

	public String getCarona(Integer idCarona) throws Exception {
		return mapCaronas.get(idCarona).toString();
	}

	public void encerrarSessao(String login) {
		// gerenciadorDeSessoes.encerrarSessao(login);
	}

	/*
	 * torna null todos os objetos que estao sendo manipulados atualmente pelo
	 * sistema
	 */
	public void zerarSistema() {
		// TODO
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
