package br.com.alura.listavip.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	public void enviar(String nome, String emailDesttinataro) {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("hiagomiranda95@gmail.com", "953582179hmr"));
			email.setSSLOnConnect(true);
			email.setFrom("hiagomiranda95@gmail.com");
			email.setSubject("Você foi convidado pela ListaVIP");
			email.setMsg("Olá " + nome + ", Você acaba de ser convidado pela ListaVIP.");
			email.addTo(emailDesttinataro);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
