package org.lobofactory.Prueba2jsf;

import java.util.Properties;

import javax.faces.event.ActionEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ContactBean {

	private String remitente;
	private String correoRemitente;
	private String mensaje;
	private Properties envioProperties;
	private static final Log LOGGER = LogFactory.getLog(ContactBean.class);
	public void sendMessage(ActionEvent ae){
		LOGGER.info("Preparando envío");
		Session session = Session.getDefaultInstance(envioProperties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(envioProperties.getProperty("login"), envioProperties.getProperty("password"));
					}
				  });
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("correoRemitente"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(envioProperties.getProperty("login")));
			message.setSubject(String.format(envioProperties.getProperty("asunto"),remitente));
			message.setText(mensaje);
			LOGGER.info("Enviando correo");
			Transport.send(message);
 
			LOGGER.info("Correo Enviado");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getCorreoRemitente() {
		return correoRemitente;
	}
	public void setCorreoRemitente(String correoRemitente) {
		this.correoRemitente = correoRemitente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Properties getEnvioProperties() {
		return envioProperties;
	}
	public void setEnvioProperties(Properties envioProperties) {
		this.envioProperties = envioProperties;
	}
	
}
