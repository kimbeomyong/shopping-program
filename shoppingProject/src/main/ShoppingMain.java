package main;

import controller.GuestRegisterManager;
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
			}
			} catch (Exception e) {
			System.out.println("\n입력에 오류가 있습니다.\n프로그램을다시 시작하세요.");
			return;
			}
			}
		
	}

	private static void cartMenu() {
		int choice;
		GuestRegisterManager guest = new GuestRegisterManager();
	}

	private static void itemMenu() {
		
	}

	private static void guestMenu() {
		
	}

}
