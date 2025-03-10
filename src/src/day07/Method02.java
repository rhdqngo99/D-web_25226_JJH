package day07;

public class Method02 {
	
	/* 두 정수가 주어지면 두수의 합을 리턴하는 메서드
	 * 리턴타입 : 합 => int
	 * 메서드명 : sum
	 * 매개변수 : 두 정수 => int num1, int num2
	 * */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	/* 리턴이 없는 케이스
	 * 두 정수가 주어지면 두수의 합을 출력하는 메서드
	 * 리턴타입 : 없음 void
	 * 메서드명 : sum1
	 * 매개변수 : 두 정수 => int num1, int num2
	 * */
	public static void sum1(int num1, int num2) {
		System.out.println(num1+num2);
	}
	
	/* 매개변수가 없는 케이스
	 * 합을 출력하는 메서드
	 * 리턴타입 : 없음 void
	 * 메서드명 : sum2
	 * 매개변수 : 없음.
	 * */
	public static void sum2() {
		int num1 = 5, num2 = 6;
		int hap =sum(num1, num2);
		System.out.println(hap);
	}
	

	public static void main(String[] args) {
		/* sum method 호출하여 출력
		 * */
		int num1 = 6, num2 = 8;
		System.out.println(sum(num1, num2));
		
		// sum1 호출 => 리턴이 void
		sum1(num1, num2);
		
		sum2();
		
	}

}
