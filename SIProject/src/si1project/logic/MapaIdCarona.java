package si1project.logic;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapaIdCarona {
	Map<Integer, Carona> mapaCaronas = new TreeMap<Integer, Carona>();
	
	public Collection<Integer> localizarCarona(int idSessao, String origem,
			String destino)  throws Exception {
		List<Integer> caronasDisponiveis = new LinkedList<Integer>();
		return caronasDisponiveis;
		
		}

	public Carona get(int idCarona) {
		//TODO
		return null;
		
	}
	public int criarCarona(int idSessao2, String origem2,String destino2, String data2, String hora2, int vagas2){
		Carona carona = new Carona(idSessao2, origem2, destino2, data2, hora2, vagas2);
		mapaCaronas.put(idSessao2, carona);
		return idSessao2;
	}
	
}
