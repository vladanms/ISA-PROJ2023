package repository;

import model.Complaint;
import model.Company;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{
	
ArrayList<Complaint> findByCompany(String company);	
ArrayList<Complaint> findByWriter(String writer);
ArrayList<Complaint> findByAdmin(String admin);
	
}
