package dto;

public class ScheduledPickupViewDTO {

	private String id;
	private String equipment;
	private String date;
	private String startTime;
	private String endTime;
	private String company;
	private String admin;
	private String user;
	
	
	
	public ScheduledPickupViewDTO() {
		super();
	}



	public ScheduledPickupViewDTO(String id, String equipment, String date, String startTime, String endTime, String company, String admin,
			String user) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.company = company;
		this.admin = admin;
		this.user = user;
	}

	

	public String getEquipment() {
		return equipment;
	}



	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
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
