package net.api.mail.service;

import org.springframework.scheduling.annotation.Async;

import net.api.mail.dto.MensagemDTO;

public interface EmailServiceInterface {

	public void enviarEmail(MensagemDTO mensagem);
}
