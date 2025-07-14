package net.api.mail.service;

import net.api.mail.dto.MensagemDTO;

public interface EmailServiceInterface {

	public void enviarEmail(MensagemDTO mensagem);
}
