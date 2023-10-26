package view;

import java.util.Scanner;

public class MenuViewer {
	public static final Scanner scan = new Scanner(System.in);
	
	public static void main() {
		System.out.println("----------JAVA MARKET----------");
		System.out.println("1. 고객 정보");
		System.out.println("2. 아이템 정보");
		System.out.println("3. 장바구니");
		System.out.println("4. 프로그램 종료");
		System.out.println("-------------------------------");
	}

	public static void guest() {
		System.out.println("------------고객정보-------------");
		System.out.println("1. 고객 정보 등록");
		System.out.println("2. 고객 정보 수정");
		System.out.println("3. 고객 정보 목록");
		System.out.println("4. 고객 정보 제거");
		System.out.println("-------------------------------");
	}

	public static void item() {
		System.out.println("------------아이템정보------------");
		System.out.println("1. 아이템 정보 목록");
		System.out.println("2. 아이템 정보 추가");
		System.out.println("3. 아이템 정보 수정");
		System.out.println("4. 아이템 정보 삭제");
		System.out.println("5. 메인");
		System.out.println("-------------------------------");
	}
	
	public static void cart() {
		System.out.println("------------장바구니-------------");
		System.out.println("1. 장바구니 목록");
		System.out.println("2. 장바구니 아이템 추가");
		System.out.println("3. 장바구니 아이템 삭제");
		System.out.println("4. 메인");
		System.out.println("-------------------------------");
	}
}
