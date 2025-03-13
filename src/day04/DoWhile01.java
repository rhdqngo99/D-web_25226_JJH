package day04;

import java.util.Scanner;

public class DoWhile01 {

	public static void main(String[] args) {
		/* 반복문 : for, while, do~while
		 * for, while : 조건을 만족하지 않으면 1번도 실행안될수 있음.
		 * do~while : 실행문을 먼저 실행하고, 조건식을 나중에 비교
		 * 무조건 1번은 실행 후 비교하는 구조
		 * 
		 * do{
		 *  실행문;
		 * } while(조건식);  //조건식이 참이여야 반복
		 * */
		
		Scanner scan = new Scanner(System.in);
		/* 한글자를 입력받아서 출력
		 * y => 종료
		 * */
		
		char ch = 'y';
		
		do {
			System.out.println("한글자입력>");
			ch = scan.next().charAt(0);
			System.out.println(ch);
			
		} while (ch != 'y');
		
		System.out.println("종료");
		
		scan.close();
	}

}
