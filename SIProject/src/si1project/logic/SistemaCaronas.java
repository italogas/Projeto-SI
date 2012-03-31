package si1project.logic;

import java.util.List;

public class SistemaCaronas {
	MapaLoginUsuario mapaLoginUsuarios;
	MapaIdCarona mapaIdCaronas;
	GerenciadorDeMensagens gerenciadorDeMensagens;
	GerenciadorDeSessoes gerenciadorDeSessoes;

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		Usuario u = new Usuario(login, senha, nome, endereco, email);	
		mapaLoginUsuarios.addUsuario(u);
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
	public List<Integer> localizarCarona(int idSessao, String origem,
			String destino)  throws Exception {
		// TODO
		return null;
	}

	public Object getAtributoCarona(int idCarona, String nomeAtributo) throws Exception {
		return   ((Carona) mapaIdCaronas.get(idCarona)).getAtributo(nomeAtributo);
	}

	public Object getAtributoUsuario(String login, String atributo) throws Exception  {
		return   ((Usuario) mapaLoginUsuarios.get(login)).getAtributo(atributo);
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
		// se nao existe sessao aberta com esse usuario: entao 
		// cria sessao e valida-a no construtor de sessao
		// caso contrario busca sessao no mapa e 
		// TODO
		return -1;
	}

	public void encerrarSessao(String login) {
		// TODO
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

	public MapaLoginUsuario getMapaLoginUsuarios() {
		return mapaLoginUsuarios;
	}

	public MapaIdCarona getMapaIdCaronas() {
		return mapaIdCaronas;
	}

	public GerenciadorDeMensagens getGerenciadorDeMensagens() {
		return gerenciadorDeMensagens;
	}

	public GerenciadorDeSessoes getGerenciadorDeSessoes() {
		return gerenciadorDeSessoes;
	}
}
