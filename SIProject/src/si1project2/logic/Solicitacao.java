package si1project2.logic;

public class Solicitacao {
	private String origem;
	private String destino;
	private String pontoEncontro;
	
	private String idDonoDaCarona;
	private String idDonoDaSolicitacao;
	
	private String idSolicitacao;
	
	public Solicitacao(String origem, String destino, String idDonoDaCarona, String idDonoDaSolicitacao, String ponto) {
		setOrigem(origem); // id da sessao do usuario requerente
		setDestino(destino);
		setIdDonoDaCarona(idDonoDaCarona);
		setIdDonoDaSolicitacao(idDonoDaSolicitacao);
		setPontoEncontro(ponto);

		setIdSolicitacao(this.hashCode() + "");
	}

	private void setIdSolicitacao(String idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	private void setIdDonoDaSolicitacao(String idDonoDaSolicitacao2) {
		this.idDonoDaSolicitacao = idDonoDaSolicitacao2;
	}

	private void setIdDonoDaCarona(String idDonoDaCarona2) {
		this.idDonoDaCarona = idDonoDaCarona2;
	}
	
	public String getIdDonoDaSolicitacao() {
		return this.idDonoDaSolicitacao;
	}
	
	public String getIdDonoDaCarona() {
		return this.idDonoDaCarona;
	}

	public Object getAtributo(String atributo) throws Exception {
		if(atributo == null || atributo.equals(""))
			throw new Exception("Atributo inválido");
		
		if(atributo.equals("origem"))
			return this.getOrigem();
		else if(atributo.equals("destino"))
			return this.getDestino();
		else if(atributo.equals("Dono da carona"))
			return this.getIdDonoDaCarona();
		else if(atributo.equals("Dono da solicitacao"))
			return this.getIdDonoDaSolicitacao();
		else if(atributo.equals("Ponto de Encontro"))
			return this.getPontoEncontro();
		else
			throw new Exception("Atributo inexistente");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result
				+ ((idDonoDaCarona == null) ? 0 : idDonoDaCarona.hashCode());
		result = prime
				* result
				+ ((idDonoDaSolicitacao == null) ? 0 : idDonoDaSolicitacao
						.hashCode());
		result = prime * result
				+ ((idSolicitacao == null) ? 0 : idSolicitacao.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result
				+ ((pontoEncontro == null) ? 0 : pontoEncontro.hashCode());
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
		if (!(obj instanceof Solicitacao)) {
			return false;
		}
		Solicitacao other = (Solicitacao) obj;
		if (destino == null) {
			if (other.destino != null) {
				return false;
			}
		} else if (!destino.equals(other.destino)) {
			return false;
		}
		if (idDonoDaCarona == null) {
			if (other.idDonoDaCarona != null) {
				return false;
			}
		} else if (!idDonoDaCarona.equals(other.idDonoDaCarona)) {
			return false;
		}
		if (idDonoDaSolicitacao == null) {
			if (other.idDonoDaSolicitacao != null) {
				return false;
			}
		} else if (!idDonoDaSolicitacao.equals(other.idDonoDaSolicitacao)) {
			return false;
		}
		if (idSolicitacao == null) {
			if (other.idSolicitacao != null) {
				return false;
			}
		} else if (!idSolicitacao.equals(other.idSolicitacao)) {
			return false;
		}
		if (origem == null) {
			if (other.origem != null) {
				return false;
			}
		} else if (!origem.equals(other.origem)) {
			return false;
		}
		if (pontoEncontro == null) {
			if (other.pontoEncontro != null) {
				return false;
			}
		} else if (!pontoEncontro.equals(other.pontoEncontro)) {
			return false;
		}
		return true;
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

	public String getPontoEncontro() {
		return pontoEncontro;
	}

	public void setPontoEncontro(String pontoEncontro) {
		//TODO
		this.pontoEncontro = pontoEncontro;
	}

	public String getIdSolicitacao() {
		return this.idSolicitacao;
	}
}
