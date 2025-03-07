package day04;

public class StringEx01 {

	public static void main(String[] args) {
		// regNum의 주민등록번호를 참고하여
		// 생년월일과 성별을 출력
		
		String regNum = "020101-3234567";  //1=남 / 2=여
		String regNum1 = "020101-4567896"; //3=남 / 4=여	
		
		String regDate = regNum.substring(0, regNum.indexOf("-"));
		System.out.println("생년월일:"+regDate);
		
		String num = regNum.substring(7,8); //equals
//		String num = regNum.substring(regNum.indexOf("-")+1, regNum.indexOf("-")+2);
		System.out.println(num);
		
//		char chNum = regNum.charAt(7);  // ==
//		System.out.println(chNum);
		
		if(num.equals("1") || num.equals("3")) {
			System.out.println("성별:남");
		}else {
			System.out.println("성별:여");
		}

	}

}
