package si1project.logic;

import java.util.ArrayList;
import java.util.List;

public class Carona {
	private Integer idSessao;
	private Integer idCarona;
	private String origem;
	private String destino;
	private String data;
	private Integer vagas;
	private String hora;
	
	private List<Mensagem> listaMensagens = new ArrayList<Mensagem>();
	
	public Carona(Integer idSessao2, String origem2, String destino2,
			String data2, String hora2, int vagas2) {
			setIdSessao(idSessao2);
			setOrigem(origem2);
			setDestino(destino2);
			setData(data2);
			setHora(hora2);
			setVagas(vagas2);
			setIdCarona(hashCode());
			//TODO
	}

	public void setIdCarona(int hashCode) {
		this.idCarona = hashCode;
		
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


	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		//TODO
		this.vagas = vagas;
	}

	public String getTrajeto() {
		return origem + " - " + destino;
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
		return origem + " para " + destino + ", no dia " + data + ", as " + hora;
	}

	public Object getAtributo(String nomeAtributo) {
		if (nomeAtributo.equalsIgnoreCase("idCarona")) {
			return idCarona;
		}else if (nomeAtributo.equalsIgnoreCase("idSessao")) {
			return idSessao;
		}else if (nomeAtributo.equalsIgnoreCase("origem")) {
			return origem;
		}else if (nomeAtributo.equalsIgnoreCase("destino")) {
			return destino;
		}else if (nomeAtributo.equalsIgnoreCase("data")) {
			return data;
		}else if (nomeAtributo.equalsIgnoreCase("vagas")) {
			return vagas;
		}else if (nomeAtributo.equalsIgnoreCase("hora")) {
			return hora;
		}
		return null;
	}

	public Integer getIdCarona() {
		return idCarona;
	}


	
}
