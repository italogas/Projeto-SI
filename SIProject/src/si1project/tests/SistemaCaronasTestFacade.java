package si1project.tests;

import java.util.Collection;

import si1project.logic.Carona;
import si1project.logic.Sessao;
import si1project.logic.Solicitacao;
import si1project.logic.Usuario;

public class SistemaCaronasTestFacade {
	Collection<Usuario> listaUsuarios;
	Collection<Carona> listaCaronas;
	Sessao sessaoAtual;
	
	public void criarUsuario(String login, String senha, String nome, String endereco, String email) {
		//TODO
	}
	
	public void criarUsuario(String login, String nome, String endereco) {
		//TODO
	}
	
	public void cadastrarCarona(String idSessao, String origem, 
			String destino, String data, String hora, int vagas) {
		//TODO
	}
	
	/*
	 * Retorna uma lista de id's de caronas 
	 */
	public Collection<String> localizarCarona(String idSessao, String origem, String destino) {
		//TODO
		return null;
	}
	
	public Object getAtributoCarona(String idCarona, String nomeAtributo) {
		//TODO
		return null;
	}
	
	public Object getAtributoUsuario(String login, String atributo) {
		//TODO
		return null;
	}
	
	public String getTrajeto(String idCarona) {
		//TODO
		return null;
	}
	
	public Carona getCarona(String idCarona) {
		//TODO
		return null;
	}
	
	public Sessao abrirSessao(String login2, String senha2) {
		//TODO
		return null;
	}
	
	public void encerrrarSessao(String login) {
		//TODO
	}
	
	public void zerarSistema() {
		//TODO
	}
	
	public void encerrarSistema() {
		//System.exit(0);
	}
	
	public void sugerirPontoEncontro(String idSessao, String idCarona,
			String pontos) {
		//TODO
	}
	
	public void responderSugestaoPontoEncontro(String idSessao, String idCarona,
			String idSugestao, String pontos) {
		//TODO
	}
	
	public Solicitacao solicitarVagaPontoEncontro(String idSessao, String idCarona, String ponto) {
		//TODO
		return null;
	}
	
	public Object getAtributoSolicitacao(String idSolicitacao, String atributo) {
		//TODO
		return null;
	}
	
	public void aceitarSolicitacaoPontoEncontro(String idSessao, String idSolicitacao) {
		//TODO
	}
	
	public void desistirRequisicao(String idSessao, String idCarona, String idSugestao) {
		//TODO
	}
	
	public Solicitacao solicitarVaga(String idSessao, String idCarona) {
		//TODO
		return null;
	}
	
	public void rejeitarSolicitacao(String idSessao, String idSolicitacao) {
		//TODO
	}
	
	public void aceitarSolicitacao(String idSessao, String idSolicitacao) {
		//TODO
	}
}
