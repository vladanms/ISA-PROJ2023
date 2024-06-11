package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import model.Company;
import model.ScheduledPickup;
import model.User;
import repository.CompanyRepository;

public class CompanyService {

	@Autowired
	private CompanyRepository companies;
	
	public ArrayList<Company> getAll()
	{
		return (ArrayList<Company>) companies.findAll();
	}
	
	public Company getByName(String name)
	{
        return companies.findByName(name);
    }
	
	public ArrayList<String> getEquipment(Company company)
	{
		return company.getAvailableEquimpent();
	};
}
