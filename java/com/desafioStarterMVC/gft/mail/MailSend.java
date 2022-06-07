package com.desafioStarterMVC.gft.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSend {
	
	private final JavaMailSender javaMailSender;

	@Autowired
    public MailSend (JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
	
	public void enviar(Mensagem mensagem ) {
	
		SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
		
		simpleMailMessage.setFrom(mensagem.getRemetente()); 
		simpleMailMessage.setTo(mensagem.getDestinatario());
		simpleMailMessage.setSubject(mensagem.getAssunto());
		simpleMailMessage.setText(mensagem.getCorpo());	
		this.javaMailSender.send(simpleMailMessage);
	}

}
