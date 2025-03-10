package day02;

import java.util.Scanner;

public class If02 {

	public static void main(String[] args) {
		/* 국어, 영어, 수학점수를 입력받아
		 * 합계, 평균, pass 여부를 출력
		 * pass 여부는 80이상이면 합격 - if
		 * 
		 * break; : 구문종료
		 * return; : 메서드 종료
		 * */ 
		
		Scanner scan = new Scanner(System.in);
		int kor, eng, mamath;
		
		System.out.println("국어점수>");
		kor = scan.nextInt();
		System.out.println("영어점수>");
		eng = scan.nextInt();
		System.out.println("수학점수>");
		mamath = scan.nextInt();
		
		
		if(kor > 100 || kor < 0) {
			System.out.println("오류");
		}
		
		if(eng > 100 || eng < 0) {
			System.out.println("오류");
		}

		if(mamath > 100 || mamath < 0) {
			System.out.println("오류");
		}
		
		double total = kor + eng + mamath ;
		double average = total / 3;
		System.out.println("평균점수 : " + average);
		
		if(average >= 80) {
			System.out.println("결과 : 합격");
		}
		scan.close();
		
	}

}
