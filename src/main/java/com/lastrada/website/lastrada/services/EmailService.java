package com.lastrada.website.lastrada.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
    private String mailFrom;
	
	void sendEmail(String emailTo,String custName, String subject) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailFrom);
        msg.setTo(emailTo);
        msg.setSubject(subject);
        msg.setText(getMailText(custName));
        
       
  
        javaMailSender.send(msg);
       
    }
	
	private String getMailText(String custName) {
		StringBuilder sb=new StringBuilder();
		sb.append("Guten Tag "+custName+",\n\n");
		sb.append("vielen Dank  für Ihre Bestellung beim La Strada.Ihre Bestellung wird nun bearbeitet.");
		sb.append("\n\n\n");
		sb.append("Mit Freundlichen Grüßen \n");
		sb.append("La Strada Ravensburg");
		return sb.toString();
	}
	
}
