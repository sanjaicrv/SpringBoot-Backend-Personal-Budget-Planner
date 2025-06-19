package com.example.Personal.Budget.Planner.Gmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service

public class GmailServiceimpl {
	@Autowired
//	protocol
	private JavaMailSender sender; 
	
	@Value("${spring.mail.username}")
	private String fromMail;
	//727823tuit204 SanjaiCRV
	public String sendGmail(String toAdress) throws MessagingException {
		//message creating.
		MimeMessage message=sender.createMimeMessage();
		//sets parameters ,helper for mimeMessage
		MimeMessageHelper helper=new MimeMessageHelper(message);


		String htmlBody = """
		        <!DOCTYPE html>
		        <html lang="en">
		        <head>
		            <meta charset="UTF-8">
		            <meta name="viewport" content="width=device-width, initial-scale=1.0">
		            <title>Registration Confirmation</title>
		        </head>
		        <body style="font-family: Arial, sans-serif; text-align: center; padding: 20px;">
		            <h2 style="color: #2E86C1;">Welcome to Personal Budget Planner!</h2>
		            <p>Dear User,</p>
		            <p>Thank you for registering with <strong>Personal Budget Planner</strong>. You can now manage your income and expenses efficiently.</p>
		            
		            <!-- Budget Planning Image -->
		            <img src="https://www.shutterstock.com/image-vector/financial-accounting-flat-lay-concept-600nw-1851115834.jpg" 
		                 alt="Budget Planning" width="400" 
		                 style="border-radius: 10px; box-shadow: 2px 2px 10px rgba(0,0,0,0.1);">

		            <p>Start planning your budget today and take control of your financial future.</p>
		            
		            <p style="font-size: 16px; color: #27AE60;"><strong>Happy Budgeting!</strong></p>
		            
		            <p>If you have any questions, feel free to contact our support team.</p>
		            
		            <br>
		            <p style="font-size: 14px; color: gray;">Best Regards, <br>Personal Budget Planner Team</p>
		        </body>
		        </html>
		        """;


		helper.setSubject("Welcome");
		helper.setFrom(fromMail);
		helper.setTo(toAdress);
		boolean html=true;
		helper.setText(htmlBody,html);
		sender.send(message);
		return toAdress;
	}
	
}
