package dto;

public class ComplaintViewDTO {

	private Long id;
	private String content;
	private String response;
	private String company;
	private String writer;
	private String admin;
	private String time;
	
	
	public ComplaintViewDTO() {
		super();
	}
	public ComplaintViewDTO(Long id, String content, String response, String company, String writer, String admin,
			String time) {
		super();
		this.id = id;
		this.content = content;
		this.response = response;
		this.company = company;
		this.writer = writer;
		this.admin = admin;
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
