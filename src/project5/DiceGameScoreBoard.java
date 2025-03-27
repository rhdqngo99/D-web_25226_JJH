package project5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 점수 기록 판
public class DiceGameScoreBoard {
	// 멤버 변수 초기화
		// 상위 항목
			// 주사위에서 1이 나온 개수만큼 점수 합산 (예: 1이 3개 나오면 3점)
	private int aces;
			// 주사위에서 2가 나온 개수만큼 점수 합산 (예: 2이 3개 나오면 6점)
	private int deuces;
			// 주사위에서 3이 나온 개수만큼 점수 합산 (예: 3이 3개 나오면 9점)
	private int threes;
			// 주사위에서 4가 나온 개수만큼 점수 합산 (예: 4이 3개 나오면 12점)	
	private int fours;
			// 주사위에서 5가 나온 개수만큼 점수 합산 (예: 5이 3개 나오면 15점)
	private int fives;
			// 주사위에서 6이 나온 개수만큼 점수 합산 (예: 6이 3개 나오면 18점)
	private int sixes;
	

		// 하위 항목
			// 초이스 (Choice) 는 주사위 5개의 합계가 점수 
			// Ex) 1 1 1 1 1 인 경우 5점이며 최대 30점까지 가능, 사용 X
	private int choice;
			// subTotal 은 1~6 까지의 점수 합계가 63점 이상일 경우 보너스 35 점 추가
	private int subTotal;
	
			// 4 or Kind 는 동일한 주사위 눈금이 4개 이상일 경우 집계되는 점수로 
			// 해당 주사위 눈금의 총합이 점수가 됨 
	private int same4;
			// Full House 는 같은 숫자 3개 + 다른 숫자 2개일 경우 
			// 해당 주사위 눈금들의 총합으로 1 1 1 3 3 인 경우, 9점이며 최대 28점까지 가능
//	private int fullHouse;	
			// Yacht 는 모든 주사위의 눈금이 같은 경우 집계되는 점수로 고정 점수 50점 획득
	private int yacht;
	
	
	// 기본 생성자 
	public DiceGameScoreBoard() {};
	
	// 상위 항목 메서드 
		// acesSum() - aces 점수 기록 메서드
	public void acesSum(ArrayList<Integer> plDiceList) {
		for(int i : plDiceList) {
			if(i == 1) { this.aces += 1; }
		}
	}
		// acesPrint() - aces 점수 출력 메서드 
	public void acesPrint() { System.out.println(aces); }
		
	
		// deucesSum() - deuces 점수 기록 메서드
	public void deucesSum(ArrayList<Integer> plDiceList) {
		for(int i : plDiceList) {
			if(i == 2) { this.deuces += 2;}
		}
	}
	
		// deucesPrint() - deuces 점수 출력 메서드 
	public void deucesPrint() { System.out.println(deuces); }
	
	
		// threesSum() - threes 점수 기록 메서드
	public void threesSum(ArrayList<Integer> plDiceList) {
		for(int i : plDiceList) {
			if(i == 3) { this.threes += 3;}
		}
	}
	
		// threesPrint() - threes 점수 출력 메서드 
	public void threesPrint() { System.out.println(threes); }
	
	
		// foursSum() - fours 점수 기록 메서드 
	public void foursSum(ArrayList<Integer> plDiceList) {
		for(int i : plDiceList) {
			if(i == 4) { this.fours += 4;}
		}
	}
	
		// foursPrint() - fours 점수 출력 메서드 
	public void foursPrint() { System.out.println(fours); }
	
	
		// fivesSum() - fiveSum() 점수 기록 메서드
	public void fivesSum(ArrayList<Integer> plDiceList) {
		for(int i : plDiceList) {
			if(i == 5) { this.fives += 5;}
		}
	}
		
		// fivesPrint() - fives 점수 출력 메서드
	public void fivesPrint() { System.out.println(fives); }
	
	
		// sixesSum() - sixesSum() 점수 기록 메서드
	public void sixesSum(ArrayList<Integer> plDiceList) {
		for(int i : plDiceList) {
			if(i == 6) { this.aces += 6;}
		}
	}
	
		// sixesPrint() - sixes 점수 출력 메서드
	public void sixesPrint() { System.out.println(sixes); }
	
	
	// 하위 항목 메서드
		// choiceSum() - choice 점수 기록 메서드
	public void choiceSum(ArrayList<Integer> plDiceList) {
		
	}
	
