package net.api.mail.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.api.mail.dto.MensagemDTO;
import net.api.mail.service.EmailServiceInterface;

@RestController
@RequestMapping("/enviar-email")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

	@Autowired
	private EmailServiceInterface emailServiceInterface;
	
	@PostMapping
	public ResponseEntity<Map<String, String>> enviarMensagem(@RequestBody MensagemDTO mensagem) {
		emailServiceInterface.enviarEmail(mensagem);
		Map<String, String> response = new HashMap<>();
		response.put("mensagem", "\"Mensagem enviada!");
		return ResponseEntity.ok(response);
	}

}
