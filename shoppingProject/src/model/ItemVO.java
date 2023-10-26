package model;

public class ItemVO {
	int no;// 일련번호
	int i_no;// 제품번호
	String i_name;// 제품이름
	int price;// 가격
	
	//생성자
	public ItemVO(int no, int i_no, String i_name, int price) {
		super();
		this.no = no;
		this.i_no = i_no;
		this.i_name = i_name;
		this.price = price;
	}
	
	public ItemVO() {
		super();
	}

	//getter setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
