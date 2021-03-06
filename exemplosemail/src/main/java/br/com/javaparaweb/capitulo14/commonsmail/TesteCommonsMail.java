package br.com.javaparaweb.capitulo14.commonsmail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TesteCommonsMail {

	private static final String EMAIL = "livrojava@localhost";

	public static void main(String[] args) throws EmailException {

		Email email = new SimpleEmail();
		email.setHostName("localhost");
		email.setSmtpPort(25);
		email.setAuthentication(EMAIL, "123");
		email.setFrom(EMAIL, "Administrador");
		email.addTo("livrojava@localhost");
		email.setSubject("Teste de e-mail usando CommonsMail");
		email.setMsg("Corpo da mensagem");
		email.send();
		System.out.println("E-mail enviado com sucesso");

	}

}
