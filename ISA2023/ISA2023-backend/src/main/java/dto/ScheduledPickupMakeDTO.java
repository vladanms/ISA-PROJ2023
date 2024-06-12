package dto;

public class ScheduledPickupMakeDTO {

	private Long id;
	private String username;
	
	public ScheduledPickupMakeDTO(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public ScheduledPickupMakeDTO() {
		super();
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
	
	
	
	
}
