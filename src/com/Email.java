package com;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	private String name;
	private String pass;
	private String host;
	private static Email email;
	private Authenticator authenticator;
	private Properties prop;
	private Session session;

	private Email(String name,String pass)
	{
		this.name=name;
		this.pass=pass;
		host="smtp."+name.split("@")[1];
		//System.out.println(host);
		authenticator = new MyAuthenticator(name,pass);
		prop=new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.auth", "true");
		session=Session.getInstance(prop, authenticator);
	}
	
	public static Email getInstance()
	{
		if(email!=null)
			return email;
		else
		{
			email=new Email("sduxhxcwlb@163.com","xuanwang2013");
			return email;
		}
	}

	
	public int sendMail(String to,String subject,String content)
	{
		MimeMessage message=new MimeMessage(session);
		try {
			message.setRecipient(RecipientType.TO,new InternetAddress(to));
			message.setContent(content, "text/html;charset=utf-8");
			message.setSubject(subject);
			message.setFrom(new InternetAddress(name));
			Transport.send(message);
			return 1;
		} catch (AddressException e) {
			e.printStackTrace();
			return -1;
		} catch (MessagingException e) {
			e.printStackTrace();
			return -1;
		}
		
	}

}

class MyAuthenticator extends Authenticator
{
	private String name;
	private String pass;
	
	
	public MyAuthenticator(String name,String pass)
	{
		this.name=name;
		this.pass=pass;
	}
	
	@Override
	public PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(name,pass);
	}
}
