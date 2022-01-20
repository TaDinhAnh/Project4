package com.demo.common;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {
	public static Boolean sendMail(String toEmail, String content, String subject) {
		try {

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Constant.fromEmail, Constant.password);
				}
			});
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(Constant.fromEmail, false));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			msg.setSubject(subject);
			msg.setContent(content, "text/html");
			msg.setSentDate(new Date());
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
