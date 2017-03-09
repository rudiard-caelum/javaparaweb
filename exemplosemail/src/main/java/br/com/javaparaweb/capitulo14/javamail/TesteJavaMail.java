package br.com.javaparaweb.capitulo14.javamail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TesteJavaMail {

	private static final String EMAIL = "livrojava@localhost";

	public static void main(String[] args) throws AddressException, MessagingException {
		Properties config = new Properties();
		config.setProperty("mail.smtp.host", "localhost");
		config.setProperty("mail.smtp.port", "25");
		config.setProperty("mail.smtp.auth", "true");

		Session sessao = Session.getInstance(config, new Autenticacao(EMAIL, "123"));
		MimeMessage email = new MimeMessage(sessao);
		email.setFrom(new InternetAddress(EMAIL));
		email.setRecipient(Message.RecipientType.TO, new InternetAddress("livrojava@localhost"));
		email.setSubject("Teste de e-mail usando JavaMail");
		email.setSentDate(new Date());
		email.setText("Corpo da mensagem");
		Transport.send(email);
		System.out.println("E-mail enviado com sucesso.");
	}

}
