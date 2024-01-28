package dto;

import javax.persistence.Column;
import javax.persistence.Id;

import model.Gender;
import model.UserCategory;
import model.UserType;

public class UserDTO {

	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private Gender gender;
	private String personalId;
	private String phone;
	private String address;
	private String city;
	private String country;
	private int penaltyPoints;
	private int rewardPoints;
	private UserType type;
	private UserCategory category;
	
	
	
	
	public UserDTO() {
		super();
	}
	public UserDTO(String username, String password, String email, String name, String surname, Gender gender,
			String personalId, String phone, String address, String city, String country, int rewardPoints, int penaltyPoints, UserType type,
			UserCategory category) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.personalId = personalId;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.rewardPoints = rewardPoints;
		this.penaltyPoints = penaltyPoints;
		this.type = type;
		this.category = category;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public UserCategory getCategory() {
		return category;
	}
	public void setCategory(UserCategory category) {
		this.category = category;
	}
	public int getPenaltyPoints() {
		return penaltyPoints;
	}
	public void setPenaltyPoints(int penaltyPoints) {
		this.penaltyPoints = penaltyPoints;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
}
