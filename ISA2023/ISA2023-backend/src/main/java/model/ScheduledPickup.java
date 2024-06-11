package model;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;


public class ScheduledPickup {
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "scheduledDate", nullable = false)
	private LocalDate scheduledDate;
	
	@Column(name = "scheduledTimeStart", nullable = false)
	private LocalTime scheduledTimeStart;
	
	@Column(name = "scheduledTimeEnd", nullable = false)
	private LocalTime scheduledTimeEnd;
	
	@Column(name = "durationMinutes", nullable = false)
	private int durationMinutes;
	
	private Company company;
	private String equipment;
	private User admin;
	private User user;
	
	public ScheduledPickup() {
		super();
	}

	public ScheduledPickup(Long id, LocalDate scheduledDate, LocalTime scheduledTimeStart, LocalTime scheduledTimeEnd,
			 Company company, String equipment, User admin, User user) {
		super();
		this.id = id;
		this.scheduledDate = scheduledDate;
		this.scheduledTimeStart = scheduledTimeStart;
		this.scheduledTimeEnd = scheduledTimeEnd;
		this.durationMinutes = ((int) Duration.between(scheduledTimeStart, scheduledTimeEnd).toMinutes());
		this.company = company;
		this.equipment = equipment;
		this.admin = admin;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public LocalTime getScheduledTimeStart() {
		return scheduledTimeStart;
	}

	public void setScheduledTimeStart(LocalTime scheduledTimeStart) {
		this.scheduledTimeStart = scheduledTimeStart;
	}

	public LocalTime getScheduledTimeEnd() {
		return scheduledTimeEnd;
	}

	public void setScheduledTimeEnd(LocalTime scheduledTimeEnd) {
		this.scheduledTimeEnd = scheduledTimeEnd;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
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
	
	
	

	
	
	
	

}
