package day07;

import java.util.Scanner;

public class MethodEx01 {
	
	// 두 정수를 입력받아 더한 값을 리턴  
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	// 두 정수를 입력받아 뺀 값을 리턴
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double div(int num1, int num2) {
		return num1 / num2;
		
	}
	
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
	
	
	public static void main(String[] args) {
		/* 계산기 만들기
		 * 
		 * --menu--
		 * 1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.나머지 | 6.종료
		 * >> 메뉴선택 1
		 * >> 숫자 입력 > 1 5
		 * 결과 : 1 + 5 = 6
		 * 
		 * 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지는 메서드로 호출하여 
		 * 연산결과를 출력
		 * */
		//Method03에 만들어 놓은 메서드 활용 * / %
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		do {
			System.out.println("--menu--");
			System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.나머지 | 6.종료");
			System.out.println(">> 선택 :");
			menu = scan.nextInt();
			
			int num1=0, num2=0;
			
			if(menu <=5 && menu > 0) {
				System.out.println("연산할 두 수 입력>");
				num1 = scan.nextInt();
				num2 = scan.nextInt();				
			}
			
			if(num2==0 && (menu==4 || menu==5 )) {
				System.out.println("피연산자가 0입니다.");
			}else {
				switch(menu) {
				case 1:
					System.out.println(num1+"+"+num2+"="+sum(num1, num2));
					break;
				case 2:  
					System.out.println(num1+"-"+num2+"="+sub(num1, num2));
					break;
				case 3: 
					System.out.println(num1+"*"+num2+"="+Method03.mul(num1, num2));
					break;
				case 4:
					double result = Method03.div(num1, num2);
					if(result == -999999999) {
						System.out.println("num2의 값이 0입니다.");
					}else {
						System.out.println(num1+"/"+num2+"="+result);					
					}
					break;
				case 5: 
					System.out.println(num1+"%"+num2+"="+mod(num1, num2));
					break;
				case 6: System.out.println("종료");  break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
			}
			
		}while(menu != 6);
			
		scan.close();
	}

}
