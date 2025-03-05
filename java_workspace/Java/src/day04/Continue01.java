package day04;

public class Continue01 {

	public static void main(String[] args) {
		// continue : 계속, pass, skip 개념
				/* 1~10까지 출력 5만 빼고
				 * */
				
				for(int i=1; i<=10; i++) {
					if(i==5) {
						continue; //조건에 맞다면 pass
					}
					System.out.print(i+" ");
				}
				System.out.println();
				
				/* 1~10까지 짝수만 출력 
				 * 홀수면 continue;
				 * */
				
				for(int i=1; i<=10; i++) {
					if(i % 2 ==1) {
						continue;
					}
					System.out.print(i+" ");
				}
				System.out.println();
		
	}

}
