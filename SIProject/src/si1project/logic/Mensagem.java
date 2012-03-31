package si1project.logic;

// FAZER TESTES EM SETS

public class Mensagem {
	TipoMensagem tipo;
	int idMenssagem;
	int idRemetente;
	int idDestinatario;
	String text;
	
	public Mensagem(String text, int idDestinatario, int idRemetente, TipoMensagem tipo) {
		setText(text);
		setIdDestinatario(idDestinatario);
		setIdRemetente(idRemetente);
		setTipo(tipo);
		setId(this.hashCode());
	}
	
	private void setId(int hashCode) {
		this.idMenssagem = hashCode;
	}
	
	public TipoMensagem getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}
	
	public int getIdMenssagem() {
		return idMenssagem;
	}
	
	public void setIdMenssagem(int idMenssagem) {
		this.idMenssagem = idMenssagem;
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