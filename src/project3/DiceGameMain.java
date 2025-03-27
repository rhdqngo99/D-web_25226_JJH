package project3;

import java.util.ArrayList;
import java.util.Scanner;

public class DiceGameMain {

	public static void main(String[] args) throws InterruptedException {
		// 멤버 변수 초기화 
			// 게임 진행 횟수 기록 변수
		int cnt = 0;
		int diceCnt = 0;
		
			// DiceGameController instance 생성 
		DiceGameController dc1 = new DiceGameController();
		
		dc1.startRulePrint();
		dc1.playerNameSet();
		// dc2.playerNameSet();
		
			// 진행 
		do {
			if(dc1.totalNum <= 2) {
				dc1.plDiceList.clear();
				dc1.rollDice5();
			}
			// dc2.rollDice5();
			
			// 1p
			while(dc1.totalNum <= 2) {
				switch(dc1.gamePlayMenu()) {
					// 1) 게임 규칙 보기
					case 1 : dc1.printRules(); break;
					
					// 2) 주사위 킵 
					case 2 : dc1.keepDice(); break;
						
					// 3) 주사위 굴리기 
					case 3 : dc1.modRollDice(); break;
					
					// 4) 점수 기록 
					case 4 : dc1.scoreSave(); break;
				}		
				diceCnt++;
			}
			
			// 2p
//			while(dc2.totalNum <= 3) {
//				switch(dc2.gamePlayMenu()) {
//				// 1) 게임 규칙 보기
//				case 1 : dc2.printRules(); break;
//				
//				// 2) 주사위 킵 
//				case 2 : 
//					dc2.keepDice(); break;
//					
//					// 3) 주사위 굴리기 
//				case 3 : dc2.modRollDice();
//				
//				// 4) 점수 기록 
//				case 4 :
//				}				
//			}
			
			cnt++;
		}while(cnt <= 9); 
	}
}
