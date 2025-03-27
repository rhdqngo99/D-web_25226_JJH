package day06;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* 야구게임
		 * 컴퓨터가 3자리의 숫자를 생성 (각자리수는 0~9 의 수)
		 * => 배열로 저장 (랜덤) (중복 불가능)
		 * 유저는 3자리 숫자를 입력하여 맞추는 게임
		 * => 중복되지 않게 3자리 입력
		 * 자리와 숫자가 일치하면 strike
		 * 자리는 일치X 숫자만 일치하면 ball
		 * 아무것도 맞지 않으면 out
		 * ex) com : 1 2 3
		 * me : 1 8 9 => 1s
		 * me : 9 8 7 => out
		 * me : 1 3 2 => 1s 2b
		 * me : 1 2 3 => 3s 정답
		 * */ 
		
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("야구게임");
//		
//		int comNum[] = new int[3];
//		int meNum[] = new int[3];
//		int strike = 0;
//		int ball = 0;
//		
//		for (int i = 0; i < comNum.length; i++) {
//			comNum[i] = (int)(Math.random()*9)+1;
//			for (int j = 0; j < i; j++) {
//				if(comNum[j] == comNum[i]) {
//					i--; 
//					break;
//				}
//			}
//		}
//		for (int x : comNum) {
//			System.out.print(x +"  ");
//		}
		
		
		int comNum[] = new int[3];
		int myNum[] = new int[3];
		
		//comNum를 중복없이 생성(랜덤)
		for(int i=0; i<comNum.length; i++) { //comNum를 채우기위한 반복
			int r = (int)(Math.random()*10);
			comNum[i]=r;
			//배열에 r이 존재하는지 확인하기 위한 반복
			for(int j=0; j<i; j++) { 
				if(comNum[i] == comNum[j]) {
					i--;
					break;
				}
			}
			
		}
		for(int c : comNum) {
			System.out.print(c+" ");
		}
		System.out.println();
		System.out.println("------");
		
		while(true) {
			// myNum 입력
			System.out.println("숫자입력>");
			// 숫자를 하나의 문자로 받아 myNum에 나누어 저장(숫자로)
			String myStr = scan.next();
			String[] myStrTemp = myStr.split(""); // 한글자씩 배열로 저장
			
			//숫자로 변환해서 저장
			for(int i=0; i<myNum.length; i++) {
				myNum[i] =  Integer.parseInt(myStrTemp[i]); 
			}
			
			//숫자 비교
			int stk = 0;
			int ball = 0;
			
			for(int i=0; i<comNum.length; i++) { //com
				for(int j=0; j<myNum.length; j++) { //my
					if(comNum[i] == myNum[j] && i == j) {
						//값도 같고, 위치도 같다면...
						stk++;
					}else if(comNum[i] == myNum[j] && i != j) {
						//값만 같다면...
						ball++;
					}
				}
			}
			
			// 출력
			if(stk==0 && ball == 0) {
				System.out.println("out");
			}else {
				System.out.println("> "+stk+"s "+ball+"b");
			}
			
			//종료조건
			if(stk == 3) {
				System.out.println("성공!! 종료.");
				break;
			}
		}
		scan.close();
		
	}

}
