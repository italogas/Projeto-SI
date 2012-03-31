package si1project.logic;

public class Carona {
	private Integer idSessao;
	private Integer idCarona;
	private String origem;
	private String destino;
	private String data;
	private int vagas;
	private String hora;
	
	public Carona(int idSessao2, String origem2, String destino2,
			String data2, String hora2, int vagas2) {
			setIdSessao(idSessao2);
			setOrigem(origem2);
			setDestino(destino2);
			setData(data2);
			setHora(hora2);
			setVagas(vagas2);
			//TODO
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		//TODO
		this.hora = hora;
	}

	public int getIdSessao() {
		return idSessao;
	}


	public void setIdSessao(int idSessao2) {
		//TODO
		this.idSessao = idSessao2;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		//TODO
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		//TODO
		this.destino = destino;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		//TODO
		this.data = data;
	}


	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		//TODO
		this.vagas = vagas;
	}

	public String getTrajeto() {
		//TODO
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result
				+ ((idCarona == null) ? 0 : idCarona.hashCode());
		result = prime * result
				+ ((idSessao == null) ? 0 : idSessao.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + vagas;
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
		if (!(obj instanceof Carona)) {
			return false;
		}
		Carona other = (Carona) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (destino == null) {
			if (other.destino != null) {
				return false;
			}
		} else if (!destino.equals(other.destino)) {
			return false;
		}
		if (hora == null) {
			if (other.hora != null) {
				return false;
			}
		} else if (!hora.equals(other.hora)) {
			return false;
		}
		if (idCarona == null) {
			if (other.idCarona != null) {
				return false;
			}
		} else if (!idCarona.equals(other.idCarona)) {
			return false;
		}
		if (idSessao == null) {
			if (other.idSessao != null) {
				return false;
			}
		} else if (!idSessao.equals(other.idSessao)) {
			return false;
		}
		if (origem == null) {
			if (other.origem != null) {
				return false;
			}
		} else if (!origem.equals(other.origem)) {
			return false;
		}
		if (vagas != other.vagas) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Carona [origem=" + origem + ", destino=" + destino + ", data="
				+ data + ", vagas=" + vagas + ", hora=" + hora + "]";
	}

	public Object getAtributo(String nomeAtributo) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
