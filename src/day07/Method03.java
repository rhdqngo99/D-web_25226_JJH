package day07;

public class Method03 {

	/* 두 정수의 합을 리턴하는 메서드
	 * */
	public static int sum (int num1, int num2) {
		int a = num1 + num2;
		return a;
	}
	
	// 두 정수의 차를 리턴하는 메서드
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	// *
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	// / 
	public static double div(int num1, int num2) {
		if (num2 == 0) {
			return -999999999;
		}else {
			return num1 / (double)num2;			
		}
	}
	
	// %
	public static int mod(int num1, int num2) {
		if (num2 == 0) {
			return -999999999;
		}else {
			return num1 % num2;			
		}
	}
	public static void main(String[] args) {
		/* + - * / % 기능을 하는 메서드를 생성
		 * main에서 호출 => 출력
		 * */
		int num1 = 10, num2 = 0;
		System.out.println(sum(num1, num2));
		System.out.println(sub(num1, num2));
		System.out.println(mul(num1, num2));
		// 피연산자가 0이면 에러
		
		double result = div(num1, num2);
		if(result == -999999999) {
			System.out.println("피연산자가 0입니다.");
		}else {
			System.out.println(result);
		}
		
		int modResult = mod(num1, num2);
		if(modResult == -999999999) {
			System.out.println("피연산자가 0입니다.");
		}else {
			System.out.println(modResult);
		}
		
		System.out.println("----------");
		
		// 다른 클래스에 있는 메서드를 호출할 경우
		// 클래스명.메서드명(); => static일 경우
		Method04.multiTotal();

	}

}