package day04;


public class For07 {

	public static void main(String[] args) {
		// for / while
		/* for문을 이용하여 구구단 5단을 출력
		 */
		
		int dan = 5; //2~9까지 반복
		System.out.println("단 입력 : ");
		
		for (int i = 1; i < 10; i++) {
			System.out.println(dan +" * "+ i +" = "+ (dan*i));
		}
		
		System.out.println("---------------");
//		int i=1, j=1;
//		int j;
//		for (int j=1; j <= 9; j++) {
//			System.out.println(dan +" * "+ j +" = "+ (dan*j));
//		}
		
		// 이중for문
		for(int j=1; j<=9; j++) { //단 => 증가값
			for (int i = 2; i <= 9; i++) { //증가값 => 단
				System.out.print(i +" * "+ j +" = "+(j*i)+" ");
			}
			System.out.println(); //줄바꿈
		}

	}

}
