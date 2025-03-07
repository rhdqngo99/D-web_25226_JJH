package day02;

import java.util.Scanner;

public class Input01 {

	public static void main(String[] args) {
		// Input Class
		// console input : 콘솔에서 값을 입력받는 것을 의미
		// Scanner 클래스 : 객체를 생성 후 사용 new 키워드
		// 클래스명 객체이름 = new 클래스명(값);
		// 객체명.next() : 한단어만 입력(문자)
		// 객체명.nextLine() : 공백 포함
		// 객체명.next자료형() : 자료형에 맞는 값 입력
		
		
		//string a = "abc";
		Scanner scan = new Scanner(System.in);
//		System.out.println("숫자입력");
//		int num = scan.nextInt();
//		System.out.println(num);
//		
//		if(num % 2 ==0) {
//			System.out.println("짝수");
//		}else {
//			System.out.println("홀수");
//		}
		
//		System.out.println("소수점을 포함한 수를 입력>");
//		double d = scan.nextDouble();
//		System.out.println(d);
		
		System.out.println("문자입력>");
		String s = scan.next();
		System.out.println(s);
		
		scan.nextLine();
		
		System.out.println("여러단어입력>");
		String s1 = scan.nextLine( );
		System.out.println(s1);
		
		
		scan.close();
		
	}

}
