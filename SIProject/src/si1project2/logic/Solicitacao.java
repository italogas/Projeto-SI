package si1project2.logic;

public class Solicitacao {
	private String origem;
	private String destino;
	private String pontoEncontro;
	
	private String idDonoDaCarona;
	private String idDonoDaSolicitacao;
	
	private boolean aceita = false;
	private String idSolicitacao;
	
	public Solicitacao(String origem, String destino, String idDonoDaCarona, String idDonoDaSolicitacao, String ponto) {
		setOrigem(origem); // id da sessao do usuario requerente
		setDestino(destino);
		setIdDonoDaCarona(idDonoDaCarona);
		setIdDonoDaSolicitacao(idDonoDaSolicitacao);
		//TODO
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
		//else if(atributo.equals("Dono da carona"))
		//	return this.getDestinatario();
		//else if(atributo.equals("Dono da solicitacao"))
		//	return this.getRemetente();
		else
			throw new Exception("Atributo inexistente");
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
