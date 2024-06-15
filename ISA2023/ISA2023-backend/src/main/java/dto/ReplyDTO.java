package dto;

public class ReplyDTO {

	private String id;
	private String response;	
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(String id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
	
}
