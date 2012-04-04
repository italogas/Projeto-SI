package si1project.logic;

public class Solicitacao {
	private String origem;
	private String destino;
	private String pontoEncontro;
	//private Mensagem mensagem; // composicao preferencialmente a heranca
	
	public Solicitacao(int idSessao, int idCarona, String ponto) {
		//TODO
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
}
