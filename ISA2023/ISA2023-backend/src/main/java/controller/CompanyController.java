package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.repository.query.Param;

import service.CompanyService;
import dto.CompanyViewDTO;
import model.Company;

@RestController
@RequestMapping(value = "company")
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@GetMapping("/getAll")
	public @ResponseBody ArrayList<CompanyViewDTO> getAll()
	{
		ArrayList<CompanyViewDTO> res = new ArrayList<CompanyViewDTO>();
		
		for(Company c: service.getAll())
		{
			res.add(
					new CompanyViewDTO(
							c.getId().toString(),
							c.getName(),
							c.getAddress(),
							c.getOpeningHours().toString(),
							c.getClosingHours().toString()
					)
					);
		}
		return res;
	}
	
	@GetMapping("/getByName")
	public @ResponseBody ArrayList<CompanyViewDTO> getByName(@Param("name") String name)
	{
		ArrayList<CompanyViewDTO> res = new ArrayList<CompanyViewDTO>();
		
		for(Company c: service.getAll())
		{
			if(c.getName().contains(name) || name == "null" || name == "") {
			res.add(
					new CompanyViewDTO(
							c.getId().toString(),
							c.getName(),
							c.getAddress(),
							c.getOpeningHours().toString(),
							c.getClosingHours().toString()
					)
					);
		}
		}
		return res;		
	}
	
	@GetMapping("/getEquipment")
	public @ResponseBody ArrayList<String> getEquipment(@Param("name") String name)
	{		
		ArrayList<String> res = new ArrayList<String>();
	
		for(Company c: service.getAll())
		{
			if(c.getName() == name) {
				res = c.getAvailableEquimpent();
			}
		}
		return res;		
	}
	
	@GetMapping("/filterEquipment")
	public @ResponseBody ArrayList<String> filterEquipment(@Param("name") String name, @Param("equipment") String equipment)
	{
		ArrayList<String> res = new ArrayList<String>();
		
		for(Company c: service.getAll())
		{
			if(c.getName() == name) {
				for(String eq : c.getAvailableEquimpent())
				{
					if(eq.contains(equipment) || equipment == "" || equipment == null)
					{
						res.add(eq);
					}
				}
		}
		}
		return res;		
	}
}
