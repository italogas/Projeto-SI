package si1project.logic;


public class Sessao {
	private Usuario user;
	private int id;
	
	public Sessao(Usuario user) {
		setUser(user);
		setId(this.hashCode());
	}
	
	public Usuario getUser() {
		return user;
	}
	
	private void setId(int hashCode) {
		this.id = hashCode;
	}

	/* isso estah estranho, nao eh o usuario, mas sim o
	 * sistema que deve validar as coisas, principalmente
	 * uma sessao 
	 */
	public int abrirSessao(String login, String senha){
		//user.validaSessao(login, senha);
		return this.id;
		
	}
	private void setUser(Usuario user2) {
		//TODO: testes
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
