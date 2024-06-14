package controller;

import java.util.ArrayList;
import java.util.Optional;

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

import dto.ScheduledPickupDTO;
import dto.ScheduledPickupMakeDTO;
import dto.ScheduledPickupViewDTO;
import model.Company;
import model.ScheduledPickup;
import model.User;
import service.CompanyService;
import service.ScheduledPickupService;
import service.UserService;

@RestController
@RequestMapping(value = "scheduledPickup")
public class ScheduledPickupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ScheduledPickupService scheduledPickupService;
	
	@Autowired
	private CompanyService companyService;
	
	private User currentUser;
	
	
	@PutMapping("/schedule")
	public ResponseEntity<ScheduledPickup> schedulePickup(@RequestBody ScheduledPickupDTO scheduledPickupDTO)
	{
			ScheduledPickup pickup = new ScheduledPickup();
			
			pickup.setAdmin(scheduledPickupDTO.getAdmin());
			pickup.setCompany(scheduledPickupDTO.getCompany());
			pickup.setDurationMinutes(scheduledPickupDTO.getDurationMinutes());
			pickup.setEquipment(scheduledPickupDTO.getEquipment());
			pickup.setScheduledDate(scheduledPickupDTO.getScheduledDate());
			pickup.setScheduledTimeStart(scheduledPickupDTO.getScheduledTimeStart());
			pickup.setScheduledTimeEnd(scheduledPickupDTO.getScheduledTimeEnd());
			
			if(scheduledPickupService.schedule(currentUser, pickup))
			{
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping("/schedulePredefined") 
	public ResponseEntity<ScheduledPickup> schedulePredefined(@RequestBody ScheduledPickupMakeDTO scheduledPickupMakeDTO)
	{
		Optional<ScheduledPickup> scheduledPickup = scheduledPickupService.getById(Long.parseLong(scheduledPickupMakeDTO.getId()));
		
		//scheduledPickup.orElseThrow().setUser(userService.getByUsername(scheduledPickupViewDTO.getUser()));
		
		if(scheduledPickupService.schedule(userService.getByUsername(scheduledPickupMakeDTO.getUsername()), scheduledPickup.orElseThrow()))
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/cancel")
	public ResponseEntity<ScheduledPickup> cancelPickup(@RequestBody ScheduledPickupMakeDTO scheduledPickupMakeDTO)
	{		
		ScheduledPickup scheduledPickup = scheduledPickupService.getById(Long.parseLong(scheduledPickupMakeDTO.getId())).orElseThrow();

		/*pickup.setAdmin(scheduledPickupDTO.getAdmin());
		pickup.setCompany(scheduledPickupDTO.getCompany());
		pickup.setDurationMinutes(scheduledPickupDTO.getDurationMinutes());
		pickup.setEquipment(scheduledPickupDTO.getEquipment());
		pickup.setScheduledDate(scheduledPickupDTO.getScheduledDate());
		pickup.setScheduledTimeStart(scheduledPickupDTO.getScheduledTimeStart());
		pickup.setScheduledTimeEnd(scheduledPickupDTO.getScheduledTimeEnd());*/
		
		switch(scheduledPickupService.cancel(userService.getByUsername(scheduledPickupMakeDTO.getUsername()), 
				scheduledPickup))
		{	
		case 0:
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		case 1:
			userService.penalize(currentUser, 1);
		case 2:
			userService.penalize(currentUser, 2);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping("/getFreeByCompany")
	public @ResponseBody ArrayList<ScheduledPickupViewDTO> getFreeByCompany(@Param("companyName") String companyName)
	{
		ArrayList<ScheduledPickupViewDTO> res = new ArrayList<ScheduledPickupViewDTO>();
		Company company = companyService.getByName(companyName);
		
		for(ScheduledPickup sp : scheduledPickupService.getByCompany(company))
		{
			if(sp.getUser() == null)
			{
				res.add(new ScheduledPickupViewDTO(
						sp.getId().toString(),
						sp.getEquipment(),
						sp.getScheduledDate().toString(),
						sp.getScheduledTimeStart().toString(),
						sp.getScheduledTimeEnd().toString(),
						sp.getCompany().getName(),
						sp.getAdmin().getUsername(),
						""
						)
				);
			}
		}		
		return res;
	}
	
	@GetMapping("/getFreeByCompanyEquipment")
	public @ResponseBody ArrayList<ScheduledPickupViewDTO> getFreeByCompanyEquipment(@Param("companyName") String companyName, @Param("equipment") String equipment)
	{
		ArrayList<ScheduledPickupViewDTO> res = new ArrayList<ScheduledPickupViewDTO>();
		Company company = companyService.getByName(companyName);
		
		for(ScheduledPickup sp : scheduledPickupService.getByCompany(company))
		{
			if(sp.getEquipment() == equipment || equipment == "null")
			{
				res.add(new ScheduledPickupViewDTO(
						sp.getId().toString(),
						sp.getEquipment(),
						sp.getScheduledDate().toString(),
						sp.getScheduledTimeStart().toString(),
						sp.getScheduledTimeEnd().toString(),
						sp.getCompany().getName(),
						sp.getAdmin().getUsername(),
						""
						)
				);
			}
		}		
		return res;
	}
	
	@GetMapping("/getByUser")
	public @ResponseBody ArrayList<ScheduledPickupViewDTO> getByUser(@Param("name") String name)
	{
		ArrayList<ScheduledPickupViewDTO> res = new ArrayList<ScheduledPickupViewDTO>();
		User user = userService.getByUsername(name);
		
		for(ScheduledPickup sp : scheduledPickupService.getByUser(user))
		{
			if(sp.getUser() == null)
			{
				res.add(new ScheduledPickupViewDTO(
						sp.getId().toString(),
						sp.getEquipment(),
						sp.getScheduledDate().toString(),
						sp.getScheduledTimeStart().toString(),
						sp.getScheduledTimeEnd().toString(),
						sp.getCompany().getName(),
						sp.getAdmin().getUsername(),
						sp.getUser().getUsername()
						)
				);
			}
		}		
		return res;
	}
}
