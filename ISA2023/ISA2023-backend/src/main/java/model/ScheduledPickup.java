package model;


import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;


public class ScheduledPickup {
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "scheduledTime", nullable = false)
	private LocalDateTime scheduledTime;
	
	@Column(name = "durationMinutes", nullable = false)
	private int durationMinutes;
	
	private Company company;
	private ArrayList<Equipment> equipment;
	private User admin;
	private User user;
	
	public ScheduledPickup() {
		super();
	}

	public ScheduledPickup(Long id, LocalDateTime scheduledTime, int durationMinutes, Company company, ArrayList<Equipment> equipment, User admin,
			User user) {
		super();
		{
			this.setId(id);
		}
		this.scheduledTime = scheduledTime;
		this.durationMinutes = durationMinutes;
		this.company = company;
		this.equipment = equipment;
		this.admin = admin;
		this.user = user;
	}

	public LocalDateTime getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(LocalDateTime scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	

}