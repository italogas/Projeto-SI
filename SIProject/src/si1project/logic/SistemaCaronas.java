package si1project.logic;

import java.util.*;

public class SistemaCaronas {
	Collection<Usuario> listaUsuarios;
	Collection<Carona> listaCaronas;
	Sessao sessaoAtual;

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) {
		// TODO
	}

	public void criarUsuario(String login, String nome, String endereco) {
		// TODO
	}

	public void criarUsuario(String login, String nome, String endereco,
			String email) {
		// TODO
	}

	public void cadastrarCarona(int idSessao, String origem, String destino,
			String data, String hora, int vagas)  throws Exception  {
		// TODO
	}

	/*
	 * Retorna uma lista de id's de caronas
	 */
	public Collection<Integer> localizarCarona(int idSessao, String origem,
			String destino)  throws Exception {
		// TODO
		return null;
	}

	public Object getAtributoCarona(int idCarona, String nomeAtributo) throws Exception {
		// TODO
		return null;
	}

	public Object getAtributoUsuario(String login, String atributo) throws Exception  {
		// TODO
		return null;
	}

	public String getTrajeto(int idCarona) {
		// TODO
		return null;
	}

	public Carona getCarona(int idCarona)  throws Exception {
		// TODO
		return null;
	}

	/*
	 * Retorna o id da sessao aberta
	 */
	public int abrirSessao(String login2, String senha2) {
		// TODO
		return -1;
	}

	public void encerrarSessao(String login) {
		// TODO
	}

	public void zerarSistema() {
		// TODO
	}

	public void encerrarSistema() {
		// System.exit(0);
	}
	
	/*
	 * Retorna id da Mensagem enviada
	 */
	public int sugerirPontoEncontro(int idSessao, int idCarona,
			String pontos) {
		// TODO
		return -1;
	}

	public void responderSugestaoPontoEncontro(int idSessao,
			int idCarona, int idSugestao, String pontos) {
		// TODO
	}
	
	/*
	 * Retorna id da Mensagem enviada
	 */
	public int solicitarVagaPontoEncontro(int idSessao,
			int idCarona, String ponto) {
		// TODO
		return -1;
	}

	public Object getAtributoSolicitacao(int idSolicitacao, String atributo) {
		// TODO
		return null;
	}

	public void aceitarSolicitacaoPontoEncontro(int idSessao,
			int idSolicitacao) {
		// TODO
	}

	public void desistirRequisicao(int idSessao, int idCarona,
			int idSugestao) {
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
