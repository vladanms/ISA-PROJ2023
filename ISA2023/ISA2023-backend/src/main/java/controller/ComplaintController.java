package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

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
import dto.ComplaintViewDTO;
import dto.ReplyDTO;
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
    public ResponseEntity<Complaint> replyComplaint(@RequestBody ReplyDTO replyDTO)
    {
    /*    if(complaintService.writeComplaint(complaintDTO.getWriter(), complaintDTO.getCompany(), 
        		complaintDTO.getAdmin(), complaintDTO.getContent(), complaintDTO.getResponse())){
			return new ResponseEntity<>(HttpStatus.OK);
		}*/
    	Complaint c = complaintService.FindById(Long.parseLong(replyDTO.getId()));
    	try {
			complaintService.writeReply(c, replyDTO.getResponse(), userService.getByUsername(c.getWriter()).getEmail());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/getById")
    public @ResponseBody ComplaintViewDTO getById(@Param("id") Long id)
    {
    	Complaint c = complaintService.FindById(id);
    	
    	return (new ComplaintViewDTO(
    					c.getId().toString(),
    					c.getContent(),
    					c.getResponse(),
    					c.getCompany(),
    					c.getWriter(),
    					c.getAdmin(),
    					c.getTime().toString()
    				)
    			);

    }
    
    @GetMapping("/getByWriter")
    public @ResponseBody ArrayList<ComplaintViewDTO> getByWriter(@Param("writer") String writer)
    {
    	ArrayList<ComplaintViewDTO> res = new ArrayList<ComplaintViewDTO>();
    	
    	for( Complaint c: complaintService.FindByWriter(writer))
    	{
    		res.add(new ComplaintViewDTO(
    					c.getId().toString(),
    					c.getContent(),
    					c.getResponse(),
    					c.getCompany(),
    					c.getWriter(),
    					c.getAdmin(),
    					c.getTime().toString()
    				)
    			);
    	}
    	return res;
    }
    
    @GetMapping("/getByAdmin")
    public @ResponseBody ArrayList<ComplaintViewDTO> getByAdmin(@Param("admin") String admin)
    {
    ArrayList<ComplaintViewDTO> res = new ArrayList<ComplaintViewDTO>();
    	
    	for( Complaint c: complaintService.FindByAdmin(admin))
    	{
    		res.add(new ComplaintViewDTO(
    					c.getId().toString(),
    					c.getContent(),
    					c.getResponse(),
    					c.getCompany(),
    					c.getWriter(),
    					c.getAdmin(),
    					c.getTime().toString()
    				)
    			);
    	}
    	return res;
    }
    
    @GetMapping("/getByCompany")
    public @ResponseBody ArrayList<ComplaintViewDTO> getByCompany(@Param("company") String company)
    {
        ArrayList<ComplaintViewDTO> res = new ArrayList<ComplaintViewDTO>();
    	
    	for( Complaint c: complaintService.FindByCompany(company))
    	{
    		res.add(new ComplaintViewDTO(
    					c.getId().toString(),
    					c.getContent(),
    					c.getResponse(),
    					c.getCompany(),
    					c.getWriter(),
    					c.getAdmin(),
    					c.getTime().toString()
    				)
    			);
    	}
    	return res;
    }
    
    @GetMapping("/getByCompanyAdmin")
    public @ResponseBody ArrayList<ComplaintViewDTO> getByCompany(@Param("company") String company, @Param("admin") String admin)
    {
        ArrayList<ComplaintViewDTO> res = new ArrayList<ComplaintViewDTO>();
    	
    	for( Complaint c: complaintService.FindByCompany(company))
    	{
    		if(c.getAdmin() == admin) {
    		res.add(new ComplaintViewDTO(
    					c.getId().toString(),
    					c.getContent(),
    					c.getResponse(),
    					c.getCompany(),
    					c.getWriter(),
    					c.getAdmin(),
    					c.getTime().toString()
    				)
    			);
    		}
    	}
    	return res;
    }
    
    }
