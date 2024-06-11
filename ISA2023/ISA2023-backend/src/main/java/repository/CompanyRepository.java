package repository;

import model.Company;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	Company findByName(String name);
}
