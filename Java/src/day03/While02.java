package day03;

public class While02 {

	public static void main(String[] args) {
		/* 1~50 짝수 출력
		 * 2 4 6 8 10
		 * 12 14 16 18 20
		 * 22 24 26 28 30
		 * ...
		 * 42 44 46 48 50
		 * 
		 * println(줄바꿈을 포함)
		 * print
		 * */ 
		
//		int i = 1;
//		while (i <= 50) {
//			if(i % 2 == 0) {
//				System.out.print(i+" ");
//				if(i % 10 ==0) {
//					System.out.println();
//				}
//			}
//			i++;
//		} 
		
		int i = 1;
		int count = 0; // 5 10 15 20 25
		while (i <= 50) {
			System.out.printf("%3d", i);
			count++;
			if(count % 5 ==0) {
				System.out.println();
			}
			i++;
		}
		
		/* println() : 줄바꿈이 있는 출력
		 * print() : 줄바꿈이 없는 출력, 출력 값이 없으면 error
		 * printf() : 지시자를 이용한 출력
		 * 
		 * 지시자
		 * %d(정수형), %f(실수형), %c(문자), %s(문자열), %n(줄바꿈)
		 * 소수점 설정 가능, 공백 추가 가능
		 * */
		System.out.println("---------------------");
		
		System.out.printf("%,2f%n", 1.66666666);
		
		// 3 + 5 = 8
		int a = 3;
		int b = 5;
		
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.printf("%d + %d = %d %n",a, b, (a+b));
		
		double score = 89.33333;
		double cnt = 5;
		
		System.out.printf("%.1f/%.0f=%.2f%n", score, cnt, (score/cnt));
	}

}
