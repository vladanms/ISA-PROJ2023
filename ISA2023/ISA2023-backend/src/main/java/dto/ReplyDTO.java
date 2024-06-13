package dto;

public class ReplyDTO {

	private Long id;
	private String response;	
	private String credentials;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(Long id, String response, String credentials) {
		super();
		this.id = id;
		this.response = response;
		this.credentials = credentials;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String email) {
		this.credentials = email;
	}
	
	
	
	
}
