package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.CartVO;
import model.ItemVO;

public class CartDVO {
	public void cartBill(CartVO cart) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalPrice = 0;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"SELECT a.NO AS 아이템일련번호, a.I_NO AS 아이템번호, a.I_NAME AS 아이템이름, a.PRICE AS 아이템가격, b.NO AS 고객일련번호, b.G_NO AS 고객번호, b.G_NAME AS 고객이름, b.PHONE_NO AS 전화번호, b.ADRESS AS 주소, c.NO AS 카트일련번호, c.ORDER_DATE AS 주문날짜, c.TOTAL_PRICE AS 총가격 FROM item a, guest b, cart c WHERE c.i_no = a.i_no AND c.g_no = b.g_no");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int itemSerialNo = rs.getInt("아이템일련번호");
				String itemName = rs.getString("아이템이름");
				int itemPrice = rs.getInt("아이템가격");

				int guestNo = rs.getInt("고객번호");
				String guestName = rs.getString("고객이름");
				String phoneNo = rs.getString("전화번호");
				String address = rs.getString("주소");

				String orderDate = rs.getString("주문날짜");

				// 각 항목에 대한 정보 출력
				System.out.println("************************************");
				System.out.println("아이템일련번호: " + itemSerialNo);
				System.out.println("아이템이름: " + itemName);
				System.out.println("아이템가격: " + itemPrice);
				System.out.println("고객번호: " + guestNo);
				System.out.println("고객이름: " + guestName);
				System.out.println("전화번호: " + phoneNo);
				System.out.println("주소: " + address);
				System.out.println("주문날짜: " + orderDate);
				System.out.println("*************************************");

				// 총가격 계산
				totalPrice += itemPrice;
			}

			// 최종 총가격 출력
			System.out.println("총가격: " + totalPrice + "원");

		} catch (SQLException se) {
			System.out.println("SQL[" + se + "]");
		} catch (Exception e) {
			System.out.println("JAVA[" + e + "]");
		} finally {
			try {
				// 데이터베이스 연결 오브젝트 해제
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

	public void getCartTotalList() throws Exception {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DBUtil.getConnection();
	        String query = "SELECT i_no FROM cart";
	        pstmt = con.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        System.out.println("장바구니에 있는 품목:");
	        while (rs.next()) {
	            System.out.println("아이템 번호: " + rs.getInt("i_no"));
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