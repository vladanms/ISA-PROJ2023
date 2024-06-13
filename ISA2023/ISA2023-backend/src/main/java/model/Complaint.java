package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "content", unique = false, nullable = true)
	private String content;
	
	@Column(name = "response", unique = false, nullable = true)
	private String response;
	
	@Column(name = "company", unique = false, nullable = true)
	private String company;
	
	@Column(name = "writer", unique = false, nullable = false)
	private String writer;
	
	@Column(name = "admin", unique = false, nullable = true)
	private String admin;
	
	@Column(name = "time", unique = false, nullable = true)
	private LocalDateTime time;
	
	public Complaint() {
		super();
	}

	public Complaint(Long id, String content, String company, String writer, String admin, String response) {
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
		this.response = response;
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
