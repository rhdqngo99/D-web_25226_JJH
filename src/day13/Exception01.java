package day13;

public class Exception01 {

	public static void main(String[] args) {
		// Exception : 예외. 예외 처리
		/* 오류의 종류. 
		 * - 논리적 에러 : 실행은 되지만 의도와는 다르게 동작하는 것.
		 * - 컴파일 에러 : 컴파일시 발생하는 에러 (문법 구문 오류 : syntax error)
		 * - 런타임 에러 : 실행 시 잘못된 결과를 얻거나, 
		 *               외부적인 요인으로 비정상 종료가 되는 경우
		 * 
		 * 실행시(runTime) 발생할 수 있는 오류를 
		 * 에러(error), 예외(exception) 두가지로 구분
		 * - 에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
		 * - 예외(exception) : 코드에 의해 수습될 수 있는 비교적 덜 심각한 오류
		 * - 문제가 발생할 때를 대비하여 이에 대한 대응코드를 미리 작성함. => 예외처리
		 * - 예외처리를 통해 비정상 종료를 막을 수 있음 
		 * 
		 * - 예외가 발생되면 예외발생 시점부터 코드는 중지 => 예외문구 출력
		 * - 예외처리 => 예외가 발생되는 코드만 빼고, 나머지는 정상처리로 유지시키는 기능
		 * 
		 * - try ~ catch
		 * - try ~ catch ~ finally
		 * - try : 예외가 발생할 가능성이 있는 구문을 작성 
		 * - catch : try 구문에서 발생한 에외를 처리
		 * - finally : try구문외 반드시 실행되어야 하는 구문을 작성 (생략가능)
		 * */
		
//		System.out.println(1+0);
//		System.out.println(1/0); //exception 발생라인
//		System.out.println(1-0);
		
		try {
			// 예외 발생가능성이 있는 코드 작성
			System.out.println(1+1);
			System.out.println(1-1);
			System.out.println(1*1);
			System.out.println(1/0); //exception 발생라인
			System.out.println(2+2);
			
		} catch (Exception e) {
			// e: Exception 클래스의 객체 (예외의 모든 클래스를 잡아주는 역할)
			e.printStackTrace(); // 예외 구문을 콘솔에 출력
			System.out.println("0으로 나누었습니다.");
			System.out.println(e.getMessage());
		}
		
		// Exception 발생해도 처리되는 구역
		System.out.println(3+3);
		System.out.println(4-4);
		
	}

}
