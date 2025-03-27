package project3;

public class CafeMain {
	public static void main(String[] args) throws InterruptedException {
		// 멤버 변수 초기화
			// CafeUser instance 생성 
		CafeUser cu = new CafeUser();
			// 일수를 저장할 변수 초기화
		
		// 기본 설정
		cu.homeImage();
		cu.setCafeName();
		cu.guestPaymentList();
		cu.cafeRecipeList();
		
		while(cu.days < 15) {
//			cu.loadingImage();
			cu.printUserCafeImage();
			cu.userStateBar();
			
			switch(cu.menuPrint()) {
				case 1:
					cu.cafeMenuPrint();
					cu.recipePrint();
//					Thread.sleep(10000);
					cu.guestOrder();
					break;
					
				case 2: cu.rest(); break;
				
				case 3: cu.fortunes(); break;
					
				case 4: cu.developMenu(); break;
					
				case 5: System.out.println("종료됩니다"); break;
					
				case 6: cu.ending(); break;
			}
		}
		System.out.println("Exit...!");
		
	}
}
