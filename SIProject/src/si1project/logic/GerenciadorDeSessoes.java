package si1project.logic;

import java.util.Map;
import java.util.TreeMap;

public class GerenciadorDeSessoes {
	private Map<Integer, Sessao> mapaIdSessoesAbertas = new TreeMap<Integer, Sessao>();
	
	/**
	 * Se sessao nao existir ele cria
	 * uma nova e adiciona aos mapas do
	 * GerenciadorDeDados: mapaLoginSessao e
	 * mapaIdSessao.
	 * 
	 * @param login2
	 * @param senha2
	 * @return
	 * @throws Exception
	 * 
	 * @see GerenciadorDeDados
	 */
	public int abrirSessao(String login2, String senha2) throws Exception {
		if(login2 == null || login2.equals(""))
			throw new Exception("Login inválido");
		if(senha2 == null || senha2.equals(""))
			throw new Exception("Senha inválida");
		
		if( !GerenciadorDeDados.mapaLoginUsuario.containsKey(login2) )
			throw new Exception("Usuário inexistente");
		
		if( GerenciadorDeDados.mapaLoginUsuario.containsKey(login2) &&
				!GerenciadorDeDados.mapaLoginSessao.containsKey(login2) ) {
			
			Sessao s = new Sessao(GerenciadorDeDados.mapaLoginUsuario.get(login2).getIdUsuario());
			GerenciadorDeDados.mapaIdSessao.put(s.getIdSessao(), s);
			GerenciadorDeDados.mapaLoginSessao.put(login2, s);
			mapaIdSessoesAbertas.put(s.getIdSessao(), s);

			return s.getIdSessao();
		}
		else {
			//TODO verificar se fica melhor conversar com um mapa no GerenciadorDeDados ou
			//TODO um mapa da propria classe
			return GerenciadorDeDados.mapaLoginSessao.get(login2).getIdSessao();
		}
	}
	
	public void encerrarSessao(String login) {
		//TODO
	}

}
