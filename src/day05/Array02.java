package day05;

import java.util.Scanner;

public class Array02 {

	public static void main(String[] args) {
		/* 5명의 점수를 입력.
		 * 1. 배열을 생성
		 * 2. 배열에 점수 입력 받기
		 * 3. 배열을 출력
		 * 4. 점수의 합계 / 평균
		 * */ 
		
		Scanner scan = new Scanner(System.in);
		System.out.println("5명의 점수 입력");
		int arr[] = new int[5];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			// 합계 누적.
			sum = sum + arr[i]; // sum += arr[i]
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		System.out.println("합계 : "+sum+", 평균 : "+(sum/(double)arr.length));
		
		// 향상된 for문
		// 번지(index)로 접근이 가능한 경우 사용
		// index를 활용한 기능은 할수 없음.
		// 전체 탐색만 가능 (부분탐색 불가능)
		for(int num : arr) {
				System.out.println(num);
			}
		
		scan.close();

	}

}
