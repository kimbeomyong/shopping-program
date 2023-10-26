package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.GuestVO;

public class GuestDAO {
	// 고객 등록
	public void setGuestRegiste(GuestVO gvo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into guest values(guest_no.nextval,?,?,guest_g_no.nextval,?,?,?)");
			pstmt.setString(1, gvo.getId());
			pstmt.setString(2, gvo.getPw());
			pstmt.setString(3, gvo.getG_name());
			pstmt.setString(4, gvo.getPhone_no());
			pstmt.setString(5, gvo.getAdress());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("등록 성공!!");
			} else {
				System.out.println("등록 실패ㅠㅠ");
			}
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

	// 고객 정보 수정
	public void setGuestUpdate(GuestVO gvo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update guest set pw=?, phone_no=?, address=? where g_no=?");
			pstmt.setString(1, gvo.getPw());
			pstmt.setString(2, gvo.getPhone_no());
			pstmt.setString(3, gvo.getAdress());
			pstmt.setInt(4, gvo.getG_no());
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

	// 동일 회원 학생 일련번호
	public String getGuestCount(String guestNum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String serialNumber = "";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select LPAD(count(*)+1, 4,'0') Count from guest where g_no = ?");// 중복을 방지
			pstmt.setString(1, guestNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				serialNumber = rs.getString("GuestCount");
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
		return serialNumber;
	}

	// 아이디 중복 체크
	public boolean getGuestIdOverlap(String idOverlap) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean idOverlapResult = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from guest where id = ?");
			pstmt.setString(1, idOverlap);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				idOverlapResult = true; // 중복된 아이디가 있다.
			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return idOverlapResult;
	}

	// 고객 로그인
	public boolean getGuestLogin(String id, String pw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginSuccess = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from guest where id = ? and pw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginSuccess = true; // 로그인 성공
			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return loginSuccess;
	}

	// 고객 번호
	public String getGuestNo(String id, String pw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String g_no = "";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select g_no from guest where id = ? and pw= ?");

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				g_no = rs.getString("g_no");
			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return g_no;
	}

	// 고객 정보
	public void getGuest(String id, String pw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestVO gvo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from guest where id = ? and pw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			System.out.println("일련번호\t아이디\t비밀번호\t고객번호\t고객이름\t전화번호\t주소");

			if (rs.next()) {
				gvo = new GuestVO();
				gvo.setNo(rs.getInt("no"));
				gvo.setId(rs.getString("id"));
				gvo.setPw(rs.getString("pw"));
				gvo.setG_no(rs.getInt("g_no"));
				gvo.setG_name(rs.getString("g_name"));
				gvo.setPhone_no(rs.getString("phone_no"));
				gvo.setAdress(rs.getString("adress"));

				
				System.out.println(gvo.getNo()+"\t"+gvo.getId()+"\t"+gvo.getPw()+"\t"+gvo.getG_no()+"\t"+gvo.getG_name()+"\t"+gvo.getPhone_no()+"\t"+gvo.getAdress());

			}
		} catch (SQLException e) {
			System.out.println("SQL=[" + e + "]");
		} catch (Exception e) {
			System.out.println("JAVA=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 고객 전체 목록
	public void getStudentTotalList() throws Exception {
		String sql = "select * from guest";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestVO gvo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("일련번호\t아이디\t비밀번호\t고객번호\t고객이름\t전화번호\t주소");
			while (rs.next()) {
				gvo = new GuestVO();
				gvo.setNo(rs.getInt("no"));
				gvo.setId(rs.getString("id"));
				gvo.setPw(rs.getString("pw"));
				gvo.setG_no(rs.getInt("g_no"));
				gvo.setG_name(rs.getString("g_name"));
				gvo.setPhone_no(rs.getString("phone_no"));
				gvo.setAdress(rs.getString("adress"));

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
}
