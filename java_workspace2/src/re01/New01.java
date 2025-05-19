package re01;

public class New01 {

	public static void main(String[] args) {
		// 홍길동 주민등록번호 : 881122-1234567
		// 출력형태 => 
		// 생년월일 : 881122
		// 성별 : 남
		
		String pin = "881122-1234567";
		String birth = pin.substring(0, pin.indexOf("-"));
		System.out.println("생년월일:"+ birth);
		
//		String ch = pin.substring(pin.indexOf("-")+1,pin.indexOf("-")+2);
		char ch = pin.charAt(pin.indexOf("-")+1);
		System.out.println(ch);
		if(ch == '1' || ch == '3') {  // ch.equals("1") 
			System.out.println("성별:남");
		}else {
			System.out.println("성별:여");
		}
		
		System.out.println((ch=='1'||ch=='3')? "남" : "여");

	} // main

} // class
