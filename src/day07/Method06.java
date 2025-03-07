package day07;

public class Method06 {
	
	/* 랜덤(0~100) 정수 5개를 담는 배열을 생성하여 리턴하는 메서드
	 * 매개변수 : 없음.
	 * 리턴타입 : 정수배열 => int[]
	 * */
	public static int[] makeRandom() {
		int arr[] = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*100);
		}
		return arr;
	}
	
	/* 그 배열을 입력 받아서 평균을 리턴하는 메서드
	 * 매개변수 : 정수배열 => int[] arr
	 * 리턴타입 : 평균 => double
	 * */
	public static double average(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double)sum/arr.length;
	}
	
	/* 배열을 출력, 평균을 출력하는 메서드
	 * 리턴타입 : 출력 => void
	 * 매개변수 : 두가지 케이스 가능. (배열, 평균을 받는 케이스) (안받는 케이스)
	 * */
	public static void arrayPrint(int[] arr, double avg) {
		for (int i = 0; i < arr.length; i++) {
 				System.out.println(arr[i]+" ");
			}
		System.out.println();
		System.out.println("--------------");
		System.out.println("평균:"+avg);
	}
		
	public static void arrayPrint() {
		// 매개변수 안받는 케이스
		int arr[] = makeRandom();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
		double avg = average(arr);
		System.out.println("평균:"+avg);
	}

	public static void main(String[] args) {
		// 메서드에서의 배열활용
		/* 1. 랜덤(0~100) 정수 5개를 담는 배열을 생성하여 리턴하는 메서드
		 * 2. 그 배열을 입력 받아서 평균을 리턴하는 메서드
		 * 3. 1번에서 만들 배열을 출력하고, 
		 *    2번에서 만들 평균을 출력하는 메서드
		 *    main에서는 메서드 호출만 하기.
		 * */
		int arr[] = makeRandom(); // 랜덤 배열 생성
		double avg = average(arr); // arr의 평균
		
		arrayPrint(arr, avg);
		
		System.out.println("--다른 케이스--");
		
		arrayPrint();

	}

}
