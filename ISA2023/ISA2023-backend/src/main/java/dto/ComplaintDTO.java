package dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;

public class ComplaintDTO {

	private String content;
	private String response;
	private String company;
	private String writer;
	private String admin;
	private LocalDateTime time;
	
	public ComplaintDTO() {
		super();
	}

	public ComplaintDTO(String content, String company, String writer, String admin) {
		super();
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

	public void setCompany(String companyId) {
		this.company = company;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
