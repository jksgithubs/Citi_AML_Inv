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
		Properties eProps = new Properties(); //create object of Property file
		eProps.put("mail.smtp.host", "smtp.gmail.com"); //set host of server
		eProps.put("mail.smtp.socketFactory.port", "465"); //set the port of socket factory
		eProps.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //set socket factory
		eProps.put("mail.smtp.auth", "true"); //set the authentication to true
		eProps.put("mail.smtp.port", "465"); //set the port of SMTP server
		
		Session session = Session.getDefaultInstance(eProps,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("hellojk", "jaikar13");
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
			String filename = "D:\\JKs Computer\\@GitRepo\\BR_CloudMig_MVP\\target\\cucumber-reports\\advanced-reports\\cucumber-html-reports\\report-tag_Features.html"; //file to be sent
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