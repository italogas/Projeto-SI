package si1project.logic;

import java.util.UUID;

public class Sessao {
	private Usuario user;
	private int id;
	
	public Sessao(Usuario user) {
		setUser(user);
	}
	public int abrirSessao(String login, String senha){
		user.validaSessao(login,senha);
		return id;
		
	}
	private void setUser(Usuario user2) {
		this.user = user2;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
