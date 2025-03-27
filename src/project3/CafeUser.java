// Controller 역할 클래스  
package project3;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeUser{
	// 멤버 변수 초기화 
		// days 
	int days = 1;
	
		// 휴식 횟수
	int restNum = 0;
	
		// user 의 카페 이름 
	String cafeName;
	
		// user 의 돈 
	int money = 22;
	
		// user 의 피로도 
	int fatigueGauge = 0;
	
	int idx = 4;
	
		// User 가 작성한 Recipe 와 비교할 cafeRecipList 생성 
	ArrayList<CafeRecipe> cafeRecipeList = new ArrayList<>();
		
		// 손님은 현재 카페에서 판매하는 메뉴만 주문할 수 있음 
		// 현재 카페에서 판매하는 메뉴를 넣어놓는 리스트 
	ArrayList<CafeGuest> paymentList = new ArrayList<>(); 

		// 입력 초기화
	Scanner sc = new Scanner(System.in);
	
		// 기본 생성자 
	public CafeUser() {}
	
	
	// toString()
	
	
	// 메서드 
		// 기본으로 제작 가능한 메뉴 리스트 
	public void cafeRecipeList() {
		// cafeRecipeList.get(0) - Ice Americano
		cafeRecipeList.add(new CafeRecipe("아이스 아메리카노",3,"얼음","물","에스프레소"));
		
		// cafeRecipeList.get(1) - Hot Americano
		cafeRecipeList.add(new CafeRecipe("핫 아메리카노",3,"뜨거운물","에스프레소"));
		
		// cafeRecipeList.get(2) - Ice CafeLatte
		cafeRecipeList.add(new CafeRecipe("아이스 카페라떼",4,"얼음","우유","에스프레소"));
		
		// cafeRecipeList.get(3) - Hot CafeLatte
		cafeRecipeList.add(new CafeRecipe("핫 카페라떼",4,"뜨거운우유","에스프레소"));
	}
	
	
		// 가격표 저장 리스트 
	public void guestPaymentList() {
		paymentList.add(new CafeGuest("아이스 아메리카노", 3));
		paymentList.add(new CafeGuest("핫 아메리카노", 3));
		paymentList.add(new CafeGuest("아이스 카페라떼", 4));
		paymentList.add(new CafeGuest("핫 카페라떼", 4));
	}
	
	
		// menuPrint() - 작업 선택 
	public int menuPrint() {
		int n = 0;
	
		System.out.println("---------------수행할 작업을 선택하세요---------------");
		System.out.println();
		System.out.println("\t\t<작업 선택>");
		System.out.println("1) 영업\t\t2) 휴식");
		System.out.println("3) 운세보기\t4) 메뉴 개발\t 5) 종료"); 
		
		if(money >= 30) { System.out.println("6) 집 구매"); }
		
		System.out.print("선택 : ");
		
		n = sc.nextInt();
		
		return n;
	}
	
	
	// homeImage() - 시작 이미지
	public void homeImage(){
		System.out.println("                               \r\n"
				+ "                               \r\n"
				+ "    ##     ##            ##### \r\n"
				+ "   ###   #####   ###       ### \r\n"
				+ "  # ##    ##    ## ##      ##  \r\n"
				+ " ## ##    ##   ##  ##     ##   \r\n"
				+ " #####   ##    ##  ##    ##    \r\n"
				+ "##  ##   ##    ## ##    ###    \r\n"
				+ "##  ##   ###    ###     #####  \r\n"
				+ "                               \r\n"
				+ "        Americano to Zip       \r\n"
				+ "");
		
		System.out.println("");
	}
	
	
		// loading() - 로딩 화면 
	public void loadingImage() throws InterruptedException {
		System.out.println("loading...");
		
		for(int i = 0; i < 4; i++) {
			Thread.sleep(2000);
			System.out.print("☕··☕··☕··");
		}
		
	}
	
	
		// printUserCafeImage() - 가게 이미지 출력  
	public void printUserCafeImage() {
		System.out.println("\r\n"
				+ "⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁⠁\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
				+ "\r\n\t■                           ■"
				+ "\r\n\t■\t " +  cafeName + " 의 Cafe\t    ■"  
				+ "\r\n\t■                           ■"
				+ "\r\n\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢄⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⠀⠀⠀⠀⡀⢳⡙⡒⢜⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢱⢹⢽⢆⢄⢜⢼⠊⠒⠍⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠊⡘⡵⣕⡽⣔⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢔⣕⠯⡷⣝⢦⡣⡓⢦⢠⡀⠀⠀⠀⠀⠀⠀⠀⡀⣠⢤⣳⢱⢸⠨⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢔⢕⡷⡹⡸⡪⣇⠧⡫⡳⣕⢕⢝⢲⢤⢤⢔⣤⣳⡳⣝⣗⢽⡢⣟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢔⢕⡵⡻⣱⢝⢜⢞⢎⣎⢮⣫⡪⡭⡪⣎⢎⢎⠏⡞⡮⣺⢕⣗⡽⣸⢯⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢄⢇⢷⣫⡳⣝⠮⣿⣻⣟⡿⣾⢯⡪⣞⢜⡼⣪⢪⣾⣼⣳⣝⢼⣱⡳⡣⡯⣟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢮⡺⣪⢮⢝⣵⣿⣳⡿⣯⡗⡕⠧⡓⢝⢎⢎⣾⣟⣾⣳⡳⣕⡝⣕⡿⣽⢽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠓⠕⠣⣗⢧⢳⢣⡫⣾⢺⣞⢾⣺⢪⢍⢏⢏⢧⢫⡚⣾⣽⢾⢽⣳⣕⢇⡾⡽⡽⣽⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠓⣽⠪⣺⢼⢮⣳⢽⡼⣵⣮⡾⣮⢾⢮⡾⡮⣖⢗⣿⡾⣮⢿⣽⣳⣗⢕⣯⢯⣻⢎⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢳⠀⡯⣟⣯⡿⣵⣻⢿⡾⣟⣯⣟⢯⣯⣟⢎⡗⣿⣽⡯⣿⣺⣳⢽⡕⣯⡿⣺⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⢀⢢⡢⠀⢀⡀⠀⠀⠀⡇⠀⡝⡮⣟⡧⡣⡳⡽⣺⢽⢜⢎⢮⢺⣺⢕⢍⡿⣞⣯⢗⣯⣞⢷⢝⣷⣻⣻⢎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠒⠑⣝⢬⢳⡹⣢⠠⢨⢪⠠⡪⡯⡮⣺⢸⢕⡯⣗⡽⡪⡇⣏⢯⣪⢣⠣⣟⣟⣾⣻⣞⣾⢽⡧⣷⣳⡽⣇⢄⡄⣄⢄⢄⢄⢄⢄⠄⠀\r\n"
				+ "⠀⠀⠀⠚⠊⠓⢝⢜⠪⡪⡺⡸⢜⠮⡳⠝⢜⢕⢍⢣⢫⢳⣣⢮⢣⡷⣑⢧⢿⡽⣾⢷⡻⡞⡯⡟⡞⡞⠽⡹⢕⢝⢎⢓⠃⠃⠑⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠈⠐⠈⠘⢌⠢⠪⡢⡑⢌⠪⡢⡢⡑⢔⢅⢕⠍⢕⢕⢑⢕⢑⢅⢕⢑⢕⢌⠢⡑⡑⢕⠘⠌⡊⠂⠂⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠐⠈⠀⠑⠐⠨⠈⠂⠂⠂⠅⠑⠌⠂⠅⠑⠀⠁⠑⠀⠁⠁⠈⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		return; 
	}

	
		// userStateBar() - User 의 상태창을 출력
	public void userStateBar() {
		System.out.println("\t\t"+"<" + this.cafeName + " 님의 카페 개업 " + days + "일차>");
		System.out.println("\t\t" +this.cafeName + "의 상태" );
		System.out.println("\t\t" +"돈 : " + money);
		System.out.println("\t\t" +"피로도 : " + fatigueGauge + " / 100");
		System.out.println();
	}
	
	
		// cafeMenuPrint() - 현재 사용자의 판매 가능한 메뉴를 출력 
	public void cafeMenuPrint() {
		System.out.println("------------<메뉴판>------------");
		
		for(CafeGuest cg : paymentList) {
			System.out.println(cg.getMenuName() + " - " + cg.getFare());
		}
		System.out.println();
		
		return;
	}
	
	
		// recipePrint() - 메뉴 제작 방법 출력 
	public void recipePrint() {
		System.out.println("<현재 제작 가능한 레시피>");
		
		for(int i = 0; i < cafeRecipeList.size(); i++) {
			System.out.print(cafeRecipeList.get(i).menuName + " : ");
//			System.out.print(cafeRecipeList.get(i).price + " : ");
			System.out.print(cafeRecipeList.get(i).ingredients + "\n");
		}
		
		return;
	}
	
	
		// guestOrder() - 손님의 주문  
	public void guestOrder() {
		// 멤버 변수 초기화
		boolean bool = false;
		int randNum = (int)(Math.random()*paymentList.size()) + 0;
		CafeRecipe e = new CafeRecipe();
		
		// UI
		System.out.println(paymentList.get(randNum).menuName + " 주문 !");	
		System.out.println();
		
		System.out.println(paymentList.get(randNum).menuName + " 의 레시피를 입력하세요");
		System.out.println("Ex) 재료1,재료2,... 재료 n");
		System.out.println("※ 주의! 레시피의 순서대로 입력해야 합니다 ※");
		

		for(int i = 0; i < cafeRecipeList.get(randNum).ingredients.size(); i++) {
			System.out.print("입력 : ");
			String s = sc.next();
			e.ingredients.add(s);
		}
		
		if(cafeRecipeList.get(randNum).ingredients.equals(e.ingredients)) {
			bool = true;
			money += paymentList.get(randNum).fare;
			System.out.println("제작 성공 !");
		}
		
		else if(!bool) { System.out.println("제작 실패 !"); }
		
		// 피로도 5 증가
		fatigueGauge += 5;
		
		return;
	}
	
	
//	public int takeAnOrder(CafeGuest guset) {
//		// CafeRecip 의 Method 와 비교하여 참이면 CafeGuest 의 fare 를 money 에 저장 
//		
//	}
	
	
		// rest() - 휴식 
	public void rest() throws InterruptedException {
		// 멤버 변수 초기화
		int randNum = (int)(Math.random()*30) + 0;
		int tmpRestNum = 0;
		
		
		++restNum;
		tmpRestNum = restNum;
		if(tmpRestNum % 2 == 0) { 
			days++;  
			fatigueGauge = 0;
		}
		
		System.out.println();
		System.out.println("하루 최대 2번의 휴식이 가능하며");
		System.out.println("하루 2번의 휴식을 취하는 경우 다음 날로 넘어갑니다");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■                                  ■");
		System.out.println("■              "+ this.cafeName + " 의" + "              ■");
		System.out.println("■            " + days + " 일차 Cafe            ■");
		System.out.println("■                                  ■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		Thread.sleep(5000);
		
		System.out.println();
		System.out.println(randNum + "만큼 피로도가 감소합니다");
		
		if(fatigueGauge <= randNum) {
			fatigueGauge = 0; 
			System.out.println("피로도가 완전히 회복되었습니다..!");
		} else if(fatigueGauge > randNum) { fatigueGauge -= randNum; }
	} 
	
		// fortunes() - 운세 보기 
	public void fortunes() throws InterruptedException {
		int randNum = (int)(Math.random()*6) + 1;
		
		switch(randNum) {
			case 1:
				System.out.println("오늘 하루는 내일의 좋은 밑거름이 될 것입니다. 오늘 하루에 최선을 다하세요.");
				System.out.println("꽝 !"); fatigueGauge += 20; Thread.sleep(3000); break;
				
			case 2:
				System.out.println("안좋은 날이 있으면 좋은 날도 있는 법입니다. 실망하지 마세요.");
				System.out.println("꽝 !"); fatigueGauge += 20; Thread.sleep(3000); break;
				
			case 3: 
				System.out.println("기약없는 운보다 오늘 하루를 살아가는 자신을 믿으세요. 좋은 날이 올 거에요.");
				System.out.println("꽝 !"); fatigueGauge += 20; Thread.sleep(3000); break;
				
			case 4:
				System.out.println("오늘 당신 앞에 열리는 문은 새로운 기회를 가져올 것입니다. 즐겁게 한 걸음 내딛어 보세요");
				System.out.println("$10 획득 !"); 
				Thread.sleep(3000); fatigueGauge += 20; money += 10; break;
				
			case 5:
				System.out.println("뜻밖의 행운이 당신을 찾아올 것입니다. 준비된 마음으로 기회를 잡으세요");
				System.out.println("$15 획득 !"); 
				Thread.sleep(3000); fatigueGauge += 20; money += 15; break;
				
			case 6:
				System.out.println("당신의 작은 노력이 곧 큰 성공으로 이어질 것입니다. 포기하지 않는 용기가 필요해요.");
				System.out.println("$20 획득 ! "); 
				Thread.sleep(3000); fatigueGauge += 20; money += 20; break;
		}
	}
	
	
		// developMenu() - 메뉴 개발 선택 출력 메서드 
	public void developMenu() throws InterruptedException {
		char c;
		
		System.out.println("\t\t<신메뉴 레시피>");
		System.out.println("------------- 구매 가격 $30 / 판매 가격 $6 -------------");
		System.out.println("아포가토 : 바닐라 아이스크림, 에스프레소");
		System.out.println("플레인요거트 스무디 : 얼음, 우유, 요거트파우더");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println("------------- 구매 가격 $45 / 판매 가격 $7 -------------");
		System.out.println("고구마 라떼 : 고구마, 우유, 꿀 (Hot 은 스팀 밀크)");
		System.out.println("플레인요거트 스무디 : 우유, 카라멜 시럽, 에스프레소, 얼음 ");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println("------------- 구매 가격 $60 / 판매 가격 $8 -------------");
		System.out.println("딸기요거트 스무디 : 얼음, 우유, 요거트파우더, 냉동딸기, 딸기퓨레");
		System.out.println("바닐라 라떼 : 얼음, 우유, 바닐라 시럽, 에스프레소, 바닐라 베이스 (Hot 은 스팀 밀크)");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println("------------- 구매 가격 75$ / 판매 가격 $9 -------------");
		System.out.println("시나몬 모카 : 초코파우더, 시나몬 가루, 에스프레소, 우유, 얼음");
		System.out.println("플레인요거트 스무디 : 코코넛 파우더, 에스프레소, 우유, 얼음");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println("------------- 구매가격 $90 / 판매 가격 $10 -------------");
		System.out.println("초코 쉐이크 : 얼음, 우유, 초코 시럽, 초코 파우더, 바닐라 아이스크림");
		System.out.println("돌체 라떼 : 연유, 에스프레소, 설탕 시럽, 얼음, 우유");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		
		System.out.println("구매할 레시피의 이름과 판매 가격을 입력하세요");
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("판매 가격 : ");
		int price = sc.nextInt();
		
		
		switch(price) {
			// case 6
			case 6 :
				if(money >= 30) { 
					money -= 30; 
				
					cafeRecipeList.add(new CafeRecipe(name,price));
					paymentList.add(new CafeGuest(name,price));
					
					do{
						System.out.print("입력 : ");
						String s = sc.next();
						
						cafeRecipeList.get(idx).ingredients.add(s);
						
						System.out.println("입력을 계속하시겠습니까? (Y/N) ");
						System.out.print("선택 (Y/N) : ");
						c = Character.toUpperCase(sc.next().charAt(0));
					}while(c != 'N'); 
				}
				
				else if(money < 30) { 
					System.out.println("구매가 불가능합니다 !"); 
					Thread.sleep(1000); return; 
				} 
				idx++; break;
				
				
			// case 7	
			case 7 :
				if(money >= 45) { 
					money -= 45; 
				
					cafeRecipeList.add(new CafeRecipe(name,price));
					paymentList.add(new CafeGuest(name,price));
					
					do{
						System.out.print("입력 : ");
						String s = sc.next();
						
						cafeRecipeList.get(idx).ingredients.add(s);
						
						System.out.println("입력을 계속하시겠습니까? (Y/N) ");
						System.out.print("선택 (Y/N) : ");
						c = Character.toUpperCase(sc.next().charAt(0));
					}while(c != 'N'); 
				}
				
				else if(money < 45) { 
					System.out.println("구매가 불가능합니다 !"); 
					Thread.sleep(1000); return; 
				} 
				idx++; break;
			
				
			// case 8
			case 8 :
				if(money >= 60) { 
					money -= 60; 
				
					cafeRecipeList.add(new CafeRecipe(name,price));
					paymentList.add(new CafeGuest(name,price));
					
					do{
						System.out.print("입력 : ");
						String s = sc.next();
						
						cafeRecipeList.get(idx).ingredients.add(s);
						
						System.out.println("입력을 계속하시겠습니까? (Y/N) ");
						System.out.print("선택 (Y/N) : ");
						c = Character.toUpperCase(sc.next().charAt(0));
					}while(c != 'N'); 
				}
				
				else if(money < 60) { 
					System.out.println("구매가 불가능합니다 !"); 
					Thread.sleep(1000); return; 
				} 
				
				idx++; break;
				
				
			// case 9	
			case 9 : 
				if(money >= 75) { 
					money -= 75; 
				
					cafeRecipeList.add(new CafeRecipe(name,price));
					paymentList.add(new CafeGuest(name,price));
					
					do{
						System.out.print("입력 : ");
						String s = sc.next();
						
						cafeRecipeList.get(idx).ingredients.add(s);
						
						System.out.println("입력을 계속하시겠습니까? (Y/N) ");
						System.out.print("선택 (Y/N) : ");
						c = Character.toUpperCase(sc.next().charAt(0));
					}while(c != 'N'); 
				}
				
				else if(money < 75) { 
					System.out.println("구매가 불가능합니다 !"); 
					Thread.sleep(1000); return; 
				} 
				idx++; break;
				
				
			case 10 :
				if(money >= 90) { 
					money -= 90; 
				
					cafeRecipeList.add(new CafeRecipe(name,price));
					paymentList.add(new CafeGuest(name,price));
					
					do{
						System.out.print("입력 : ");
						String s = sc.next();
						
						cafeRecipeList.get(idx).ingredients.add(s);
						
						System.out.println("입력을 계속하시겠습니까? (Y/N) ");
						System.out.print("선택 (Y/N) : ");
						c = Character.toUpperCase(sc.next().charAt(0));
					}while(c != 'N');
				}
				
				else if(money < 90) { 
					System.out.println("구매가 불가능합니다 !"); 
					Thread.sleep(1000); return; 
				} 
				idx++; break;
				
			default : System.out.println("잘못된 입력으로 인해 종료됩니다..!"); return;
		}
	}
	
		// ending() - 집 구매 하면서 게임 끝 
	public void ending() throws InterruptedException {
		money = 0;
		
		System.out.println("\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀내집 마련 성공 ..!⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀게임 끝 !⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢤⣂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢴⣫⢟⡾⡽⣤⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢠⢮⢯⡻⣮⣻⣺⢽⣺⣳⢵⣀⠀⠀⠀⠀⠀⠀⠀⠀⡠⣲⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣔⡮⡯⡯⣯⣻⣺⣺⡺⣽⣺⡺⡽⣮⣳⢄⡀⠀⠀⠀⣄⡮⡯⣗⣯⣻⡲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⣀⣖⣽⣺⣺⢽⢽⣺⣺⡺⣮⣻⡺⡮⣯⣻⣺⡺⣽⣺⢤⣢⢯⣗⢯⢯⣗⣗⣗⢯⣗⢷⢤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢀⡠⣞⣞⣞⣞⣞⢾⢽⢽⡺⣮⣻⡺⡮⡯⣻⣺⡺⡮⣻⡺⣮⣻⣺⡳⡽⣝⣗⣗⢷⢝⡷⡽⡽⡽⣽⣢⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠓⠙⢱⣗⣗⢷⢽⢽⣝⣗⡯⣗⢷⢽⢽⣝⣗⢷⢽⣝⣗⣟⣞⣞⡮⡯⡯⣗⢷⢽⢽⢽⣺⢽⢽⢽⡺⡮⠋⠃⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⡺⡮⡯⡯⡗⠳⠳⢹⣳⠏⠯⠳⢳⢽⠝⠳⠓⢗⣗⣗⢷⢽⢽⢽⢽⢽⢽⣝⢷⢽⢽⣝⣗⡯⡯⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⢽⢽⢽⢽⠅⠀⠀⢸⡺⡅⠀⠀⢸⢯⡂⠀⠀⢕⡷⡽⡽⡽⡽⡽⡽⡽⣵⣫⢯⢯⣳⣳⣳⢽⢽⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⢽⢽⢽⣝⢧⢴⢤⢮⢯⢦⢴⣰⢼⣫⡦⡴⣤⢵⢯⢯⢯⢾⢝⠙⠙⠙⣞⡮⠋⠋⠚⣞⡮⡯⣗⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⢽⣝⢷⢽⢽⢽⢽⢽⢽⠝⠽⠺⢝⡮⣯⣻⡺⡽⡽⡽⡽⣝⢧⠀⠀⠨⣺⢽⠀⠀⠀⣗⡽⣝⣗⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⣳⢽⢽⢽⢽⢽⢽⢽⢽⠀⠀⠀⢐⡯⣗⣗⡯⡯⡯⣯⣻⣺⣳⣲⣲⢼⣺⢽⣲⡲⡦⣗⡯⣗⣗⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⣺⢽⢽⢽⢽⢽⢽⢽⢽⠀⠀⠀⢐⡯⣗⣗⡯⣯⣻⣺⣺⣺⡺⣺⢮⡻⣮⣻⣺⡺⣝⡷⣝⣗⣗⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠠⣤⢤⣤⢼⣺⢽⢽⢽⢽⢝⡽⡽⡽⡤⣤⢤⢴⣫⣗⣗⣟⣞⣞⣞⣞⣞⢾⣝⣗⢯⣗⣗⣗⢯⣗⢯⣗⣗⢷⢤⣢⣔⡄⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠠⠫⠻⠪⠻⠺⠹⠝⠝⠽⠹⠝⠽⠹⠝⠞⠽⠝⠞⠞⠞⠺⠚⠞⠺⠚⠮⠳⠳⠝⠗⠗⠳⠝⠗⠝⠗⠗⠽⠹⠝⠞⠮⠣⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		
		System.out.println();
		Thread.sleep(3000);
		
		return;
	}

	
	// Getter(), Setter() 
		// String cafeName
	public String getCafeName() {
		return cafeName;
	}

		// 초기 설정 한 번 
	public void setCafeName() {
		System.out.println("사용자의 이름을 입력하세요 (3글자)");
		System.out.print("이름 : ");
		
		cafeName = sc.next();
		
//		if(cafeName.length() > 3) { 
//			System.out.println("다시 입력하세요");
//			
//		}
//		
//		else if(cafeName.length() <= 3) { 
//			this.cafeName = cafeName; 
//			System.out.println("생성 완료 !");
//		}
	}


	
}
