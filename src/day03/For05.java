package day03;

public class For05 {

	public static void main(String[] args) {
		/* 약수 : 1부터 자신의 수까지 나누어서 떨어지는 수 (나머지가 0인 수)
		 * 공약수 : 두 수의 공통된 약수
		 * 6의 약수 : 1 2 3 6
		 * 12의 약수 : 1 2 3 4 6 12
		 * 공약수 : 1 2 3 6 => 최대 공약수 : 6
		 * */ 
		
		// 공약수 출력 ==> and (둘다 맞다면..) %%
		
		int num1 = 6; 
		int num2 = 12;
		
		int gcd = 0;
		
		for (int i = 1; i <= num1; i++) {
			 if(num1 % i==0 && num2 % i == 0) {
				 System.out.println(i);
				 gcd = i;
			 }
		}
		System.out.println(gcd);
		
		System.out.println("------------------------------");
		
		// num1부터 1까지 1씩 감소 / 첫 조건이 맞다면 출력 후 break;
		for (int i=num1; i >= 1; i--) {
			if(num1 % i==0 && num1 % i == 0) {
				System.out.println(i);
				break;
			}
		}
		
		System.out.println("------------------------------");
		
		// num1부터 1까지 1씩 감소 / 첫 조건이 맞다면 출력 후 break;
		for (int i=num1; ; i--) {
			if(num1 % i==0 && num1 % i == 0) {
				System.out.println(i);
				break;
			}
		}
	}

}
