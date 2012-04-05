package si1project2.logic;


public class Sessao {
	private int idUser;
	private String idSessao;

	public Sessao(int idUsuario) {
		setIdUser(idUsuario);
		setId(this.hashCode() + ""); // id da propria sessao
	}
	
	public String getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(String idSessao) {
		this.idSessao = idSessao;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	private void setId(String hashCode) {
		this.idSessao = hashCode;
	}

	private void setIdUser(int idUsuario) {
		this.idUser = idUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Sessao)) {
			return false;
		}
		Sessao other = (Sessao) obj;
		if (idSessao != other.idSessao) {
			return false;
		}
		if (idUser != other.idUser) {
			return false;
		}
		return true;
	}
}
