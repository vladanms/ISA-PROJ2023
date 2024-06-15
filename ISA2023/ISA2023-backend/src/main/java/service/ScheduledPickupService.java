package service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import model.Company;
import model.ScheduledPickup;
import model.User;
import repository.ScheduledPickupRepository;

public class ScheduledPickupService {

	@Autowired
	private ScheduledPickupRepository scheduledPickups;	
	@Autowired
	private JavaMailSender sender;
	
	public boolean schedule(User user, ScheduledPickup scheduledPickup)
	{
		if(scheduledPickup.getUser() != null)
		{
			return false;
		}
			
		scheduledPickup.setUser(user);
		scheduledPickups.save(scheduledPickup);
		return true;
	}
	
	public boolean addAdmin(ScheduledPickup scheduledPickup, Company company, ArrayList<User> admins)
	{
		boolean free = true;
		for(User a : admins)
		{
			for(ScheduledPickup sp: scheduledPickups.findByCompany(company))
			{
				if(sp.getAdmin() == a && sp.getScheduledTimeEnd().isAfter(scheduledPickup.getScheduledTimeStart()))
				{
					free = false;
				}
			}
			if(free)
			{
				scheduledPickup.setAdmin(a);
				return true;
			}
		}
		return false;
	}
	
	public boolean freeExpired(ScheduledPickup scheduledPickup)
	{
		if(scheduledPickup.getAdmin() != null)
		{
			if(scheduledPickup.getScheduledTimeEnd().isBefore(LocalTime.now()))
			{
				scheduledPickup.setAdmin(null);
				return true;
			}
		}
		return false;
	}
	
	public int cancel(User user, ScheduledPickup scheduledPickup)
	{
		int penalty = 0;
		User currentUser = user;
		scheduledPickup.setUser(null);
		
		if((int) Duration.between(scheduledPickup.getScheduledTimeStart(), scheduledPickup.getScheduledTimeEnd()).toHours() <= 24)
		{
			penalty+=1;
		}
		penalty+=1;
		
		scheduledPickups.save(scheduledPickup);
		return penalty;
	}
	
	public ArrayList<ScheduledPickup> getByUser(User user)
	{
        return scheduledPickups.findByUser(user);
    }
	
	public Optional<ScheduledPickup> getById(Long id)
	{
        return scheduledPickups.findById(id);
    }
	
	public ArrayList<ScheduledPickup> getByCompany(Company company)
	{
        return scheduledPickups.findByCompany(company);
    }
}
