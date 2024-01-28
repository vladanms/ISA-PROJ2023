package model;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "gender", nullable = false)
	private Gender gender;
	
	@Column(name = "personalId", unique = true, nullable = false)
	private String personalId;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "rewardPoints", nullable = false)
	private int penaltyPoints;
	
	@Column(name = "penaltyPoints", nullable = false)
	private int rewardPoints;
	
	@Column(name = "userType", nullable = false)
	private UserType type;
	
	@Column(name = "userCategory", nullable = false)
	private UserCategory category;
	
	@Column(name = "verification", nullable = false)
	private String verification;
	
	
	
	
	public User() {
		super();
	}
	public User(Long id, String username, String password, String email, String name, String surname, Gender gender,
			String personalId, String phone, String address, String city, String country, int rewardPoints, int penaltyPoints, UserType type,
			UserCategory category, String verification) {
		super();
		if(id != null)
		{
			this.setId(id);
		}
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
		this.verification = verification;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getVerification() {
		return verification;
	}
	public void setVerification(String verification) {
		this.verification = verification;
	}
	
	
	
	
}
