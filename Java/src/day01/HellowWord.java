package day01;

public class HellowWord {

	public static void main(String[] args) {
		//주석 : 프로그램이 읽지 않는 라인 Ctrl + / => 한줄주석
		/* 머리줄 주석
		 * console : 출력
		 * println() : 줄바꿈을 포함하는 출력
		 * print() : 줄바꿈이 없는 출력
		 * printf() : 형식을 가지는 출력(C언어에서 주로 사용)
		 * 
		 * 문자열은 " " / 한글자 ' ' / 숫자는 따옴표 없음.
		 * */
		System.out.println("Hellow world!!!"); // 기본 출력 구문
		System.out.println(123);
		System.out.println('a');
		System.out.println("a");
		
		char ch = 'a';
		System.out.println(ch);
		
		String s = "abc";
		System.out.println(s);
		
		int a = 1;
		a = a + 1;
		System.out.println(a);
		a += 1;
		System.out.println(a);
		
//      =============================
		
		//변수
		int num = 100;
//		int num = 200; // 중복선언 불가능.
		num = 200; //기존 변수값은 덮어쓰기한다.
		
		int num1, num2, num3;
		num1 = 10;
		num2 = 20;
		num3 = 30;
		
		System.out.println(num1 + num2 + num3);
		
		num1++; // num1 = num1 + 1
		
		int num4; //선언만.
		
		// 기본자료형(8가지)은 초기값을 가지지 않으면 오류
//		System.out.println(num4);
		
		
	}

}
