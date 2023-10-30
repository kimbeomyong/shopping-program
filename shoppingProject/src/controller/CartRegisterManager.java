package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CartRegisterManager {
	//장바구니 리스트
	public void bill() throws Exception {
		CartDVO cart = new CartDVO();
		cart.cartBill(null);
	}
	
	//아이템 추가하기
	public void addItem() throws Exception {
		Scanner scan = new Scanner(System.in);
		CartDVO cart = new CartDVO();
		ItemRegisterManager item = new ItemRegisterManager();
		item.itemSelect();
		System.out.println("구매할 회원번호를 입력해주세요.");
		int g_no = scan.nextInt();
		scan.nextLine();
		System.out.println("장바구니에 추가할 아이템번호를 입력해주세요.");
		int i_no = scan.nextInt();
		scan.nextLine();
		cart.addItemToCart(i_no,g_no);
	}
	
	//아이템 삭제하기
	public void removeItem() throws Exception {
		Scanner scan = new Scanner(System.in);
		CartDVO cart = new CartDVO();
		cart.getCartTotalList();
		System.out.println("장바구니에 삭제할 아이템번호를 입력해주세요.");
		int choice = scan.nextInt();
		cart.removeItemFromCart(choice);
		
	}
}
