package day05;

import java.text.DecimalFormat;

public class Array04 {

	public static void main(String[] args) {
		/* 10개의 값을 가지는 배열을 생성
		 * 1~50까지의 랜덤 수를 배열에 저장 => 출력
		 * 합계, 평균, 최대, 최소 출력
		 * */ 
		DecimalFormat df = new DecimalFormat("#.00");
//		int arr[] = new int[10];
//		int sum = 0;
//		int max = arr[0];
// 		int min = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) ((Math.random()*50)+1);
//			sum += arr[i];
//			if(max < arr[i]) {
//				max = arr[i];
//			}else if(min > arr[i]){
//				min = arr[i];
//			}
//		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]); 
//		}
//		System.out.println("합계 : "+sum);
//		System.out.println("평균 : "+(sum/(double)arr.length));
//		System.out.println("최대값 : " + max + ", 최소값 :" + min);
		
		// 1. 배열 생성
		int arr[] = new int[10];
		
		//2. 배열에 랜덤값 저장 => 10개
		//3. 합계, 평균, 최대, 최소 구하기
		int sum=0, max = 0, min=99;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) ((Math.random()*50)+1);
			sum += arr[i];
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		//4. 출력
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}
		System.out.println();
		System.out.println("sum:"+ sum +"/avg:"+(sum/arr.length));
		System.out.println("max:"+max+"/min:"+min);
		
		df.clone();

	}

}
