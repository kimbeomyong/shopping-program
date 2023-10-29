package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ItemVO;

public class ItemDAO {

	// 아이템 목록
	public void getItemTotalList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemVO ivo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from Item order by no");
			rs = pstmt.executeQuery();

			System.out.println("일련번호\t제품번호\t제품이름\t제품가격");

			while (rs.next()) {
				ivo = new ItemVO();
				ivo.setNo(rs.getInt("no"));
				ivo.setI_no(rs.getInt("i_no"));
				ivo.setI_name(rs.getString("i_name"));
				ivo.setPrice(rs.getInt("price"));

				System.out.println(ivo.getNo() + "\t" + ivo.getI_no() + "\t" + ivo.getI_name() + "\t" + ivo.getPrice());

			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	// 아이템 등록
	public void setItemRegiste(ItemVO ivo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into item values(item_no.nextval,item_i_no.nextval,?,?)");
			pstmt.setString(1, ivo.getI_name());
			pstmt.setInt(2, ivo.getPrice());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("등록 성공!!");
			} else {
				System.out.println("등록 실패ㅠㅠ");
			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
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

	//아이템 정보 수정
	public void setItemUpdate(ItemVO ivo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update item set i_name =?, price =? where no=?");
			pstmt.setString(1, ivo.getI_name());
			pstmt.setInt(2, ivo.getPrice());
			pstmt.setInt(3, ivo.getNo());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("수정 성공!!");
			} else {
				System.out.println("수정 실패ㅠㅠ");
			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
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

	// 아이템 삭제
	public void setItemDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from item where no = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			int i = pstmt.executeUpdate();
			
			if (i == 1) {
				System.out.println("삭제 성공!!");
			} else {
				System.out.println("삭제 실패ㅠㅠ");
			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
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
