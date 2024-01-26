package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;

import model.Company;
import model.Equipment;
import model.User;

public class ScheduledPickupDTO {

	private LocalDateTime scheduledTime;
	private int durationMinutes;
	private Company company;
	private ArrayList<Equipment> equipment;
	private User admin;
	private User user;
	
	public ScheduledPickupDTO() {
		super();
	}

	public ScheduledPickupDTO(Long id, LocalDateTime scheduledTime, int durationMinutes, Company company, ArrayList<Equipment> equipment, User admin,
			User user) {
		super();
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
}
