package repository;

import model.Complaint;
import model.Company;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{
	
Optional<Complaint> findById(Long id);
ArrayList<Complaint> findByCompany(String company);	
ArrayList<Complaint> findByWriter(String writer);
ArrayList<Complaint> findByAdmin(String admin);
	
}
