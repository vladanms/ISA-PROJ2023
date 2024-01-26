package model;

public class Complaint {

	private Long id;
	private String content;
	private Company company;
	private User writer;
	
	public Complaint() {
		super();
	}

	public Complaint(Long id, String content, Company company, User writer) {
		super();
		if(id != null)
		{
			this.setId(id);
		}
		this.content = content;
		this.company = company;
		this.writer = writer;
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
