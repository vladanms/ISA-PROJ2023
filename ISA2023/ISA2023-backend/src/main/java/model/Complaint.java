package model;

import java.time.LocalDateTime;

public class Complaint {

	private Long id;
	private String content;
	private String response;
	private Company company;
	private User writer;
	private User admin;
	private LocalDateTime time;
	
	public Complaint() {
		super();
	}

	public Complaint(Long id, String content, Company company, User writer, User admin) {
		super();
		if(id != null)
		{
			this.setId(id);
		}
		this.content = content;
		this.response = "";
		this.company = company;
		this.writer = writer;
		this.admin = admin;
		this.time = LocalDateTime.now();
		}

	
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
