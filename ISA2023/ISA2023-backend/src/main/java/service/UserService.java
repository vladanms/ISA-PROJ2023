package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.google.zxing.WriterException;

import dto.UserDTO;
import model.Company;
import model.ScheduledPickup;
import model.User;
import model.UserType;
import repository.UserRepository;
import service.QRService;

public class UserService {
	
	@Autowired
	private UserRepository users;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private QRService QRservice;
	
	public String register(User user) throws MessagingException, UnsupportedEncodingException {
		User toRegister = users.findByEmail(user.getEmail());
		if(toRegister != null) {
			return "emailError";
		}
		toRegister = users.findByUsername(user.getUsername());
		if(toRegister != null) {
			return "usernameError";
		}
		toRegister = users.findByEmail(user.getPersonalId());
		if(toRegister != null) {
			return "idError";
		}
		users.save(user);
		return "success";
	}
	
	public String login(String credentials, String password)	
	{
		User toLogin = users.findByUsername(credentials);
		if(toLogin.getVerification() == null)
		{
			return null;
		}
		if(toLogin != null)
		{
			if(toLogin.getPassword() == password)
			{
				return "username";
			}
		}
		toLogin = users.findByEmail(credentials);
		if(toLogin.getVerification() == null)
		{
			return null;
		}
		if(toLogin != null)
		{
			if(toLogin.getPassword() == password)
			{
				return "email";
			}
		}
		return null;
	}
	
	public Boolean checkType(String type, String username)
	{		
	    if(username == null)
		{
			return false;
		}
		if(users.findByUsername(username).getType().toString() != null)
		{
			if(users.findByUsername(username).getType().toString() == type)
			{
			return true;
			}else
			return false;
		}
		if(users.findByEmail(username).getType().toString() != null)
		{
		{
			if(users.findByEmail(username).getType().toString() == type)
			{
			return true;
			}else
			return false;
		}
		}
		return false;
	}
	
	public Boolean verify(String authorization)
	{
		User user = users.findByVerification(authorization);
		if(user == null)
		{
			return false;
		}
		user.setType(UserType.Registered);
		users.save(user);
		return true;	
		
	}
	
	public void emailVerification(String email) throws MessagingException, WriterException, IOException
	{
		MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    helper.setFrom("registration@ISA.com", "ISA project");
	    helper.setTo(email);
	    helper.setSubject("Verify your account");
	    helper.setText("Hello<br><br>,"
	    		+ "To verify your account, click the following link:<br>"
	    		+ "http://localhost:8080/user/verify?verification=" + users.findByEmail(email).getVerification()
	    		+ "or scan the attached code"
	    		+ "<img src=\""
	    		+ QRservice.createQRImage("http://localhost:8080/user/verify?verification=" + users.findByEmail(email).getVerification())
	    		+ "\">",
	    		true
	    		);	    
	    sender.send(message);
	}
	
	public User getByUsername(String username) 
	{
		return users.findByUsername(username);
	}
	
	public User getByEmail(String email) 
	{
		return users.findByEmail(email);
	}
	
	
	public User getByPersonalId(String username) 
	{
		return users.findByPersonalId(username);
	}
	
	public void penalize(User user, int penalty)
	{
		user.setPenaltyPoints(user.getPenaltyPoints() + penalty);
		users.save(user);
	}
	
	public String getCredentialsEmail(String credentials)
	{
    	if(users.findByEmail(credentials) != null)
    	{
    		return credentials;
    	}
    	else if(users.findByUsername(credentials) != null)
    	{
    		return users.findByUsername(credentials).getEmail();
    	}
    	else
    		return null;
	}
	
	public String getType(String credentials)
	{
		if(users.findByEmail(credentials) != null)
		{
			return users.findByEmail(credentials).getType().toString();
		}
		else if(users.findByUsername(credentials) != null)
		{
			return users.findByUsername(credentials).getType().toString();
		}
		else
		{
		return "guest";
		}
	}
	
	public ArrayList<User> getAdmins(Company company)
	{
		return company.getAdmins();
	}
	
}
