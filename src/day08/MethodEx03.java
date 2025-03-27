package day08;

// import java.util.Scanner;

public class MethodEx03 {

	public static void main(String[] args) {
//		/* 로또번호 생성
//		 * 1~45 까지 증 6게 번호 생성
//		 * 당첨번호와 사용자 번호 비교 등수 추출
//		 * 6개 모두 일치 : 1등
//		 * 5개 일치 + 보너스 : 2등
//		 * 5개 일치 : 3등
//		 * 4개 일치 : 4등
//		 * 3개 일치 : 5등
//		 * 나머지 꽝
//		 * */
//		Scanner scan = new Scanner(System.in);
//		int lotto[] = new int[6]; // 당첨번호
//		int user[] = new int[6]; //사용자 로또 번호
//		createArray(lotto);
//		int bonus = lotto[1];
//		
//		System.out.println("번호 6개 입력 : ");
//		for (int i = 0; i < user.length; i++) {
//			user[i] = scan.nextInt();
//		}
//		int count = count(lotto, user);
//		int rank = ranking(count, user, bonus, lotto);
//		
//		System.out.println("당첨번호: ");
//		arr(lotto);
//		System.out.println("보너스: " + bonus);
//		System.out.println("내 번호: ");
//        arr(user);
//        System.out.println("당첨 등수: " + rank + "등");
//		
//		scan.close();
//	}
//	
//	/* 랜덤 배열 채우기 (1~45)까지
//	 * 배열을 받아서 랜덤 수를 채우는 메서드
//	 * */
//	public static void createArray(int arr[]) {
//		// while 사용
//		int cnt = 0; 
//		while(cnt < arr.length -1) {
//			int r = (int)(Math.random()*45)+1;
//			if(!isContain(arr, r)) {
//				arr[cnt] = r;
//				cnt++;
//			}
//		}
//		int bonus = (int)(Math.random()*45)+1;
//		while(isContain(arr, bonus)) {
//			bonus = (int)(Math.random()*45)+1;
//		}
//		arr[arr.length - 1] = bonus;
//	}
//	
//	/* 중복 확인 메서드
//	 * 배열과, 랜덤값을 입력 받아
//	 * 배열에 랜덤값이 존재하면 true / 없으면 false를 리턴
//	 * */
//	public static boolean isContain(int arr[], int random) {
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i] == random) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	/* 배열 출력 메서드
//	 * user : 1 2 3 4 5 6
//	 * 당첨 : 1 2 3 4 5 6 [7]
//	 * */
//	public static void arr(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//	   public static int count(int[] lotto, int[] user) {
//	        int count = 0;
//	        for (int i = 0; i < user.length; i++) {
//	            for (int j = 0; j < lotto.length; j++) {
//	                if (user[i] == lotto[j]) {
//	                    count++;
//	                }
//	            }
//	        }
//	        return count;
//	    }
//	
//	/* 등수 확인 메서드
//	 * 당첨번호와 사용자 번호 비교 등수 추출
//	 * 6개 모두 일치 : 1등
//	 * 5개 일치 + 보너스 : 2등
//	 * 5개 일치 : 3등
//	 * 4개 일치 : 4등
//	 * 3개 일치 : 5등
//	 * 나머지 꽝
//	* */
//	public static int ranking(int count, int user[], int bonus, int lotto[]) {
//		if (count == 6) {
//			return 1;
//		}else if(count == 5) {
//			for (int i = 0; i < user.length; i++) {
//				if (user[i] == bonus) {
//					return 2;
//				}
//			}
//			return 3;
//		}else if(count == 4){
//			return 4;
//		}else if(count == 3) {
//			return 5;
//		}else {
//			return 0;
//		}
	
		/* 로또번호 생성
		 * 1~45 까지 중 6개 번호 생성
		 * 당첨번호와 사용자번호 비교 등수 추출
		 * 6개 일치 : 1등
		 * 5개 일치 + 보너스 : 2등
		 * 5개 일치 : 3등
		 * 4개 일치 : 4등
		 * 3개 일치 : 5등
		 * 나머지 꽝
		 * */
		int lotto[] = new int[7]; // 당첨번호
		int user[] = new int[6]; //사용자 로또 번호
		int start = 1, end = 10;
		randomArray(lotto, start, end); // 당첨번호 채우기
		randomArray(user, start, end); // 사용자 번호 채우기
		System.out.println("--당첨번호--");
		printArray(lotto);
		System.out.println("--사용자번호--");
		printArray(user);
		
		int rank = lottoRank(lotto, user); // 등수 리턴
		if(rank == -111) {
			System.out.println("배열오류~!!");
		}else {
			if(rank == -1) {
				System.out.println("꽝~!!");
			}else {
				System.out.println(rank+"등 당첨!!");
			}
		}
		
		
	}
	
	/* 랜덤 배열 채우기 (1~45)까지
	 * 배열을 받아서 랜덤 수를 채우는 메서드 (중복 불가능)
	 * 매개변수 : 배열 => int arr[]
	 * 리턴타입 : void
	 * 메서드명 : randomArray
	 * */
	public static void randomArray(int arr[], int start, int end) {
		int cnt = 0;
		while(cnt < arr.length) {
			int r = random(start, end);
			if(!isContains(arr, r)) {
				arr[cnt]= r;
				cnt++;
			}
		}
	}
	
	/* 원하는 범위만큼 랜덤수를 추출해주는 메서드
	 * (int)(Math.random()*갯수)+시작값;
	 * 1~10 51~100
	 * start ~ end 
	 * 갯수 => (end - start + 1)
	 * (int)(Math.random()*(end-start+1))+start;
	 * */
	public static int random(int start, int end) {
		return (int)(Math.random()*(end-start+1))+start;
	}
	
	/* 중복 확인 메서드
	 * 배열과, 랜덤값을 입력받아 
	 * 배열에 랜덤값이 존재하면 true / 없으면 false를 리턴
	 * 매개변수 : 배열, 랜덤값 => int arr[], int random
	 * 리턴타입 : boolean
	 * */
	public static boolean isContains(int arr[], int random) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == random) {
				return true;
			}
		}
		return false;
	}
	
	/* 배열 출력 메서드
	 * user : 1 2 3 4 5 6
	 * 당첨 : 1 2 3 4 5 6 [7]
	 * 리턴타입 : 출력 => void
	 * 매개변수 : 배열 => int arr[]
	 * */
	public static void printArray(int arr[]) {
		for(int i=0; i<6; i++) {
			System.out.print(arr[i]+" ");
		}
		if(arr.length == 7) {
			System.out.print("["+arr[arr.length-1]+"]");
		}
		System.out.println();
	}
	
	/* 등수 확인 메서드
	 * 당첨번호와 사용자번호 비교 등수 추출
	 * 6개 일치 : 1등
	 * 5개 일치 + 보너스 : 2등
	 * 5개 일치 : 3등
	 * 4개 일치 : 4등
	 * 3개 일치 : 5등
	 * 나머지 꽝
	 * 리턴타입 : 일치갯수 리턴 => int
	 * 매개변수 : 당첨번호, 사용자번호 => int lotto[], int user[]
	 * */
	public static int lottoRank(int lotto[], int user[]) {
		// lotto / user 배열의 위치가 바뀌어서 들어온다면...
		if(lotto.length <= user.length) {
			return -111;
		}
		int cnt=0; //일치 갯수 카운트 (보너스는 제외)
		for(int i=0; i<user.length; i++) { //(보너스는 제외)
			if(isContains(user, lotto[i])) {
				cnt++;
			}
		}
		
		int b = lotto[lotto.length-1]; //보너스 번호 추출
		
		switch(cnt) {
		case 6: return 1;
		case 5: // 보너스 번호의 일치여부 확인
			if(isContains(user, b)) {
				return 2;
			}else {
				return 3;
			}
		case 4: return 4; 
		case 3: return 5; 
		default:
			return -1;
		}
	
	}
	
}

