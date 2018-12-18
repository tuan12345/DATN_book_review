package app.dto;

public class PublisherInfo {
	private Integer Id;
	private String name;
	private String address;
	private String phone;
	private int numberBook;
	public int getNumberBook() {
		return numberBook;
	}
	public void setNumberBook(int numberBook) {
		this.numberBook = numberBook;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public PublisherInfo() {
		super();
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public PublisherInfo(Integer id, String name, String address, String phone) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	

}
