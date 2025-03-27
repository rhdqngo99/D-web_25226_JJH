package project3;

import java.util.Scanner;

public class AMain {
	public static void main(String[] args) throws InterruptedException {
		// 멤버 변수 초기화
		char respon;
		int cnt = 0;
		
			// ShellGame 생성 
		ShellGameController sGc = new ShellGameController();
			
			// Card 게임 생성
		ConsoleView cardGc = new ConsoleView();
		
			// Dice 게임 생성 
		DiceGameController diceGc1 = new DiceGameController();
		DiceGameController diceGc2 = new DiceGameController();
		
			// 카페 게임 생성 
		CafeUser cGc = new CafeUser();
	
			// Console Print 생성
		ConsolePrint cp = new ConsolePrint();
			
			// 입력 초기화 
		Scanner sc = new Scanner(System.in);
		
			// 변수 설정
		int diceLoop = -1;
		boolean bool1 = true;
		boolean bool2 = true;
			
		
		cp.menuPrint();
		
		int chNo = sc.nextInt();
		
		// 메뉴 선택
		switch(chNo){
			// 야바위 게임 
			case 1 : 
				// Image 출력
				cp.menu1(); cp.startMenu();
			
				System.out.println("\r\n"
						+ " _    _ _____ _     _____ ________  ________ \r\n"
						+ "| |  | |  ___| |   /  __ \\  _  |  \\/  |  ___|\r\n"
						+ "| |  | | |__ | |   | /  \\/ | | | .  . | |__  \r\n"
						+ "| |/\\| |  __|| |   | |   | | | | |\\/| |  __| \r\n"
						+ "\\  /\\  / |___| |___| \\__/\\ \\_/ / |  | | |___ \r\n"
						+ " \\/  \\/\\____/\\_____/\\____/\\___/\\_|  |_|____/ \r\n"
						+ "");
				System.out.println("\r\n"
						+ " _____ _____   _____ _   _ _____   _____  ___  _____ _____ _   _ _____ \r\n"
						+ "|_   _|  _  | |_   _| | | |  ___| /  __ \\/ _ \\/  ___|_   _| \\ | |  _  |\r\n"
						+ "  | | | | | |   | | | |_| | |__   | /  \\/ /_\\ \\ `--.  | | |  \\| | | | |\r\n"
						+ "  | | | | | |   | | |  _  |  __|  | |   |  _  |`--. \\ | | | . ` | | | |\r\n"
						+ "  | | \\ \\_/ /   | | | | | | |___  | \\__/\\ | | /\\__/ /_| |_| |\\  \\ \\_/ /\r\n"
						+ "  \\_/  \\___/    \\_/ \\_| |_|____/   \\____|_| |_|____/ \\___/\\_| \\_/\\___/ \r\n"
						+ "");
				
				do {
					// 메뉴 출력 
					sGc.menuPrint();
					
					// 컵 섞기 
					sGc.compareResult(sGc.shuffle());
				}while(sGc.finCond());	
				break;
				
				
			// 카드 게임 	
			case 2 : 
				cp.menu2(); cp.startMenu();
				
				new GameController().startGame(); break;
			
				
			// 주사위 게임 
			case 3 : 
				cp.menu3(); cp.startMenu();
				System.out.println("-------------Player 1 이름 설정--------------");
				diceGc1.playerNameSet();
				System.out.println();
				
				System.out.println("-------------Player 2 이름 설정--------------");
				diceGc2.playerNameSet();
				Thread.sleep(1000);
				diceGc1.startRulePrint();
				
				// dc2.playerNameSet();
				
					// 진행 
				do {
					diceGc1.namePrint();
					diceGc1.loadingPrint();
					diceGc1.rollDice5();
					// dc2.rollDice5();
					
					// 1p
					Loop1 : while(bool1) {
						switch(diceGc1.gamePlayMenu()) {
							// 1) 게임 규칙 보기
							case 1 : diceGc1.printRules(); break;
							
							// 2) 주사위 킵 
							case 2 : diceGc1.keepDice(); break;
								
							// 3) 주사위 굴리기 
							case 3 : diceGc1.modRollDice(); break;
							
							// 4) 점수 기록 
							case 4 : 
								diceGc1.scoreSave(); 
								bool1 = false;
								break Loop1;
						}				
					}
					
					// 2p
					diceGc2.namePrint();
					diceGc2.loadingPrint();
					
					diceGc2.rollDice5();
					
					// 실행
					while(bool2) {
						switch(diceGc2.gamePlayMenu()) {
							// 1) 게임 규칙 보기
							case 1 : diceGc2.printRules(); break;
							
							// 2) 주사위 킵 
							case 2 : diceGc2.keepDice(); break;
								
							// 3) 주사위 굴리기 
							case 3 : diceGc2.modRollDice(); break;
							
							// 4) 점수 기록 
							case 4 : 
								diceGc2.scoreSave(); 
								bool2 = false;
								break;
						}				
					}
					bool1 = true;
					bool2 = true;
					cnt++;
				}while(cnt <= 9); break;
			
				
			// 카페 게임 
			case 4 : 
				cp.menu4(); cp.startMenu();
			
			// 기본 설정
				cGc.homeImage();
				cGc.setCafeName();
				cGc.guestPaymentList();
				cGc.cafeRecipeList();
				
				while(cGc.days < 15) {
					cGc.loadingImage();
					cGc.printUserCafeImage();
					cGc.userStateBar();
					
					switch(cGc.menuPrint()) {
						case 1:
							cGc.cafeMenuPrint();
							cGc.recipePrint();
//							Thread.sleep(10000);
							cGc.guestOrder();
							break;
							
						case 2: cGc.rest(); break;
						
						case 3: cGc.fortunes(); break;
							
						case 4: cGc.developMenu(); break;
							
						case 5: System.out.println("종료됩니다"); cGc.days = 20; break;
							
						case 6: cGc.ending(); break;
					}
				}
				System.out.println("Exit...!"); break;
				
			// 종료	
			case 5 : cp.menu5(); break;
		}
		
		System.out.println("Finished..!");
	}
}
