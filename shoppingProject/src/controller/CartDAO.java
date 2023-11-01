package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CartDAO {
	//고객의 영수증 정보를 출력해야된다.
	public void cartBill(int g_no) throws Exception {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int totalPrice = 0;

	    try {
	        con = DBUtil.getConnection();
	        pstmt = con.prepareStatement("SELECT a.I_NAME, a.PRICE, b.G_NAME, c.ORDER_DATE " +
	                "FROM item a, guest b, cart c " +
	                "WHERE c.I_NO = a.I_NO AND c.G_NO = b.G_NO and c.G_NO = ?");
	        pstmt.setInt(1, g_no);
	        rs = pstmt.executeQuery();

	        System.out.println("*******************************");
	        while (rs.next()) {
	            String itemName = rs.getString("I_NAME");
	            int itemPrice = rs.getInt("PRICE");
	            String guestName = rs.getString("G_NAME");
	            String orderDate = rs.getString("ORDER_DATE");

	            // 각 상품의 세부 내용 표시
	            System.out.println("상품명: " + itemName);
	            System.out.println("상품 가격: " + itemPrice + "원");
	            System.out.println("고객 이름: " + guestName);
	            System.out.println("주문 일자: " + orderDate);
	            System.out.println("*******************************");

	            // 총 가격 계산
	            totalPrice += itemPrice;
	        }

	        // 최종 총 가격 표시
	        System.out.println("총 가격: " + totalPrice + "원");

	    } catch (SQLException se) {
	        System.out.println("SQL 오류[" + se + "]");
	    } catch (Exception e) {
	        System.out.println("자바 오류[" + e + "]");
	    } finally {
	        try {
	            if (pstmt != null)
	                pstmt.close();
	            if (con != null)
	                con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	// 아이템 추가
	public void addItemToCart(int i_no, int g_no) throws Exception {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBUtil.getConnection();
	        pstmt = con.prepareStatement("INSERT INTO cart(no, i_no, g_no) VALUES (cart_no.nextval, ?, ?)");
	        pstmt.setInt(1, i_no);
	        pstmt.setInt(2, g_no);
	        int rs = pstmt.executeUpdate();
	        if (rs > 0) {
	            System.out.println("아이템을 장바구니에 추가했습니다.");
	        } else {
	            System.out.println("아이템을 추가하지 못했습니다.");
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	}
	// 아이템 삭제
	public void removeItemFromCart(int i_no) throws Exception {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBUtil.getConnection();
	        pstmt = con.prepareStatement("DELETE FROM cart WHERE i_no = ?");
	        pstmt.setInt(1, i_no);
	        int rs = pstmt.executeUpdate();
	        if (rs > 0) {
	            System.out.println("장바구니의 아이템을 삭제했습니다.");
	        } else {
	            System.out.println("장바구니에 해당 상품이 없습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	}
	//장바구니 품목
	public void getCartTotalList() throws Exception {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DBUtil.getConnection();
	        String query = "SELECT c.i_no, i.i_name FROM cart c, item i WHERE c.i_no = i.i_no";
	        pstmt = con.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        System.out.println("장바구니에 있는 품목:");
	        while (rs.next()) {
	            int itemNo = rs.getInt("i_no");
	            String itemName = rs.getString("i_name");
	            System.out.println("아이템 번호: " + itemNo + ", 아이템 이름: " + itemName);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	}


}