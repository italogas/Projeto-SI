package si1project.logic;

public class Carona {
	private String idSessao;
	private String idCarona;
	private String origem;
	private String destino;
	private String data;
	private String vagas;
	private String hora;
	
	//private List<Mensagem> listaMensagens = new ArrayList<Mensagem>();

	public Carona(String idSessao2, String origem2, String destino2,
			String data2, String hora2, String vagas2) throws Exception {
			setIdSessao(idSessao2);
			setOrigem(origem2);
			setDestino(destino2);
			setData(data2);
			setHora(hora2);
			setVagas(vagas2);
			setIdCarona(this.hashCode() + "");
	}

	public String getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(String hashCode) {
		this.idCarona = hashCode;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) throws Exception {
		if(hora == null || hora.equals(""))
			throw new Exception("Hora inválida");
		//TODO fazer verificacao de hora valida batendo com o relogio
		this.hora = hora;
	}

	public String getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(String idSessao2) {
		this.idSessao = idSessao2;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) throws Exception {
		if(origem == null || origem.equals(""))
			throw new Exception("Origem inválida");
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) throws Exception {
		if(destino == null || destino.equals(""))
			throw new Exception("Destino inválido");
		this.destino = destino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) throws Exception {
		if(data == null || data.equals(""))
			throw new Exception("Data inválida");
		//TODO fazer checagem para datas batendo com o calendario
		this.data = data;
	}

	public String getVagas() {
		return vagas;
	}

	public void setVagas(String vagas2) throws Exception {
		if(vagas2 == null || vagas2.equals(""))
			throw new Exception("Vaga inválida");
		
		if(Integer.parseInt(vagas2) <= 0)
			throw new Exception("Vaga inválida");
		
		this.vagas = vagas2;
	}

	public String getTrajeto() {
		return this.origem + " - " + this.destino;
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
		result = prime * result + ((vagas == null) ? 0 : vagas.hashCode());
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
		if (vagas == null) {
			if (other.vagas != null) {
				return false;
			}
		} else if (!vagas.equals(other.vagas)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.origem + " para " + this.destino + ", no dia " + this.data + ", as " + hora;
	}

	public Object getAtributo(String nomeAtributo) throws Exception {
		if(nomeAtributo == null || nomeAtributo.equals(""))
			throw new Exception("Atributo inválido");
		
		if(nomeAtributo.equals("origem"))
			return this.getOrigem();
		else if(nomeAtributo.equals("destino"))
			return this.getDestino();
		else if(nomeAtributo.equals("data"))
			return this.getData();
		else if(nomeAtributo.equals("hora"))
			return this.getHora();
		else if(nomeAtributo.equals("vagas"))
			return this.getVagas();
		else
			throw new Exception("Atributo inexistente");
	}
	
	public String getCarona() {
		return this.toString();
	}
}
