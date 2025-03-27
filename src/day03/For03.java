package day03;

import java.util.Scanner;

public class For03 {

	public static void main(String[] args) {
		// 구구단 2단 출력
		// 2*2=2 / 2*2=4 / 2*3=6 / ... 2*9=18
//		int num = 2; // 입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int num = scan.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(num+"*"+i+"="+(num*i));
		}
		
		scan.close();
	}

}
