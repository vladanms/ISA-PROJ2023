package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ScheduledPickupDTO;
import model.ScheduledPickup;
import model.User;
import service.ScheduledPickupService;
import service.UserService;

@RestController
@RequestMapping(value = "scheduledPickup")
public class ScheduledPickupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ScheduledPickupService scheduledPickupService;
	
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
	
	@PutMapping("/cancel")
	public ResponseEntity<ScheduledPickup> cancelPickup(@RequestBody ScheduledPickupDTO scheduledPickupDTO)
	{
		ScheduledPickup pickup = new ScheduledPickup();
		
		pickup.setAdmin(scheduledPickupDTO.getAdmin());
		pickup.setCompany(scheduledPickupDTO.getCompany());
		pickup.setDurationMinutes(scheduledPickupDTO.getDurationMinutes());
		pickup.setEquipment(scheduledPickupDTO.getEquipment());
		pickup.setScheduledDate(scheduledPickupDTO.getScheduledDate());
		pickup.setScheduledTimeStart(scheduledPickupDTO.getScheduledTimeStart());
		pickup.setScheduledTimeEnd(scheduledPickupDTO.getScheduledTimeEnd());
		
		switch(scheduledPickupService.cancel(currentUser, pickup))
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

}
