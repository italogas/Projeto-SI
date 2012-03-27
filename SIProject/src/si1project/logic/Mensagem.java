package si1project.logic;

public class Mensagem {
	TipoMensagem tipo;
	int idMenssagem;
	Usuario remetente;
	Usuario destinatario;
	String text;
	public Mensagem() {
		// TODO Auto-generated constructor stub
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
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	}