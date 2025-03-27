package day04;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		// 숫자를 입력받아 (0이나 -숫자를 입력하면 종료)
		// 입력받은 숫자의 합계와 평균을 출력
		// ex) 3+ 5 +4 +8 +9 0 = 합, 평균 출력 
		
		Scanner scan = new Scanner(System.in);
//		int str = 0; 
//		int sum = 0; 
//		int n = 0; 
//		System.out.println("출력 : (0이나 -숫자를 입력하면 종료)");
		
//		while (true) {
//			n = scan.nextInt();
//			if(n <= 0) break;
//			sum += n;
//			str++;
//		}
//		System.out.println("입력 : " + str);
//		System.out.println("합 : " + sum);
//		System.out.println("평균 : " + (double)n/str);
		
		int num=0, sum=0, count=0;
		String total="";
		do {
			System.out.println("출력 : (0또는 음수면 종료) >");
			num = scan.nextInt();
			if(num > 0) {
				sum += num;
				count++;
				total = total.concat("+").concat(String.valueOf(num));
			}
		} while (num > 0);
		if(count == 0) {
			System.out.println("입력한 숫자가 없습니다.");
		}else {
			System.out.println("계산식: "+total.substring(1));
			System.out.println("합계:"+sum+", 평균:"+((double)sum/(count-1)));
		}
		scan.close();

	}

}
