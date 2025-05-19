package re01;

import java.util.*;

public class New02 {

	public static void main(String[] args) {
		// for 문을 이용하여 숫자를 입력받아 1부터 입력한 수까지의 5의 배수를 출력
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자입력>");
		int num = scan.nextInt();
		
		for(int i=1; i<=num; i++) {
			if(i%5==0) { //5의 배수라면...
				System.out.print(i+" ");
			}
		}
		
		scan.close();

	} // main

} // class