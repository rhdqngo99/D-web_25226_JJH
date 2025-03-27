package day15;

import java.util.Arrays;

public class Stream02 {

	public static void main(String[] args) {
		/* 배열에서 짝수(정렬하여)만 출력
		 * */
		int arr[]= {1,2,5,4,7,8,9,6,3,2,5,4,7,8,9,1,2,3,6};
		// 스트림으로 생성하여, 중복제거하고, 정렬하여, 짝수만 출력
		Arrays.stream(arr)
			.distinct()
			.sorted()
			.filter(n -> n%2==0)
			.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		// 스트림으로 생성하여, 중복제거하고, 정렬하여 홀수만 배열로 리턴
		// toArray() => 배열로 리턴
		int [] result = Arrays.stream(arr)
				.distinct()
				.sorted()
				.filter(n -> n%2==1)
				.toArray();
		
		for(int i : result) {
			System.out.print(i+" ");
		}
		
	}

}
