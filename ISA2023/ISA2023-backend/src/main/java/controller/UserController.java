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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.LoginDTO;
import dto.UserDTO;
import model.UserType;
import net.bytebuddy.utility.RandomString;
import model.User;
import service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService service;
	private User currentUser = new User();
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserDTO userDTO) throws MessagingException, UnsupportedEncodingException
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
			return new ResponseEntity<>("Username already taken.",HttpStatus.BAD_REQUEST);
		}
		if(service.register(user) == "emailError")
		{
			return new ResponseEntity<>("Email already taken.",HttpStatus.BAD_REQUEST);
		}
		if(service.register(user) == "idError")
		{
			return new ResponseEntity<>("Personal ID already exists.",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("Succesfully registered", HttpStatus.OK);
	}
	

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
		if(service.login(loginDTO.getCredentials(), loginDTO.getPassword()) == "username") {
			currentUser = service.getByUsername(loginDTO.getCredentials());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		if(service.login(loginDTO.getCredentials(), loginDTO.getPassword()) == "email") {
			currentUser = service.getByEmail(loginDTO.getCredentials());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid username or password",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/guestLogin")
	public void GuestLogin()
	{
		currentUser = null;
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
