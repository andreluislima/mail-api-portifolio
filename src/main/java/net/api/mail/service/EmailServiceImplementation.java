package net.api.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import net.api.mail.dto.MensagemDTO;

@Service
public class EmailServiceImplementation implements EmailServiceInterface{

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	@Override
	public void enviarEmail(MensagemDTO mensagem) {
		 SimpleMailMessage email = new SimpleMailMessage();
		 
		 email.setFrom("andrelimag89@gmail.com");
		 email.setReplyTo(mensagem.getEmail());
		 email.setTo("andrelimag89@gmail.com");
		 email.setSubject("Mensagem de " + mensagem.getName());
		 email.setText(mensagem.getMessage());
		 
		 mailSender.send(email);
	}

}
