package si1project.logic;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SistemaCaronas {
	Map<String, Usuario> mapLoginUser = new TreeMap<String, Usuario>();

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		//TODO refatorar codigo para a criação de usuarios
		Usuario user = new Usuario(login, senha, nome, endereco, email);
		
		for(Usuario u : mapLoginUser.values())
			if(u.getEmail().equals(email))
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
		
		for(Usuario u : mapLoginUser.values())
			if(u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");

		
		if (!mapLoginUser.containsKey(login)) {
			mapLoginUser.put(user.getLogin(), user);
		} else {
			throw new Exception("Já existe um usuário com este login");
		}
	}

	public void cadastrarCarona(int idSessao, String origem, String destino,
			String data, String hora, int vagas) throws Exception {
		// gerenciadorDeCaronas.cadastrarCarona(idSessao, origem, destino, data,
		// hora, vagas);
	}

	/*
	 * Retorna o id da sessao aberta
	 */
	public int abrirSessao(String login, String senha) throws Exception {
		Sessao s = null;
		Usuario user = null;
		if(login == null || login.equals(""))
			throw new Exception("Login inválido");
		if(senha == null || senha.equals(""))
			throw new Exception("Senha inválida");
		
		if( !mapLoginUser.containsKey(login) )
			throw new Exception("Usuário inexistente");
		
		if( mapLoginUser.containsKey(login)) {
			user = mapLoginUser.get(login);
			s = new Sessao(user.getIdUsuario());
			if(user.validaSenha(senha)){
				return s.getIdSessao();
			}else {
				throw new Exception("Login inválido");
			}
		}
		
		else {
			
			return s.getIdSessao();
		}
	}

	public Object getAtributoUsuario(String login, String atributo)
			throws Exception {
		if(login == null || login.equals("")){
			throw new Exception("Login inválido");
		}
		if( !mapLoginUser.containsKey(login) )
			throw new Exception("Usuário inexistente");
		return mapLoginUser.get(login).getAtributo(atributo);
	}

	/*
	 * Retorna uma lista de id's de caronas
	 */
	public List<Integer> localizarCarona(int idSessao, String origem,
			String destino) throws Exception {
		return null;
		// return gerenciadorDeCaronas.localizarCarona(idSessao, origem,
		// destino);
	}

	public Object getAtributoCarona(int idCarona, String nomeAtributo)
			throws Exception {
		return nomeAtributo;
		// return gerenciadorDeCaronas.getAtributoCarona(idCarona,
		// nomeAtributo);
	}

	public String getTrajeto(int idCarona) {
		return null;
		// return gerenciadorDeCaronas.getTrajeto(idCarona);
	}

	public String getCarona(int idCarona) throws Exception {
		return null;
		// return gerenciadorDeCaronas.getCarona(idCarona);
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
