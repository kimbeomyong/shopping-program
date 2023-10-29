package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.CartVO;
import model.GuestVO;

public class CartDVO {
	public void cartList(CartVO cart) throws Exception {
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement("select a.NO item_no,\r\n"
				+ "a.I_NO I_NO,\r\n"
				+ "a.I_NAME I_NAME,\r\n"
				+ "a.PRICE PRICE,\r\n"
				+ "b.NO guest_no,\r\n"
				+ "b.ID ID,\r\n"
				+ "b.PW PW,\r\n"
				+ "b.G_NO G_NO,\r\n"
				+ "b.G_NAME G_NAME,\r\n"
				+ "b.PHONE_NO PHONE_NO,\r\n"
				+ "b.ADRESS ADRESS,\r\n"
				+ "c.NO cart_no,\r\n"
				+ "c.ORDER_DATE ORDER_DATE,\r\n"
				+ "c.TOTAL_PRICE TOTAL_PRICE from item a,guest b,cart c where c.i_no = a.i_no and c.g_no = b.g_no");
	} catch (SQLException se) {
		System.out.println("SQL[" + se + "]");
	} catch (Exception e) {
		System.out.println("JAVA[" + e + "]");
	} finally {
		try {
			// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}
}
}