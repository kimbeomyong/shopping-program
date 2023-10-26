package model;

public class CartVO {
	int no;// 일련번호
	int i_no;// 제품번호
	String order_date;// 주문한 날짜
	int g_no;// 고객번호
	int total_price;// 총값
	
	//생성자
	public CartVO(int no, int i_no, String order_date, int g_no, int total_price) {
		super();
		this.no = no;
		this.i_no = i_no;
		this.order_date = order_date;
		this.g_no = g_no;
		this.total_price = total_price;
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
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	
}
