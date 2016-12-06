package kr.jhta.fruitshop;

import java.util.Scanner;

public class FruitShopApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FruitShop shop = new FruitShop();

		while (true) {
			System.out.println("<<               과일가게                  >>");
			System.out.println("<<  1.회원가입  2.로그인   3.과일정보조회  >>");
			System.out.println("<<  4.과일구매  5.구매목록조회 6.배송신청  >>");
			System.out.println("<<  7.배송신청조회         0.종료          >>");
			System.out.print("--> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				shop.register();
			} else if (menu == 2) {
				shop.login();
			} else if (menu == 3) {
				shop.fruitInfo();
			} else if (menu == 4) {
				shop.buyFruit();
			} else if (menu == 5) {
				shop.buyList();
			} else if (menu == 6) {
				shop.delivery();
			} else if (menu == 7) {
				shop.deliveryList();
			} else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
