package controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dto.UserDTO;
import model.UserType;
import net.bytebuddy.utility.RandomString;
import model.User;
import service.UserService;

public class UserController {

	@Autowired
	private UserService service;
	private User currentUser = new User();
	
	@PostMapping("/register")
	public String register(@RequestBody UserDTO userDTO) throws MessagingException, UnsupportedEncodingException
	{
		User user = new User();
		
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setGender(userDTO.getGender());
		user.setPersonalId(userDTO.getPersonalId());
		user.setAddress(userDTO.getAddress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.setPhone(userDTO.getPhone());
		user.setType(UserType.Unauthorized);
		user.setRewardPoints(0);
		user.setPenaltyPoints(0);
		user.setVerification(RandomString.make(20));
		
		if(service.register(user) == "usernameError")
		{
			return "usernameError";
		}
		if(service.register(user) == "emailError")
		{
			return "emailError";
		}
		if(service.register(user) == "emailError")
		{
			return "emailError";
		}
		
		return "success";
	}
	

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDTO userDTO){
		if(service.login(userDTO)) {
			currentUser = service.getByUsername(userDTO.getUsername());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/verify")
	public Boolean verify(@Param("verification") String verification) {
	    if (service.verify(verification)) {
	        return true;
	    } else {
	        return false;
	    }
	}
}
