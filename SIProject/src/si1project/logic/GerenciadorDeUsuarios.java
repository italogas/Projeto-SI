package si1project.logic;

public class GerenciadorDeUsuarios {

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		
		if(GerenciadorDeDados.mapaLoginUsuario.containsKey(login))
			throw new Exception("Já existe um usuário com este login");
		
		for(Usuario u : GerenciadorDeDados.mapaLoginUsuario.values())
			if(u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");
		
		Usuario u = new Usuario(login, senha, nome, endereco, email);
		GerenciadorDeDados.mapaIdUsuario.put(u.getIdUsuario(), u);
		GerenciadorDeDados.mapaLoginUsuario.put(u.getLogin(), u);
	}

	public void criarUsuario(String login, String nome, String endereco) throws Exception {
		if(GerenciadorDeDados.mapaLoginUsuario.containsKey(login))
			throw new Exception("Já existe um usuário com este login");
		
		/*for(Usuario u : GerenciadorDeDados.mapaLoginUsuario.values())
			if(u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");*/
		
		Usuario u = new Usuario(login, nome, endereco);
		GerenciadorDeDados.mapaIdUsuario.put(u.getIdUsuario(), u);
		GerenciadorDeDados.mapaLoginUsuario.put(u.getLogin(), u);
	}

	public void criarUsuario(String login, String nome, String endereco,
			String email) throws Exception {
		if(GerenciadorDeDados.mapaLoginUsuario.containsKey(login))
			throw new Exception("Já existe um usuário com este login");
		
		for(Usuario u : GerenciadorDeDados.mapaLoginUsuario.values())
			if(u.getEmail().equals(email))
				throw new Exception("Já existe um usuário com este email");
		
		Usuario u = new Usuario(login, nome, endereco, email);
		GerenciadorDeDados.mapaIdUsuario.put(u.getIdUsuario(), u);
		GerenciadorDeDados.mapaLoginUsuario.put(u.getLogin(), u);
	}

	public String getAtributoUsuario(String login, String atributo) throws Exception {
		if(login == null || login.equals(""))
			throw new Exception("Login inválido");
		
		if(!GerenciadorDeDados.mapaLoginUsuario.containsKey(login))
			throw new Exception("Usuário inexistente");
		
		return GerenciadorDeDados.mapaLoginUsuario.get(login).getAtributo(atributo);
	}


}
