package product;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	/* controller <-> service <-> DAO <-> DB
	 * DBConnect(싱글톤) -> DAO
	 * 생성자에서 모든 메뉴의 분기 처리
	 * */
	private Scanner scan;
	private ProductServiceInterface psv;
	private boolean flag; // 종료변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		psv = new ProductService();
		flag = true; // 실행상태
		printMenu();
	}
	
	private void printMenu() {
		// 메뉴 생성
		while (flag) {
			System.out.println("--상품관리프로그램--");
			System.out.println("1.상품등록|2.상품리스트|3.상품상세");
			System.out.println("4.상품수정|5.상품삭제|6.종료");
			System.out.println("메뉴선택>");
			
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: register(); break;
			case 2: list(); break;
			case 3: detail(); break;
			case 4: modify(); break;
			case 5: remove(); break;
			case 6: flag=false; break;
			default :
				System.out.println("잘못된 메뉴"); break;
			}
		}
	}
	
	private void remove() {
		// TODO Auto-generated method stub
		System.out.println("상품번호>");
		int pno = scan.nextInt();
		
		int isOk = psv.remove(pno);
		System.out.println("상품삭제>"+((isOk > 0)? "성공" : "실패"));
		
		
	}
	
	private void modify() {
		// 수정할 상품번호를 받아서 수정 내용을 받아 수정
		System.out.println("상품번호>");
		int pno = scan.nextInt();
		
		// 수정할 값 받기
		System.out.println("상품명:");
		scan.nextLine();
		String pname = scan.nextLine();
		
		System.out.println("가격:");
		int price = scan.nextInt();
		
		System.out.println("상품상세:");
		scan.nextLine();
		String madeby = scan.nextLine();
		
		Product p = new Product(pname, price, madeby, pno);
		
		int isOk = psv.modify(p);
		System.out.println("상품수정>"+((isOk > 0)? "성공" : "실패"));
		
	}

	private void detail() {
		// 상품 하나의 정보만 가져오기
		System.out.println("상품번호>");
		int pno = scan.nextInt();
		Product p = psv.getDetail(pno);
		p.print();
	}

	private void list() {
		// TODO Auto-generated method stub
		List<Product> list= psv.getList();
		for(Product p: list) {
			System.out.println(p);
		}
		
	}

	private void register() {
		// 상품등록
		System.out.println("상품명:");
		scan.nextLine();
		String pname = scan.nextLine();
		
		System.out.println("가격:");
		int price = scan.nextInt();
		
		System.out.println("상품상세:");
		scan.nextLine();
		String madeby = scan.nextLine();
		
		Product p = new Product(pname, price, madeby);
		
		// service에게 등록을 요청하는 메서드 작성
		// insert 메서드를 실행하면 잘등록되면 1(1개의 행이 insert) / 0 또는 error
		int isOk = psv.insert(p);
		
		System.out.println("상품등록>"+((isOk > 0)? "성공" : "실패"));
	}

}
