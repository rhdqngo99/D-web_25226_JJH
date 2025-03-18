package sale;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleController {
	
	//- 메뉴 리스트, - 주문 리스트 
	private ArrayList<Menu> menuList = new ArrayList<>();
	private ArrayList<Order> orderList = new ArrayList<>();
	private int menuNo=6;
	//기본메뉴 구성
	public void addMenu() {
		menuList.add(new Menu(1, "짜장면", 1500));
		menuList.add(new Menu(2, "짬뽕", 2000));
		menuList.add(new Menu(3, "탕수육", 5000));
		menuList.add(new Menu(4, "음료수", 500));
		menuList.add(new Menu(5, "쟁반짜장", 4000));
		menuList.add(new Menu(6, "유산슬", 5000));
	}

	public void add(Scanner scan) {
		// 메뉴추가 
		menuNo++;
		System.out.println("메뉴이름 >");
		String name = scan.next();
		System.out.println("메뉴가격 >");
		int price = scan.nextInt();
		
		menuList.add(new Menu(menuNo, name, price));
		System.out.println("-메뉴추가 완료-");
	}
	
	//메뉴 번호를 주면 menuList에서 검색하여 index를 리턴하는 메서드
	// index가 -1이 리턴되면 찾는 값이 없다는 것을 의미
	public int menuSearch(int menuNo) {
		int index = -1; 
		for(int i=0; i<menuList.size(); i++) {
			if(menuList.get(i).getMenuNo() == menuNo) {
				index = i;
			}
		}
		return index;
	}
	

	public void delete(Scanner scan) {
		// 메뉴삭제 remove(index)
		// list 에서 값을 가져올 때 get(index)
		System.out.println("삭제할 메뉴 번호 >");
		int no = scan.nextInt();
//		for(int i=0; i<menuList.size();i++) {
//			if(menuList.get(i).getMenuNo() == no) {
//				//remove(index)
//				menuList.remove(i);
//				// remove(object)
//				// menuList.remove(menuList.get(i));
//				System.out.println("-메뉴삭제 완료-");
//				return;
//			}
//		}
		int index = menuSearch(no);
		if(index == -1) {
			System.out.println("해당 메뉴가 없습니다.");
			return;
		}
		menuList.remove(index);
		
	}

	public void update(Scanner scan) {
		// 메뉴수정 => 메뉴 no 받아서 가격만 수정
		System.out.println("수정할 번호 >");
		int no = scan.nextInt();
		
//		for(int i=0; i<menuList.size(); i++) {
//			if(menuList.get(i).getMenuNo() == no) {
//				
//				// 수정할 객체 출력
//				System.out.println(menuList.get(i));
//				
//				System.out.println("수정할 가격 >");
//				int price = scan.nextInt();
//				
//				Menu m = new Menu(no, menuList.get(i).getMenuName(), price);
//				menuList.set(i, m);
//				System.out.println("-메뉴수정완료-");
//				return;
//			}
//		}
		
		int index = menuSearch(no);
		if(index == -1) {
			System.out.println("찾는 메뉴가 없습니다.");
			return;
		}
		// 수정할 객체 출력
		System.out.println(menuList.get(index));
		System.out.println("수정할 가격 >");
		int price = scan.nextInt();
		
		// 수정할 객체 생성
		Menu m = new Menu(no, menuList.get(index).getMenuName(), price);
		menuList.set(index, m);
		System.out.println("-메뉴수정완료-");
	}

	public void menuPrint() {
		// 메뉴 출력
		System.out.println("----menu----");
		for(Menu m : menuList) {
			System.out.println(m); //toString으로 출력
		}
		System.out.println("-------------");
		
	}

	public void orderPick(Scanner scan) {
		// 주문 : 메뉴번호와, 수량을 입력받아 orderList 객체에 추가
		// order 객체의 주문이름/가격은 menu에서 찾아와서 추가
		menuPrint(); // 메뉴 출력먼저 해주고 선택할 수 있게 ...
		System.out.println("메뉴번호 >");
		int no = scan.nextInt();
		System.out.println("수량 > ");
		int count = scan.nextInt();
		
		// 메뉴번호로 이름과 가격을 검색
//		for(int i=0; i<menuList.size(); i++) {
//			if(menuList.get(i).getMenuNo() == no) {
//				String name = menuList.get(i).getMenuName();
//				int price = menuList.get(i).getPrice();
//				
//				Order order = new Order(no, name, price, count);
//				orderList.add(order);
//				System.out.println("-주문추가 완료-");
//				return;
//			}
//		}
		
		int index = menuSearch(no);
		if(index == -1) {
			System.out.println("메뉴가 없습니다.");	
			return;
		}
		String name = menuList.get(index).getMenuName();
		int price = menuList.get(index).getPrice();
		
		Order order = new Order(no, name, price, count);
		orderList.add(order);
		System.out.println("-주문추가 완료-");
		
		
	}

	public void orderPrint() {
		// 영수증
		int sum=0;
		System.out.println("--주문내역--");
		for(int i=0; i<orderList.size(); i++) {
			sum += orderList.get(i).getTotal();
			orderList.get(i).printOrder();
		}
		System.out.println("------------------");
		System.out.println("총결제금액 : "+sum);
		
	}

	public ArrayList<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Menu> menuList) {
		this.menuList = menuList;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	
}