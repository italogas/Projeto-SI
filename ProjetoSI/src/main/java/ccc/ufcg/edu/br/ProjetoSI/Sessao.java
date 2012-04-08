package ccc.ufcg.edu.br.ProjetoSI;


public class Sessao {
	private String idUser;
	private String idSessao;

	public Sessao(String idUsuario) {
		setIdUser(idUsuario);
		setId(this.hashCode() + ""); // id da propria sessao
	}
	
	public String getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(String idSessao) {
		this.idSessao = idSessao;
	}
	
	public String getIdUser() {
		return idUser;
	}
	
	private void setId(String hashCode) {
		this.idSessao = hashCode;
	}

	private void setIdUser(String idUsuario) {
		this.idUser = idUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSessao == null) ? 0 : idSessao.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		if (idSessao == null) {
			if (other.idSessao != null) {
				return false;
			}
		} else if (!idSessao.equals(other.idSessao)) {
			return false;
		}
		if (idUser == null) {
			if (other.idUser != null) {
				return false;
			}
		} else if (!idUser.equals(other.idUser)) {
			return false;
		}
		return true;
	}
}
