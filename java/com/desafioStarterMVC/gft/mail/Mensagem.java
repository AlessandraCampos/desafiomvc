package com.desafioStarterMVC.gft.mail;

public class Mensagem {

	private String remetente;

	private String destinatario;

	private String assunto;

	private String corpo;

	public Mensagem(String remetente, String destinatario, String assunto, String corpo) {
	
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.corpo = corpo;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

}
