package day07;

public class Method04 {
	
	/* 정수 (2~9까지 중 하나)를 입력받아 
	 * 정수에 해당하는 구구단을 출력하는 메서드
	 * 리턴타입 : 출력 => 없음 void
	 * 메서드명 : multi
	 * 매개변수 : 정수하나 => int num1
	 * */
	public static void multi(int num1) {
		for(int i=1; i<=9; i++) {
			System.out.println(num1+"*"+i+"="+(num1*i));
		}
	}
	
	/* 구구단 출력 메서드
	 * 리턴타입 : X void
	 * 매개변수 : X ()
	 * */
	public static void multiTotal() {
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int num = 6;
		multi(num);
		multiTotal();
		
	}

}
