package model;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.Company;

public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "openingHours", nullable = false)
	private LocalTime openingHours;
	
	@Column(name = "closingHours", nullable = false)
	private LocalTime closingHours;
	
	ArrayList<String> availableEquimpent;
//	ArrayList<ScheduledPickup> availablePickups;
	ArrayList<User> admins;
	
	public Company() {
		super();
	}

	public Company(Long id, String name, String address, LocalTime openingHours, LocalTime closingHours, ArrayList<String> availableEquimpent,
			 ArrayList<User> admins) {
		super();
		if(id != null)
		{
			this.setId(id);
		}
		this.name = name;
		this.address = address;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		this.availableEquimpent = availableEquimpent;
		//this.availablePickups = availablePickups;
		this.admins = admins;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ArrayList<String> getAvailableEquimpent() {
		return availableEquimpent;
	}

	public void setAvailableEquimpent(ArrayList<String> availableEquimpent) {
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
