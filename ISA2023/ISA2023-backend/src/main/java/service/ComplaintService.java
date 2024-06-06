package service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import model.User;
import model.Company;
import model.Complaint;
import repository.ComplaintRepository;
import repository.UserRepository;

public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;
	@Autowired
	private JavaMailSender sender;
	
	public boolean writeComplaint(String writer, String company, String admin, String content, String response)
	{
		Complaint complaint = new Complaint(null, writer, company, admin, content, "");
		complaintRepository.save(complaint);
		return true;
	}
	
	public boolean writeReply(Complaint complaint, String response, String email) throws UnsupportedEncodingException, MessagingException
	{
		complaint.setResponse(response);
		emailReply(email, complaint);
		complaintRepository.save(complaint);
		return true;
	}
	
	public ArrayList<Complaint> FindByCompany(String company)
	{
	    ArrayList<Complaint> complaints = new ArrayList<Complaint>();
	    for (Complaint complaint: complaintRepository.findByCompany(company)) {
	        complaints.add(complaint);
	       }
	       return complaints;
	}
	
	public ArrayList<Complaint> FindByAdmin(String admin)
	{
	    ArrayList<Complaint> complaints = new ArrayList<Complaint>();
	    for (Complaint complaint: complaintRepository.findByAdmin(admin)) {
	        complaints.add(complaint);
	       }
	       return complaints;
	}
	
	public ArrayList<Complaint> FindByWriter(String writer)
	{
	    ArrayList<Complaint> complaints = new ArrayList<Complaint>();
	    for (Complaint complaint: complaintRepository.findByWriter(writer)) {
	        complaints.add(complaint);
	       }
	       return complaints;
	}
	
	
	

	public void emailReply(String email, Complaint complaint) throws UnsupportedEncodingException, MessagingException
	{
		MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    helper.setFrom("complaints.com", "ISA project");
	    helper.setTo(email);
	    helper.setSubject("Reply to the complaint");
	    
	    String admin = "";
	    if(complaint.getAdmin() == null)
	    {
	    	admin = "administrator " + complaint.getAdmin() + ", in";
	    }
	    		
	    helper.setText("Response to your complaint made about" + admin + " company" + complaint.getCompany() + "<br><br>"
	    		+ complaint.getContent()
	    		);
	    sender.send(message);
	}
	
}
