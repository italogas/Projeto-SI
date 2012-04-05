package si1project2.logic;

// FAZER TESTES EM SETS

public class Mensagem {
	TipoMensagem tipo;
	int idMensagem;
	int idRemetente;
	int idDestinatario;
	String text;
	
	public Mensagem(String text, int idDestinatario, int idRemetente, TipoMensagem tipo) {
		setText(text);
		setIdDestinatario(idDestinatario);
		setIdRemetente(idRemetente);
		setTipo(tipo);
		setIdMensagem(this.hashCode());
	}
	
	public TipoMensagem getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}
	
	public int getIdMensagem() {
		return idMensagem;
	}
	
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	
	public int getIdRemetente() {
		return idRemetente;
	}
	
	public void setIdRemetente(int idRemetente) {
		this.idRemetente = idRemetente;
	}
	
	public int getIdDestinatario() {
		return idDestinatario;
	}
	
	public void setIdDestinatario(int destinatario) {
		this.idDestinatario = destinatario;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
