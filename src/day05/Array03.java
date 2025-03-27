package day05;

import java.text.DecimalFormat;

public class Array03 {

	public static void main(String[] args) {
		// arr배열의 합계와 평균을 출력
		// 최대값 / 최소값 출력
		int arr[] = {56,89,78,54,84,62,95,30,59,67,91};
//		int sum = 0;
//		int max = arr[0];
// 		int min = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			sum = sum + arr[i];
//			if(arr[i] > max) {
//				max = arr[i];
//			}
//			if(arr[i] < min) {
//				min = arr[i];
//			}
//		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		System.out.println("합계 : "+sum);
//		System.out.println("평균 : "+(sum/(double)arr.length));
//		System.out.println("최대값 : " + max + ", 최소값 :" + min);
		
		// 정수의 형식을 변경(#, 0)
				DecimalFormat df = new DecimalFormat("#.00");
				
				int sum=0, max=0, min=1000;
				//max : 가장 큰값을 저장 / min : 가장 작은값을 저장
				for(int i=0; i<arr.length; i++) {
					sum += arr[i];
//					max = Math.max(max, arr[i]);
//					min = Math.min(min, arr[i]);
					if(max < arr[i]) {
						max = arr[i];
					}
					if(min > arr[i]) {
						min = arr[i];
					}
				}
				float avg = sum/(float)arr.length;
				System.out.println("sum:"+sum);
				System.out.println("avg:"+df.format(avg));
				System.out.println("max:"+max);
				System.out.println("min:"+min);
		
	}

}
