package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;

import model.Company;

public class Company {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	Long id;
	
	@Column(name = "name", nullable = false)
	String name;
	
	@Column(name = "address", nullable = false)
	String address;
	
	ArrayList<Equipment> availableEquimpent;
	ArrayList<ScheduledPickup> availablePickups;
	ArrayList<User> admins;
	
	public Company() {
		super();
	}

	public Company(Long id, String name, String address, ArrayList<Equipment> availableEquimpent,
			ArrayList<ScheduledPickup> availablePickups, ArrayList<User> admins) {
		super();
		if(id != null)
		{
			this.setId(id);
		}
		this.name = name;
		this.address = address;
		this.availableEquimpent = availableEquimpent;
		this.availablePickups = availablePickups;
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

	public ArrayList<Equipment> getAvailableEquimpent() {
		return availableEquimpent;
	}

	public void setAvailableEquimpent(ArrayList<Equipment> availableEquimpent) {
		this.availableEquimpent = availableEquimpent;
	}

	public ArrayList<ScheduledPickup> getAvailablePickups() {
		return availablePickups;
	}

	public void setAvailablePickups(ArrayList<ScheduledPickup> availablePickups) {
		this.availablePickups = availablePickups;
	}

	public ArrayList<User> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<User> admins) {
		this.admins = admins;
	}
	
	
	
	
	
	
	
	
	
	
}
