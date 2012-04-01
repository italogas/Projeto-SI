package si1project.logic;

import java.util.List;

public class SistemaCaronas {
	GerenciadorDeSessoes gerenciadorDeSessoes = new GerenciadorDeSessoes();
	GerenciadorDeMensagens gerenciadorDeMensagens = new GerenciadorDeMensagens();
	GerenciadorDeCaronas gerenciadorDeCaronas = new GerenciadorDeCaronas();
	GerenciadorDeUsuarios gerenciadorDeUsuarios = new GerenciadorDeUsuarios();
	
	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		gerenciadorDeUsuarios.criarUsuario(login, senha, nome, endereco, email);
	}

	public void criarUsuario(String login, String nome, String endereco) throws Exception {
		gerenciadorDeUsuarios.criarUsuario(login, nome, endereco);
	}

	public void criarUsuario(String login, String nome, String endereco,
			String email) throws Exception {
		gerenciadorDeUsuarios.criarUsuario(login, nome, endereco, email);
	}

	public void cadastrarCarona(int idSessao, String origem, String destino,
			String data, String hora, int vagas)  throws Exception  {
		gerenciadorDeCaronas.cadastrarCarona(idSessao, origem, destino, data, hora, vagas);
	}

	/*
	 * Retorna uma lista de id's de caronas
	 */
	public List<Integer> localizarCarona(int idSessao, String origem,
			String destino)  throws Exception {
		return gerenciadorDeCaronas.localizarCarona(idSessao, origem, destino);
	}

	public Object getAtributoCarona(int idCarona, String nomeAtributo) throws Exception {
		return gerenciadorDeCaronas.getAtributoCarona(idCarona, nomeAtributo);
	}

	public String getAtributoUsuario(String login, String atributo) throws Exception  {
		return gerenciadorDeUsuarios.getAtributoUsuario(login, atributo);
	}

	public String getTrajeto(int idCarona) {
		return gerenciadorDeCaronas.getTrajeto(idCarona);
	}

	public String getCarona(int idCarona)  throws Exception {
		return gerenciadorDeCaronas.getCarona(idCarona);
	}

	/*
	 * Retorna o id da sessao aberta
	 */
	public int abrirSessao(String login2, String senha2) throws Exception {
		return gerenciadorDeSessoes.abrirSessao(login2, senha2);
	}

	public void encerrarSessao(String login) {
		gerenciadorDeSessoes.encerrarSessao(login);
	}
	
	/*
	 * torna null todos os
	 * objetos que estao sendo manipulados atualmente
	 * pelo sistema
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
	public int sugerirPontoEncontro(int idSessao, int idCarona,
			String ponto) {
		//return gerenciadorDeMensagens.sugerirPontoEncontro(idSessao, idCarona, ponto);
		//TODO
		return -1;
	}

	public void responderSugestaoPontoEncontro(int idSessao,
			int idCarona, int idSugestao, String pontos) {
		//TODO
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
		//TODO
		//return gerenciadorDeMensagens.getAtributoSolicitacao(idSolicitacao, atributo);
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
