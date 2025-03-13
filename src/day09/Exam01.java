package day09;

public class Exam01 {

	public static void main(String[] args) {
		/* 메서드로 작업
		 * 두 정수의 값이 주어졌을 때
		 * 두 정수 사이의 모든 정수의 합을 리턴하는 메서드
		 * ex) a=3, b=5 => 3+4+5
		 * ex) a=10, b=5 => 5+6+7+8+9+10
		 * ex) a=10, b=10 => 10
		 * */
		Exam01 e1 = new Exam01();
		System.out.println(e1.sum(3, 5));
		System.out.println(e1.sum(10, 5));
		System.out.println(e1.sum(3, 3));

	}
	
	// 매개변수 : 두 정수 => int num1, int num2
	// 리턴타입 : 합 => int
	public int sum(int num1, int num2) {
		int a=0, b=0, sum=0;
//		if(num1 > num2) {
//			a = num2;
//			b = num1;
//		}else if(num1 < num2) {
//			a = num2;
//			b = num1;
//		}else {
//			return num1;
//		}
//		
//		if(num1 > num2) {
//			int tmp = num1;
//			num1 = num2;
//			num2 = tmp;
//		}
		
		a = Math.min(num1, num2);
		b = Math.max(num1, num2);
		num1 = a; num2 = b;
		for(int i=num1; i<=num2; i++) {
			sum+= i;
		}
		return sum;
	}

}
