package sale;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		/* Kiosk
		 * 메뉴(메뉴명, 가격) / 주문(메뉴명, 가격, 수량, 금액)
		 * 주문 class 는 메뉴 class를 상속받아 확장.
		 * 
		 * -- menu--
		 * 1.메뉴추가 | 2.메뉴삭제 | 3.메뉴수정(가격수정)
		 * 4.메뉴보기(전체메뉴출력)|5.주문 |6.주문내역출력(영수증)
		 * 7.종료
		 * */
		
		/* 오늘 내용 git에 올리기
		 * .git 이 있는 폴더에서 우클릭 => git Bash 
		 * git add .
		 * git commit -m "메시지"
		 * git push origin main
		 * */
		
		// 컨트롤러 객체 생성
		SaleController sc = new SaleController();
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		sc.addMenu();
		
		do {
			System.out.println("--menu--");
			System.out.println("1.메뉴추가 | 2.메뉴삭제 | 3.메뉴수정(가격수정)");
			System.out.println("4.메뉴보기(전체메뉴출력) | 5.주문 | 6.주문내역출력(영수증)");
			System.out.println("7.종료");
			
			System.out.println("선택 > ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: sc.add(scan); break;
			case 2: sc.delete(scan); break;
			case 3: sc.update(scan); break;
			case 4: sc.menuPrint(); break;
			case 5: sc.orderPick(scan); break;
			case 6: sc.orderPrint(); break;
			case 7: System.out.println("종료"); break;
			default: 
				System.out.println("메뉴선택 오류");
			}
				
			
		}while(menu != 7);
		
		scan.close();
		
	}

}


