package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.ComplaintDTO;
import model.Complaint;
import model.User;
import service.CompanyService;
import service.ComplaintService;
import service.UserService;

@RestController
@RequestMapping(value = "complaint")
public class ComplaintController {

	private User currentUser = new User();
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
    @PostMapping("/write")
    public ResponseEntity<Complaint> writeComplaint(@RequestBody ComplaintDTO complaintDTO)
    {
        if(complaintService.writeComplaint(complaintDTO.getWriter(), complaintDTO.getCompany(), 
        		complaintDTO.getAdmin(), complaintDTO.getContent(), complaintDTO.getResponse())){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping("/reply")
    public ResponseEntity<Complaint> replyComplaint(@RequestBody ComplaintDTO complaintDTO)
    {
        if(complaintService.writeComplaint(complaintDTO.getWriter(), complaintDTO.getCompany(), 
        		complaintDTO.getAdmin(), complaintDTO.getContent(), complaintDTO.getResponse())){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/getByWriter")
    public @ResponseBody ArrayList<Complaint> getByWriter()
    {
    	return complaintService.FindByWriter(currentUser.getUsername());
    }
    
    @GetMapping("/getByAdmin")
    public @ResponseBody ArrayList<Complaint> getByAdmin(@Param("admin") String admin)
    {
    	return complaintService.FindByWriter(admin);
    }
    
    @GetMapping("/getByCompany")
    public @ResponseBody ArrayList<Complaint> getByCompany(@Param("company") String company)
    {
    	return complaintService.FindByWriter(company);
    }
    
    }
