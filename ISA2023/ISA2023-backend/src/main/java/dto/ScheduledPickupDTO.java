package dto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;

import model.Company;
import model.Equipment;
import model.User;

public class ScheduledPickupDTO {

	private LocalDate scheduledDate;
	private LocalTime scheduledTimeStart;
	private LocalTime scheduledTimeEnd;
	private int durationMinutes;
	private Company company;
	private ArrayList<Equipment> equipment;
	private User admin;
	private User user;
	
	public ScheduledPickupDTO() {
		super();
	}

	public ScheduledPickupDTO(LocalDate scheduledDate, LocalTime scheduledTimeStart, LocalTime scheduledTimeEnd,
			 Company company, ArrayList<Equipment> equipment, User admin, User user) {
		super();
		this.scheduledDate = scheduledDate;
		this.scheduledTimeStart = scheduledTimeStart;
		this.scheduledTimeEnd = scheduledTimeEnd;
		this.durationMinutes = ((int) Duration.between(scheduledTimeStart, scheduledTimeEnd).toMinutes());
		this.company = company;
		this.equipment = equipment;
		this.admin = admin;
		this.user = user;
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


}
