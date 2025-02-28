package day02;

public class MathClass {

	public static void main(String[] args) {
		// 수학관련 기능이 있는 클래스
		// Math.method
		// Math.round(반올림) / Math.ceil(올림) / Math.floor(버림)
		// 소수 자리수는 무조건 0
		
		double num = 3.14258;
//		long roundNum = Math.round(num);
		int roundNum = (int)Math.round(num);
		System.out.println(roundNum);
		
//		double ceilNum = Math.ceil(num);
		int ceilNum = (int)Math.ceil(num);
		System.out.println(ceilNum);
		
		int floorNum = (int)Math.floor(num);
		System.out.println(floorNum);
		
		System.out.println("------------------------");
		
		//Math.max(최대값) / Math.min (최소값)
		System.out.println(Math.max(3, 5));
		System.out.println(Math.min(6, 1));
		
		System.out.println("------------------------");
		//Math.random() : 0~1 사이의 아무값을 리턴
		// 0 <= Math.random() < 1
		// (int)(Math.random()*count) + start
		
		
		System.out.println((int)(Math.random()*10)+1); //0~9까지의 랜덤수
		System.out.println((int)(Math.random()*6)+1); //1~6까지의 랜덤

	}

}
