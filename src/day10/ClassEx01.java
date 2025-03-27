package day10;

import java.util.Scanner;

public class ClassEx01 {

	public static void main(String[] args) {
		/* Product 클래스 생성 : 상품을 등록하는 클래스
		 * 상품명, 가격
		 * 상품명과 가격을 출력하는 메서드
		 * 상품을 추가하는 메서드
		 * */
		
		/* main 클래스에서 처리
		 * 상품 10개를 등록가능한 배열 생성
		 * 스케너를 통해서 상품을 등록받기
		 * 등록한 상품을 출력
		 * */
		
		Scanner scan = new Scanner(System.in);
		//Product 클래스를 10개 담을 배열 생성
		Product[] menu = new Product[10];
		
		// 상품등록(y/n) => n을 선택하면 그만 (출력)
		char c = 'y'; // 반복키워드
		int cnt=0; // index 역할
		
		while(c != 'n') {
			System.out.println("상품등록(y/n) > ");
			c = scan.next().charAt(0);
			if(c=='y') {
				System.out.println("상품명>");
				String name = scan.next();
				System.out.println("가격>");
				int price = scan.nextInt();
				
				//객체 생성
				Product p = new Product();
				p.insertProduct(name, price);
				menu[cnt] = p;
				cnt++;
				
			}else {
				if(c=='n') {
					//출력
					System.out.println("상품등록 종료");
				}else {
					System.out.println("y/n만 가능합니다.");
				}
			}
		}
		
		//출력
		System.out.println("--등록된 상품 리스트--");
		for(int i=0; i<cnt; i++) {
			//toString 사용 경우
			System.out.println((i+1)+" "+menu[i]);
			
			//출력 메서드가 있는 경우
			//menu[i].print();
		}
		scan.close();
	}

}


