package day13;

public class Exception06 {

	public static void main(String[] args) {
		int start = 1, count = -5, size=1;
		
		Exception06 e06 = new Exception06();
		try {
			e06.createArray(size, start, count);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(1+1);

	}
	
	/* size를 입력받아 size 만큼의 길이를 가지는 배열을 생성
	 * 랜덤값을 채워 배열을 리턴
	 * 랜덤값의 범위는 start(시작), count(개수)
	 * - size가 0보다 작으면 예외발생
	 * - count 개수가 0보다 작다면 예외발생
	 * 리턴타입 : 배열 => int[]
	 * 매개변수 : int size, int start, int count
	 * */
	public int[] createArray(int size, int start, int count) {
		if(size <=0 ) {
			throw new RuntimeException("배열의 길이가 0보다 작습니다.");
		}
		if(count <= 0) {
			throw new RuntimeException("random 범위가 0보다 작습니다.");
		}
		
		int arr[] = new int[size];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*count)+start;
		}
		return arr;
			
	}

}
