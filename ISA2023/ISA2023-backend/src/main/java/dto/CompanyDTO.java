package dto;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;

import model.Equipment;
import model.ScheduledPickup;
import model.User;

public class CompanyDTO {


	private String name;
	private String address;
	private LocalTime openingHours;
	private LocalTime closingHours;
	ArrayList<Equipment> availableEquimpent;
	//ArrayList<ScheduledPickup> availablePickups;
	ArrayList<User> admins;
	
	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Long id, String name, String address, LocalTime openingHours, LocalTime closingHours, ArrayList<Equipment> availableEquimpent,
			 ArrayList<User> admins) {
		super();
		this.name = name;
		this.address = address;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		this.availableEquimpent = availableEquimpent;
		//this.availablePickups = availablePickups;
		this.admins = admins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Equipment> getAvailableEquimpent() {
		return availableEquimpent;
	}

	public void setAvailableEquimpent(ArrayList<Equipment> availableEquimpent) {
		this.availableEquimpent = availableEquimpent;
	}

/*	public ArrayList<ScheduledPickup> getAvailablePickups() {
		return availablePickups;
	}

	public void setAvailablePickups(ArrayList<ScheduledPickup> availablePickups) {
		this.availablePickups = availablePickups;
	}*/

	public ArrayList<User> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<User> admins) {
		this.admins = admins;
	}

	public LocalTime getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(LocalTime openingHours) {
		this.openingHours = openingHours;
	}

	public LocalTime getClosingHours() {
		return closingHours;
	}

	public void setClosingHours(LocalTime closingHours) {
		this.closingHours = closingHours;
	}
}
