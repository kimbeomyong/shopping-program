package main;

import java.util.Scanner;

import controller.GuestRegisterManager;
import model.AdminVO;
import view.MenuViewer;

public class ShoppingMain {
	public static void main(String[] args) {
		mainManu();
	}

	public static void mainManu() {
		int choice;
		while (true) {
			try {
				MenuViewer.main();
				choice = MenuViewer.scan.nextInt();
				MenuViewer.scan.nextLine();
				switch (choice) {
				case 1:
					guestMenu();
					break;
				case 2:
					itemMenu();
					break;
				case 3:
					cartMenu();
					break;
				case 4:
					System.out.println("프로그램을 종료합니다.");
					return;
				default : System.out.println("1,2,3,4 중 하나를 선택해주세요.");	
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				return;
			}
		}

	}

	private static void cartMenu() {
	
	}
	
	private static void itemMenu() {
		AdminVO admin = new AdminVO();

	}

	private static void guestMenu() {
		int choice;
		GuestRegisterManager guest = new GuestRegisterManager();
		
		while (true) {
			try {
				MenuViewer.guest();
				choice = MenuViewer.scan.nextInt();
				MenuViewer.scan.nextLine();
				switch (choice) {
				case 1:
					guest.guestRegistr();
					break;
				case 2:
					guest.guestUpdate();
					break;
				case 3:
					
					break;
				case 4: 
					
					break;
				case 5:
					System.out.println("메인으로 돌아갑니다.");
					return;
				default : System.out.println("1,2,3,4 중 하나를 선택해주세요.");	
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				return;
			}
		}
	}
	
}