		// subTotal() - 상위 항목의 합이 63 점 이상인 경우 35 점 보너스
	public void subTotal(ArrayList<Integer> plDiceList) {
		int tmpSum = 0;
		
		tmpSum = this.aces + this.deuces + this.threes + this.fours 
							+ this.fives + this.sixes;
		
		if(tmpSum >= 63) { this.subTotal += 35; }
	}
	
	
		// same4Sum() - 4 or Kind 점수 기록 메서드 
	public void same4Sum(ArrayList<Integer> plDiceList) {
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		int cnt6 = 0;
		
		for(int i : plDiceList) {
			if(i == 1) { cnt1++; }
			else if(i == 2) { cnt2++; }
			else if(i == 3) { cnt3++; }
			else if(i == 4) { cnt4++; }
			else if(i == 5) { cnt5++; }
			else if(i == 6) { cnt6++; }
		}
		
		if(cnt1 == 4) { 
			if(cnt2 == 1) { this.same4 += 6; }
			else if(cnt3 == 1) { this.same4 += 7; }
			else if(cnt4 == 1) { this.same4 += 8; }
			else if(cnt5 == 1) { this.same4 += 9; }
			else if(cnt6 == 1) { this.same4 += 10; }
		}
		
		else if(cnt2 == 4) { 
			if(cnt1 == 1) { this.same4 += 9; }
			else if(cnt3 == 1) { this.same4 += 11; }
			else if(cnt4 == 1) { this.same4 += 12; }
			else if(cnt5 == 1) { this.same4 += 13; }
			else if(cnt6 == 1) { this.same4 += 14; }
		}
		
		else if(cnt3 == 4) { 
			if(cnt1 == 1) { this.same4 += 13; }
			else if(cnt2 == 1) { this.same4 += 14; }
			else if(cnt4 == 1) { this.same4 += 16; }
			else if(cnt5 == 1) { this.same4 += 17; }
			else if(cnt6 == 1) { this.same4 += 18; }
		}
		
		else if(cnt4 == 4) { 
			if(cnt1 == 1) { this.same4 += 17; }
			else if(cnt2 == 1) { this.same4 += 18; }
			else if(cnt3 == 1) { this.same4 += 19; }
			else if(cnt5 == 1) { this.same4 += 21; }
			else if(cnt6 == 1) { this.same4 += 22; }
		}
		
		else if(cnt5 == 4) { 
			if(cnt1 == 1) { this.same4 += 21; }
			else if(cnt2 == 1) { this.same4 += 22; }
			else if(cnt3 == 1) { this.same4 += 23; }
			else if(cnt4 == 1) { this.same4 += 24; }
			else if(cnt6 == 1) { this.same4 += 26; }
		}
		
		else if(cnt6 == 4) { 
			if(cnt1 == 1) { this.same4 += 25; }
			else if(cnt2 == 1) { this.same4 += 26; }
			else if(cnt3 == 1) { this.same4 += 27; }
			else if(cnt4 == 1) { this.same4 += 28; }
			else if(cnt5 == 1) { this.same4 += 29; }
		}
	}
	
	
		// yachtSum() - yacht 점수 기록 메서드
	public void yachtSum(ArrayList<Integer> plDiceList) {
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		int cnt6 = 0;
		
		
		for(int i : plDiceList) {
			if(i == 1) { cnt1++; }
			else if(i == 2) { cnt2++; }
			else if(i == 3) { cnt3++; }
			else if(i == 4) { cnt4++; }
			else if(i == 5) { cnt5++; }
			else if(i == 6) { cnt6++; }
		}
		
		if(cnt1 == 5) { this.yacht += 50; }
		else if(cnt2 == 5) { this.yacht += 50; }
		else if(cnt3 == 5) { this.yacht += 50; }
		else if(cnt4 == 5) { this.yacht += 50; }
		else if(cnt5 == 5) { this.yacht += 50; }
		else if(cnt6 == 5) { this.yacht += 50; }
		
		else { System.out.println("잘못된 입력입니다"); return; }
	}
	
	// 총 점수 출력 메서드 
	public void allScorePrint() {
		System.out.println("==================<항목별 점수>==================");
		System.out.println("-----상위 항목-----");
		System.out.println("Aces : " + this.aces);
		System.out.println("Deuces : " + this.deuces);
		System.out.println("Threes : " + this.threes);
		System.out.println("Fours : " + this.fours);
		System.out.println("Fives : " + this.fives);
		System.out.println("Sixes : " + this.sixes);
		System.out.println();
		
		System.out.println("-----하위 항목-----");
		System.out.println("Subtotal : " + this.subTotal);
//		System.out.println("Choice : " + choice);
		System.out.println("4 or Kind : " + this.same4);
//		System.out.println("Full House : " + fullHouse);
		System.out.println("Yacht : " + this.yacht);
		System.out.println();
		
		System.out.println("-----총 합계-----");
		System.out.println("Total : " + (this.aces + this.deuces + this.threes 
											+ this.fours + this.fives + this.sixes 
											+ this.choice + this.same4 + /*fullHouse*/ + this.yacht));
		System.out.println("============================================");
		System.out.println();
	}
	
		
	
	// Getter(), Setter()
	int getAces() {
		return aces;
	}
	void setAces(int aces) {
		aces = aces;
	}
	int getDeuces() {
		return deuces;
	}
	void setDeuces(int deuces) {
		deuces = deuces;
	}
	int getThrees() {
		return threes;
	}
	void setThrees(int threes) {
		threes = threes;
	}
	int getFours() {
		return fours;
	}
	void setFours(int fours) {
		fours = fours;
	}
	int getFives() {
		return fives;
	}
	void setFives(int fives) {
		fives = fives;
	}
	int getSixes() {
		return sixes;
	}
	void setSixes(int sixes) {
		sixes = sixes;
	}
	int getChoice() {
		return choice;
	}
	void setChoice(int choice) {
		this.choice = choice;
	}
	int getSame4() {
		return same4;
	}
	void setSame4(int same4) {
		this.same4 = same4;
	}
//	int getFullHouse() {
//		return fullHouse;
//	}
//	void setFullHouse(int fullHouse) {
//		this.fullHouse = fullHouse;
//	}
	int getYacht() {
		return yacht;
	}
	void setYacht(int yacht) {
		this.yacht = yacht;
	}
	
}
