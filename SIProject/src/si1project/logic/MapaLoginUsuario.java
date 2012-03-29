package si1project.logic;

import java.util.Map;
import java.util.TreeMap;

public class MapaLoginUsuario {
	Map<String, Usuario> mapaUsu= new TreeMap<String, Usuario>();

	public Object get(String login) {
		return mapaUsu.get(login);
	}

	public void addUsuario(Usuario u) throws Exception {
		//TODO testar
		mapaUsu.put(u.getLogin(), u);
	}
}
