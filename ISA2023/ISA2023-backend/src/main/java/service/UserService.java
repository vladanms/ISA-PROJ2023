package service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import dto.UserDTO;
import model.ScheduledPickup;
import model.User;
import model.UserType;
import repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository users;
	@Autowired
	private JavaMailSender sender;
	
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
	
	public Boolean login(UserDTO userDTO)	
	{
		User toLogin = users.findByUsername(userDTO.getUsername());
		if(toLogin.getVerification() == null)
		{
			return false;
		}
		if(toLogin != null)
		{
			if(toLogin.getPassword() == userDTO.getPassword())
			{
				return true;
			}
		}
		toLogin = users.findByEmail(userDTO.getEmail());
		if(toLogin.getVerification() == null)
		{
			return false;
		}
		if(toLogin != null)
		{
			if(toLogin.getPassword() == userDTO.getPassword())
			{
				return true;
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
	
	public void emailVerification(String email) throws UnsupportedEncodingException, MessagingException
	{
		MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    helper.setFrom("registration@ISA.com", "ISA project");
	    helper.setTo(email);
	    helper.setSubject("Verify your account");
	    helper.setText("Hello<br><br>,"
	    		+ "To verify your account, click the following link:<br>"
	    		+ "http://localhost:8080/user/verify?verification=" + users.findByEmail(email).getVerification(),
	    		true
	    		);
	    sender.send(message);
	}
	
	public User getByUsername(String username) 
	{
		return users.findByUsername(username);
	}
	
	public void penalize(User user, int penalty)
	{
		user.setPenaltyPoints(user.getPenaltyPoints() + penalty);
		users.save(user);
	}
	
	
}
