package day07;

import java.awt.print.PrinterAbortException;

import javax.print.attribute.standard.PrinterMakeAndModel;

public class MethodEx02 {
	
	// 입력되는 정수 배열을 출력하는 메서드
	/* 리턴타입 : 출력 => void
	 * 매개변수 : 정수배열 => int arr[]
	 * */
	public static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println(); // 줄바꿈
	}
	
	// 입력되는 정수 배열을 오름차순 정렬하는 메서드
	/* 리턴타입 : 정렬만 하는것 => 리턴이 없음. void
	 * 매개변수 : 정수배열 => int arr[]
	 * */
	public static void sortArray(int arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {  //오름차순
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] {2,8,7,4,5,6,9,11,10,3,1,12,13};
		printArray(arr);
		System.out.println("-------------");
		sortArray(arr); // 정렬만
		printArray(arr);
		System.out.println("-------------");
		
		//Method06 에서 makeRandom 만들었던 메서드 호출 => 출력 => 정렬 => 출력
		
		int arr1[] = Method06.makeRandom();
		printArray(arr1);
		sortArray(arr1);
		printArray(arr1);
		
	}

}
