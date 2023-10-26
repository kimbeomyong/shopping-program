package model;

public class GuestVO {
	int no;// 일련번호
	String id;// 아이디
	String pw;// 비밀번호
	int g_no;// 고객번호
	String g_name;// 이름
	String phone_no;// 전화번호
	String adress;// 주소
	// 생성자
	public GuestVO() {
		super();
	}
	
	public GuestVO(int no, String id, String pw, int g_no, String g_name, String phone_no, String adress) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.g_no = g_no;
		this.g_name = g_name;
		this.phone_no = phone_no;
		this.adress = adress;
	}
	//getter,setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
}
