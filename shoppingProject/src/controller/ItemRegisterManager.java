package controller;

import java.util.Scanner;

import model.ItemVO;

public class ItemRegisterManager {
	// 아이템 삭제
	public void itemDelete() throws Exception {
		Scanner scan = new Scanner(System.in);
		ItemDAO item = new ItemDAO();
	
		System.out.print("관리자 비밀번호 : ");
		String pw = scan.nextLine();
		
		if(pw.equals("admin1234")) {
			System.out.println("삭제할 아이템 일련번호를 입력해주세요>>");
			int no = scan. nextInt();
			
			item.setItemDelete(no);
		}else {
			System.out.println("관리자 비밀번호가 틀렸습니다.");
		}
		
	}
	//아이템 목록 보기
	public void itemSelect() throws Exception{
		ItemDAO item = new ItemDAO();
			item.getItemTotalList();
		
	}
	//아이템 목록 수정
	public void itemUpdate() throws Exception{
		Scanner scan = new Scanner(System.in);
		ItemVO ivo = new ItemVO();
		ItemDAO item = new ItemDAO();
		
		System.out.print("관리자 비밀번호 : ");
		String pw = scan.nextLine();
		
		if(pw.equals("admin1234")) {
			System.out.println("수정할 아이템의 일련번호를 입력해주세요>>");
			int no = scan.nextInt();
			scan.nextLine();		
			System.out.println("수정할 아이템의 이름을 입력해주세요>>");
			String i_name = scan.nextLine();
			System.out.println("아이템의 가격을 입력해주세요>>");
			int price = scan.nextInt();
			scan.nextLine();
			
			ivo.setI_name(i_name);
			ivo.setPrice(price);
			ivo.setNo(no);
			
			item.setItemUpdate(ivo);
		}else {
			System.out.println("관리자 비밀번호가 틀렸습니다.");
		}
	}
	//아이템 목록 추가
	public void itemInsert() throws Exception{
		Scanner scan = new Scanner(System.in);
		ItemVO ivo = new ItemVO();
		ItemDAO item = new ItemDAO();
		
		System.out.print("관리자 비밀번호 : ");
		String pw = scan.nextLine();
		
		if(pw.equals("admin1234")) {
			System.out.println("추가할 아이템의 이름을 입력해주세요>>");
			String i_name = scan.nextLine();
			System.out.println("아이템의 가격을 입력해주세요>>");
			int price = scan.nextInt();
			scan.nextLine();
			
			ivo.setI_name(i_name);
			ivo.setPrice(price);
			
			item.setItemRegiste(ivo);
		}else {
			System.out.println("관리자 비밀번호가 틀렸습니다.");
		}
	}
}
