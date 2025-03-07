package day01;

public class Operator {

	public static void main(String[] args) {
		// 연산자
		/* 대입연산자 : =  +=  -= ...
		 * = 을 기준으로 오른쪽에 있는 값을 왼쪽 변수에 저장
		 * 왼쪽은 반드시 변수여야함.
		 * int a=1;
		 * int b=2;
		 * a=b;
		 * a=1;
		 * 1=a; (x)
		 * a += b;  a = a + b
		 * */
		
		int a = 1;
		int b = 5;
		a=b;
		System.out.println(a);
		a+=10;
		System.out.println(a);
		
		//증감연산자 : ++(1증가) / --(1감소)
		a++;
		System.out.println(a); //16
		System.out.println(a++); //16 출력 후 증가
		System.out.println(a); //17
		System.out.println(++a); //18 증가 후 출력
		
		//산술연산자 : + - * / %(나머지)
		/* 나누기 ( / % )
		 * 정수 / 정수 = 정수 (10/3=3)
		 * 정수 / 실수 = 실수 (10/3.0 = 3.33333...)
		 * 실수 / 정수 = 실수
		 * 실수 / 실수 = 실수
		 * 
		 * 정수 / 0 => 예외발생 (Exception)
		 * 실수 / 0 => infinity 발생
		 * */
		
		System.out.println(3.0/0);
		System.out.println(10/3.0);
		
		/* 비교연산자 : 비교연산의 결과는 반드시 true / false
		 * >=(이상), <=(이하), >(초과), <(미만), ==(같다), !=(같지않다)
		 * 논리연산자 : && (and), || (or), ! (not)
		 * a && b : a 조건과 b 조건이 모두 참이여야 true
		 * a || b : a 조건, b 조건중 하나만 참이여도 true
		 * !a : a 조건의 결과 반대
		 * */
		
		System.out.println(3 > 2);
		System.out.println(2 > 3);
		System.out.println((3>2 || 4>5));
		System.out.println(!(3>2));
		
		//연결연산자 : + (데이터의 결과가 문자일경우에만 가능)
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 + num2);
		System.out.println(num1 + num2 + "점"+ (num1+num2));
		
		// 조건선택연산자 : (조건식)? true : false
		System.out.println((3>2)?"3이 더 큽니다":"3이 더 작습니다.");
		
		/* 문제 
		 * num 변수를 선언하고, 값을 입력
		 * num가 짝수인지 홀수인지 판별.
		 * 조건선택 연산자 사용 %
		 * */
		System.out.println("-----------");
		
		System.out.println(5%2);
		System.out.println(5/2);
		
		int num3 = 6;
		System.out.println((num3 % 2 == 0) ? "짝수 입니다":"홀수 입니다");
		System.out.println((num3 / 2 == 0) ? "짝수 입니다":"홀수 입니다");
		
		//짝수의 규정 (num % 2 ==0)
				int num = 5;
				System.out.println((num % 2 ==0)? "짝수" : "홀수");
				
				int mod = num % 2;
				System.out.println(mod == 0 ? "짝수" : "홀수");
				
				String result = (num % 2 == 0) ? "짝수" : "홀수";
				
				System.out.println(result);
	
	}

}
