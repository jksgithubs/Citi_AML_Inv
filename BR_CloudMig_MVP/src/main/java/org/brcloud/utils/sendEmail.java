package org.brcloud.utils;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendEmail {
	public static void Send() {
		Properties props = new Properties(); //create object of Property file
		props.put("mail.smtp.host", "smtp.gmail.com"); //set host of server
		props.put("mail.smtp.socketFactory.port", "465"); //set the port of socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //set socket factory
		props.put("mail.smtp.auth", "true"); //set the authentication to true
		props.put("mail.smtp.port", "465"); //set the port of SMTP server
	 
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("add your email", "add your password");
				}
			});
		
		try {
			Message message = new MimeMessage(session); // Create object of MimeMessage class
			message.setFrom(new InternetAddress("hellojk@gmail.com")); //from
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("hellojk@gmail.com")); //to
			message.setSubject("Testing Subject"); //add subject
			
			BodyPart msgBody = new MimeBodyPart(); //create object to add multimedia type content
			msgBody.setText("This is message body"); //set email body
	 
				MimeBodyPart fileBody = new MimeBodyPart(); //create another object to add another content
			String filename = "D:\\a.xlsx"; //file to be sent
			DataSource source = new FileDataSource(filename); //create data source and pass the filename
			fileBody.setDataHandler(new DataHandler(source)); //set the handler
			fileBody.setFileName(filename); //set the file
	 
				Multipart multipart = new MimeMultipart(); //create object of MimeMultipart class
			multipart.addBodyPart(msgBody); //add msgBody
			multipart.addBodyPart(fileBody); // add fileBody
			message.setContent(multipart); //set the content
			Transport.send(message); //send the email
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}