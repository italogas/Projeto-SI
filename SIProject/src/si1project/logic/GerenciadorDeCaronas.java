package si1project.logic;

import java.util.List;

public class GerenciadorDeCaronas {

	public List<Integer> localizarCarona(int idSessao, String origem,
			String destino) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getCarona(int idCarona) {
		return GerenciadorDeDados.mapaIdCarona.get(idCarona).toString();
	}

	public void cadastrarCarona(int idSessao, String origem, String destino,
			String data, String hora, int vagas) {
		GerenciadorDeDados.mapaIdUsuario.get(GerenciadorDeDados.mapaIdSessao.get(idSessao).getIdUser()).
		cadastrarCarona(idSessao, origem, destino, data, hora, vagas);
		
	}

	public String getTrajeto(int idCarona) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAtributoCarona(int idCarona, String nomeAtributo) {
		// TODO Auto-generated method stub
		return null;
	}

}
