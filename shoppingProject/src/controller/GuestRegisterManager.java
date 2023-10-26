package controller;

import java.util.Scanner;

import model.GuestVO;

public class GuestRegisterManager {

	// 고객 등록 관리
	public void guestRegistr() throws Exception {
		Scanner scan = new Scanner(System.in);
		GuestDAO gdao = new GuestDAO();
		GuestVO gvo = new GuestVO();

		String id;// id
		String pw;// pw
		String g_name;// 이름
		String phone_no;// 전화번호
		String adress;// 주소
		boolean idCheck = false;// 아이디 중복 방지

		System.out.println("-------------회원가입-------------");
		System.out.println("이름 : ");
		g_name = scan.nextLine();

		do {
			System.out.println("사용할 id 입력>>");
			id = scan.nextLine();
			idCheck = gdao.getGuestIdOverlap(id);
			if (idCheck) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
			}
		} while (idCheck);

		System.out.println("사용할 pw 입력>>");
		pw = scan.nextLine();
		System.out.println("전화번호 :");
		phone_no = scan.nextLine();
		System.out.println("주소:");
		adress = scan.nextLine();

		gvo.setG_name(g_name);
		gvo.setId(id);
		gvo.setPw(pw);
		gvo.setPhone_no(phone_no);
		gvo.setAdress(adress);

		gdao.setGuestRegiste(gvo);

		System.out.println("-----------가입한 회원정보----------");
		gdao.getGuest(gvo.getId(), gvo.getPw());
		System.out.println("-------------------------------");
	}

	// 고객 수정관리
	public void guestUpdate() throws Exception {
		Scanner scan = new Scanner(System.in);
		GuestDAO gdao = new GuestDAO();
		GuestVO gvo = new GuestVO();

		int no;
		String pw;
		String phone_no;
		String adress;

		System.out.println("수정할 일련번호 입력>>");
		no = scan.nextInt();
		System.out.println("수정할 비밀번호 입력>>");
		pw = scan.nextLine();
		System.out.println("수정할 전화번호 입력>>");
		phone_no = scan.nextLine();
		System.out.println("수정할 주소 입력>>");
		adress = scan.nextLine();

		gvo.setNo(no);
		gvo.setPw(pw);
		gvo.setPhone_no(phone_no);
		gvo.setAdress(adress);

		gdao.setGuestUpdate(gvo);

		System.out.println("----------고객 전체 목록-----------");
		gdao.getGuest(gvo.getId(),gvo.getPw());
		System.out.println("-------------------------------");
	}

	// 고객정보 삭제 관리
	// 학생 정보 수정
	public void studnetUpdate() throws Exception {
		Scanner scan = new Scanner(System.in);
		GuestDAO gdao =new GuestDAO();
		GuestVO gvo =new GuestVO();
		
		String id; // 아이디
		String pw; // 입력 비밀번호
		String g_no; // 학번
		String pw_update;//수정비밀번호
		String phone_no; // 수정 전화번호
		String address; // 수정 주소
		
		boolean success = false;
		
		System.out.println("학생 정보 수정");
		do {
			System.out.print("아이디 : ");
			id = scan.nextLine();
			System.out.print("비밀번호 : ");
			pw = scan.nextLine();
			success = gdao.getGuestLogin(id, pw);
			
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
			}
			
		} while (!success);
		g_no = gdao.getGuestNo(id, pw);
		System.out.println();
		System.out.println("수정할 회원");
		System.out.println("학생번호 : " + g_no);
		System.out.print("비밀번호(12자 이내) : ");
		pw_update = scan.nextLine();
		System.out.print("전화번호 : ");
		phone_no = scan.nextLine();
		System.out.print("주소 : ");
		address = scan.nextLine();
		
		
		gvo.setPw(pw_update);
		gvo.setPhone_no(phone_no);
		gvo.setAdress(address);
		gdao.setGuestUpdate(gvo);
		
		System.out.println();
		System.out.println("학생 정보 수정 결과");
		gdao.getGuest(id, gvo.getPw());
		System.out.println("-------------------------------");
	}

}
