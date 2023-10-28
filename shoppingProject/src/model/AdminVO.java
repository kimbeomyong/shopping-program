package model;

public class AdminVO {
	private String id = "Admin";
	private String password = "Admin1234";
	
	public AdminVO() {
		super();
	}
	
	public AdminVO(String id,String password) {
		this.id = id;
		this.password = password;
	}
	
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
