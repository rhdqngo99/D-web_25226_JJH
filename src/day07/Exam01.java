package day07;

import java.util.Random;
import java.util.Scanner;

public class Exam01 {
	public static int[] ballArray() {
		Random rd = new Random();
		int[] ballArray = {10, 10, 10};
		for (int i = 0; i < ballArray.length; i++) {
			int ball = rd.nextInt(10);
			ballArray[i] = ball;
			for (int j = 0; j < ballArray.length; j++) {
				if(ballArray[j] != ballArray[i]) {
					continue;
				}else {
					i--;
					break;
				}
			}
		}
		return ballArray;
	}
	
	public static int[] myNum() {
		System.out.println("숫자입력(중복X)> ");
		Scanner sc = new Scanner(System.in);
		int myNum = sc.nextInt();
		int num1, num2, num3;
		
		num1 = myNum / 100;
		num2 = (myNum/10)%10;
		num3 = myNum % 10;
		
		int[] myNumArray = {num1, num2, num3};
		return myNumArray;
	}
	
	
	
	
	public static void main(String[] args) {
		/* ArrayEx01 에서 했던 야구게임을
		 * 메서드 분리 후 실행
		 * */
		int comNum[] = new int[3];
		int myNum[] = new int[3];
		
		
		
	
	}
	
	/* 배열을 입력받아 랜덤으로 값이 중복되지 않게(중복확인 메서드 활용) 채우기
	 * 랜덤값은 0~9까지
	 * */
	
	/* 중복확인 메서드
	 * 배열과, 랜덤 값을 입력 받아
	 * 배열에 랜덤값이 존재하면 true / 없으면 false를 리턴
	 * */
	
	/* 스트라이크 개수를 카운트 하는 메서드
	 * comNum, myNum 배열을 입력받아 번호와 위치가 일치 하면
	 * count 값을 리턴하는 메서드
	 * */
	
	/* 볼 개수를 카운트 하는 메서드
	 * comNum, myNum 배열을 입력받아 번호만 일치 하면
	 * count 값을 리턴하는 메서드
	 * */
	
}
