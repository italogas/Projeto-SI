package si1project.logic;

import java.util.Map;
import java.util.TreeMap;

/**
 * A responsabilidade dessa classe
 * eh lidar com os mapas mais gerais
 * do sistema, que manipulam ids e 
 * suas respectivas entidades.
 * 
 * @author guilhermemg
 *
 */
public class GerenciadorDeDados {
	static Map<Integer, Sessao> mapaIdSessao = new TreeMap<Integer, Sessao>();
	static Map<Integer, Carona> mapaIdCarona = new TreeMap<Integer, Carona>();
	static Map<Integer, Mensagem> mapaIdMensagem = new TreeMap<Integer, Mensagem>();
	static Map<Integer, Usuario> mapaIdUsuario = new TreeMap<Integer, Usuario>();
	
	static Map<String, Usuario> mapaLoginUsuario = new TreeMap<String, Usuario>();
	static Map<String, Sessao> mapaLoginSessao = new TreeMap<String, Sessao>();
}
 