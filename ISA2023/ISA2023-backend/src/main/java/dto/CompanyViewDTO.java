package dto;

public class CompanyViewDTO {

		private Long id;
		private String name;
		private String address;
		private String openingTime;
		private String closingTime;
		
		public CompanyViewDTO() {
			super();
		}

		public CompanyViewDTO(Long id, String name, String address, String openingTime, String closingTime) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.openingTime = openingTime;
			this.closingTime = closingTime;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getOpeningTime() {
			return openingTime;
		}

		public void setOpeningTime(String openingTime) {
			this.openingTime = openingTime;
		}

		public String getClosingTime() {
			return closingTime;
		}

		public void setClosingTime(String closingTime) {
			this.closingTime = closingTime;
		}
		
		
		
		
		
}
