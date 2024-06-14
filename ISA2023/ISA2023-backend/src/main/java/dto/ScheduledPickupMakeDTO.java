package dto;

public class ScheduledPickupMakeDTO {

	private String id;
	private String username;
	
	public ScheduledPickupMakeDTO(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public ScheduledPickupMakeDTO() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
