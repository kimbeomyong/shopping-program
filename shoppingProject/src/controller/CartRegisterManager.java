package controller;

import java.util.Scanner;

public class CartRegisterManager {
	// 장바구니 리스트
	public void bill() throws Exception {
		Scanner scan = new Scanner(System.in);
		GuestDAO guest = new GuestDAO();
		CartDAO cart = new CartDAO();
		String id = null;
		String pw = null;

		System.out.println("어떤회원의 영수증을 출력할까요>>");
		int g_no = scan.nextInt();
		scan.nextLine();

		cart.cartBill(g_no);

	}

	// 아이템 추가하기
	public void addItem() throws Exception {
		Scanner scan = new Scanner(System.in);
		CartDAO cart = new CartDAO();
		ItemRegisterManager item = new ItemRegisterManager();
		GuestDAO guest = new GuestDAO();
		guest.getGuestTotalList();// 고객번호출력
		System.out.println("구매할 회원의 회원번호를 입력해주세요.>>");
		int g_no = scan.nextInt();
		scan.nextLine();
		item.itemSelect();// 아이템 추력
		System.out.println("장바구니에 추가할 아이템번호를 입력해주세요.>>");
		int i_no = scan.nextInt();
		scan.nextLine();
		cart.addItemToCart(i_no, g_no);
	}

	// 아이템 삭제하기
	public void removeItem() throws Exception {
		Scanner scan = new Scanner(System.in);
		CartDAO cart = new CartDAO();
		cart.getCartTotalList();
		System.out.println("장바구니에 삭제할 아이템번호를 입력해주세요.");
		int choice = scan.nextInt();
		cart.removeItemFromCart(choice);

	}
}
