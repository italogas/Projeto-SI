package si1project.logic;

import java.util.*;

public class SistemaCaronas {
	Collection<Usuario> listaUsuarios;
	Collection<Carona> listaCaronas;
	
	public void criarUsuario(String login, String senha, String email, String endereco) {
		//TODO
	}
	
	public void cadastrarCarona(String idSessao, String origem, 
			String destino, String data, String hora, int vagas) {
		//TODO
	}
	
	/*
	 * Retorna uma lista de id's de caronas 
	 */
	public List<String> localizarCarona(String idSessao, String origem, String destino) {
		//TODO
		return null;
	}
	
	public Object getAtributoCarona(String idCarona, String nomeAtributo) {
		//TODO
		return null;
	}
	
	public void abrirSessao(String login2, String senha2) {
		//TODO
	}
	
	public void fecharSessao(String login2) {
		//TODO
	}
}
