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
	private String company;
	private String equipment;
	private String admin;
	private String user;
	
	public ScheduledPickupDTO() {
		super();
	}

	public ScheduledPickupDTO(LocalDate scheduledDate, LocalTime scheduledTimeStart, LocalTime scheduledTimeEnd,
			String company, String equipment, String admin, String user) {
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


}
