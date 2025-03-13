package day07;

import java.util.Scanner;

public class Exam01 {
	
	public static void main(String[] args) {
		/* ArrayEx01 에서 했던 야구게임을 
		 * 메서드 분리 후 실행.
		 * */
		// 배열 출력 메서드 => MethodEx02.printArray()  => 호출

		int comNum[] = new int[3];
		int myNum[] = new int[3];
		int s=0, b=0;
		
		Scanner scan = new Scanner(System.in);
		createArray(comNum); 
		MethodEx02.printArray(comNum);
		System.out.println("--------");
		// 사용자 번호 입력
		while(s!=3) {
			System.out.println("mynum 3개 > ");
			int i=0;
			while(i<3) {
				myNum[i] = scan.nextInt();
				i++;
			}
			
			//결과 출력
			s = strike(comNum, myNum);
			b = ball(comNum, myNum);
			if(s==0 && b==0) {
				System.out.println("out!!");
			}else {
				System.out.println(s+"s "+b+"b ");
			}
		}
		System.out.println("게임 종료!!");
		scan.close();
		
	}
	
	/* 배열을 입력받아 랜덤으로 값이 중복되지 않게(중복확인 메서드 활용) 채우기 
	 * 랜덤값은 0~9까지
	 * 리턴타입 : 없음. void
	 * 매개변수 : 배열 => int arr[]
	 * 메서드명 : createArray
	 * */ 
	public static void createArray(int arr[]) {
		// while 사용
		int cnt = 0; // i 역할을 할 변수
		while(cnt < arr.length) {
			// 랜덤 생성
			int r = (int)(Math.random()*10);
			if(!isContain(arr, r)) {
				arr[cnt] = r;
				cnt++;
			}
		}
		
	}
	
	/* 중복확인 메서드
	 * 배열과, 랜덤값을 입력받아 
	 * 배열에 랜덤값이 존재하면 true / 없으면 false를 리턴
	 * 리턴타입 : boolean
	 * 매개변수 : 배열, 랜덤값 => int arr[], int random
	 * 메서드명 : isContain
	 * */
	public static boolean isContain(int arr[], int random) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == random) {
				return true;
			}
		}
		return false;
	}
	

	/* 스트라이크 개수를 카운트하는 메서드 
	 * comNum, myNum 배열을 입력받아 번호와 위치가 일치하면 
	 * count 값을 리턴하는 메서드
	 * 리턴타입 : count 리턴 => int 
	 * 매개변수 : comNum, myNum => int comNum[], int myNum[]
	 * 메서드명 : strike
	 * */
	public static int strike(int comNum[], int myNum[]) {
		int count=0;
		for(int i=0; i<comNum.length; i++) {
			if(comNum[i] == myNum[i]) {  // i => 같은 위치에 있는 값.
				count++;
			}
		}
		return count;
	}
	
	/* 볼개수를 카운트하는 메서드 
	 * comNum, myNum 배열을 입력받아 번호만 일치하면 
	 * count 값을 리턴하는 메서드
	 * 리턴타입 : count 리턴 => int 
	 * 매개변수 : comNum, myNum => int comNum[], int myNum[]
	 * 메서드명 : ball
	 * */
	public static int ball(int comNum[], int myNum[]) {
		//isContain 메서드 활용하여 같은 숫자 찾기
		int count=0;
		for(int i=0; i<comNum.length; i++) {
			if(isContain(myNum, comNum[i])) { // 일치한다면 카운트 올리기
				count++; // ball + strike 같이 체크
			}
		}
		return count - strike(comNum, myNum); //strike 빼기
	}
	
}
