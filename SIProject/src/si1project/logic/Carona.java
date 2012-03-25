package si1project.logic;

public class Carona {
	private String idSessao;
	private String origem;
	private String destino;
	private String data;
	private int vagas;
	private String hora;
	

	public Carona(String idSessao2, String origem2, String destino2,
			String data2, String hora2, int vagas2) {
			setIdSessao(idSessao2);
			setOrigem(origem2);
			setDestino(destino2);
			setData(data2);
			setHora(hora2);
			setVagas(vagas2);
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		//TODO
		this.hora = hora;
	}

	public String getIdSessao() {
		return idSessao;
	}


	public void setIdSessao(String idSessao) {
		//TODO
		this.idSessao = idSessao;
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
	
}
