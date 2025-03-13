package day09;

public class Method09 {

		public static void main(String[] args) {
			/* 재귀메서드 : 메서드 안에서 본인의 메서드를 호출하는 메서드
			 * ! : 팩토리얼
			 * 1부터 자신의 수까지 곱해서 값을 리턴
			 * 0! => 1
			 * 1! => 1
			 * 2! => 1*2
			 * 3! => 1*2*3
			 * 4! => 1*2*3*4
			 * */
			Method09 m9 = new Method09();
			System.out.println(m9.fact(5));
			System.out.println(m9.fact(4));
			
			System.out.println(m9.factorial(5));

		}
		
		public int fact(int num) {
			if(num < 0) {
				return 0;
			}
			if(num == 0 || num == 1) {
				return 1;
			}
			int result = 1; // 곱한 값을 0으로 만들지 않기 위해 1
			for(int i=2; i<=num; i++) {
				result *= i;
			}
			return result;
		}
		
		// 재귀메서드로...
		public int factorial(int num) {
			if(num < 0) {
				return 0;
			}
			if(num == 0 || num == 1) {
				return 1;
			}
			
			return num * factorial(num-1);
		}
	}
