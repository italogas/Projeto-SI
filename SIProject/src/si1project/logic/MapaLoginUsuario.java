package si1project.logic;

import java.util.Map;
import java.util.TreeMap;

public class MapaLoginUsuario {
	Map<String, Usuario> mapaUsu= new TreeMap<String, Usuario>();

	public Object get(String login) {
		return mapaUsu.get(login);
	}

	public void criar(String login, String senha, String nome, String endereco,
			String email) throws Exception {
		Usuario user = new Usuario(login, senha, nome, endereco, email);
		mapaUsu.put(login, user);
		
	}
}
