package emailapp;
import java.util.*; 
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*; 

import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setting the email for the user 
		Email email1 = new Email("Marja", "Centina");
		email1.showInfo();
		
		String to = "mkjaja410@yahoo.com";
		String from = email1.toString(); 
		String host = "localhost"; 
		
		//session object 
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host); 
		Session session = Session.getDefaultInstance(properties); 
		
		System.out.println("Would you like to change your password?");
		System.out.print("Press 'Y' for yes or 'N' for no: ");
		Scanner scan = new Scanner(System.in); 
		String input = scan.nextLine(); 
		if(input.contentEquals("Y")|| input.contentEquals("y"))
		{
			System.out.print("Please enter new password: "); 
			String newPW = scan.nextLine(); 
			email1.changePassword(newPW);
		}
		else
		{
			email1.showInfo();
		}
		email1.showInfo();
		
		/*
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from)); 
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Hello: ");
			message.setText("This is an example how to use this API."); 
			
			Transport.send(message);
			System.out.println("Message sent!"); 
		}
		catch(MessagingException mex)
		{
			mex.printStackTrace(); 
		}
		
		*/ 
	}

}
