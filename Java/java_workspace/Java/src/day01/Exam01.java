package day01;

public class Exam01 {

	public static void main(String[] args) {
		/* 카페에 제출
		 * 국어, 영어, 수학 입력
		 * 합계와 평균을 출력
		 * 
		 * 조건선택 연산자를 이용하여
		 * 평균이 80점 이상이면 합격, 아니면 불합격 출력
		 * */
		int kor = 500;
		int eng = 96;
		int math = 96;
		
		int total = kor + eng + math;
		int average = total / 3;
		
		// 정수 / 정수 = 정수
		// 정수 / 실수 = 실수
		 
		System.out.println(total);
		System.out.println(average);
		
		// 삼항연산자 : (조건식) ? true : false;
		String pass = ((average >= 80) ? "합격" : "불합격");
		System.out.println(pass);
		
		
		// if(조건식){실행문;} else {실행문}
		
		if(average >= 80) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		// 80이상이면 합격, 60이상이면 보통, 60미만이면 불합격
		if(average > 100 || average < 0) {
			System.out.println("오류");
		}else if(average >= 80) {
			System.out.println("합격");
		}else if(average >= 60) {
			System.out.println("보통");
		}else {
			System.out.println("불합격");
		}
		
		System.out.println("-------------------");
		if(average > 100 || average < 0) {
			System.out.println("오류");
		}else {
		   if(average >= 80) {
			System.out.println("합격");
		   }else if(average >= 60) {
			System.out.println("보통");
		   }else {
			System.out.println("불합격");
		   }
		}
		
		System.out.println("-------------------");
		
		// 평균이 100보다 크거나, 0보다 작다면 오류 or(||)
		if(average > 100 || average < 0) {
			System.out.println("오류");
		}
		
	}

}
