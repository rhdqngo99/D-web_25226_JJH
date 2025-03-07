package day05;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 숫자배열[10]을 생성 후
		 * 1~10까지 저장 후 출력
		 * */
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		// 배열의 값을 섞는 코드
		// 0 => random 번지 => 교환
		// (int) (Math.random()*10);
		// int tmp = arr[0];
		// arr[0] = arr[random];
		// arr[random] = tmp;
		
		for (int i = 0; i < arr.length; i++) {
			// 교환 번지를 랜덤으로 고름.
			int random = (int) (Math.random()*arr.length);
			int tmp = arr[i];
			arr[i] = arr[random];
			arr[random] = tmp;
		}
		System.out.println("-----------------");
		for(int t : arr) {
			System.out.print(t+" ");
		}
		
		// 섞은 값을 원래대로 정리(정렬)
		// 작은순으로 정렬 => 오름차순
		// 큰순으로 정렬 => 내림차순
		// 5 8 4 2 7 9 6 10 3 1
		// 1 8 5 4 7 9 6 10 3 2 - pass1
		// 1 2 8 5 7 9 6 10 4 3 - pass2
		// 1 2 3 7 8 9 6 10 5 4 - pass3
		// 1 2 3 4 8 9 7 10 6 5 - pass4
		// 1 2 3 4 5 9 8 10 7 6 - pass5
		// 1 2 3 4 5 6 9 10 8 7 - pass6
		// 1 2 3 4 5 6 7 10 9 8 - pass7
		// 1 2 3 4 5 6 7 8 10 9 - pass8
		// 1 2 3 4 5 6 7 8 9 10 - pass9
		
		System.out.println();
		System.out.println("--정렬--");
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) { // > 오름차순 / < 내림차순
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for(int t : arr) {
			System.out.print(t+" ");
		}
		
	}

}
