package day04;

public class String01 {

	public static void main(String[] args) {
		/* String class : 문자열을 다루기 위한 클래스 => 기본 자료형 X
		 * class : 해당 클래스 안에 여러가지 기능을 담고 있음.
		 * class : 클래스명 객체명 = new 클래스명();
		 * String str = new String();
		 * */
		
//		String str = new String(); // 클래스 기본 사용법
//		str = "456789";
//		System.out.println(str);
		String str2 = "123 456";  // 일반 자료형처럼 사용
		System.out.println(str2);
		
		// str == str2; // 각 객체의 주소가 같은지 물어보는 것과 동일
		//String은 배열처럼 작용 
		
		//length : 전체 글자수 (글자의 길이)
		System.out.println("--length--");
		System.out.println(str2.length());
		
		//charAt(index) : index번지에 있는 문자 반환 char
		System.out.println("--charAt()--");
		System.out.println(str2.charAt(0));
		
		//subString : 문자열 추출
		System.out.println("--subString()--");
		System.out.println(str2.substring(2)); //2번지부터 끝까지
		System.out.println(str2.substring(2, 5)); //endIndex는 미포함
		
		//str.compareTo(str2) : str, str2를 비교하여 
		// 사전순으로 앞이면 -1, 같으면 0, 뒤면 1 //문자 정렬시 사용
		System.out.println("--compareTo--");
		System.out.println("b".compareTo("b"));
		System.out.println("apple".compareTo("banana"));
		
		//equals() : 두 문자가 같은지 비교(대소문자구분) 
		//같으면 true / 다르면 false
		// 참조자료형 == 로 비교하면 주소가 같은지 비교  (값이 같은지 == 비교안됨)
		System.out.println("--equals()--");
		System.out.println("abc".equals("abc")); //true
		System.out.println("hello".equals("java")); //false
		
		//indexOf() : 문자의 위치(index)를 찾아주는 기능. 
		// 찾는 문자가 없으면 -1을 리턴
		System.out.println("--indexOf--");
		System.out.println("helloWorld!!".indexOf("W")); //5
		System.out.println("helloWorld!!".indexOf("o")); //처음 만나는 위치
		System.out.println("helloWorld!!".indexOf("a")); //-1
		System.out.println("HelloWorld!!".lastIndexOf("o")); //뒤에서 부터
		
		//subString(start, end), indexOf(문자)를 사용하여 id를 추출
		String email = "ab12@naver.com";
		System.out.println(email.substring(0, 8)); //abc12345
		int e = email.indexOf("@");
		System.out.println(e);
		System.out.println(email.substring(0, e));
		System.out.println(email.substring(0, email.indexOf("@")));
		
		// 주민등록 번호의 생년월일만 추출
		String regNum = "990101-1234567"; 
		System.out.println(regNum.substring(0, regNum.indexOf("-")));
		
		//contains : 해당 문자를 포함하는지 체크
		System.out.println("--contains--");
		String file = "HelloWorldjava.html";
		System.out.println(file.contains("java"));
		
		//concat : 이어붙이기 (+ 연결연산자와 같은 의미)
		System.out.println("--concat--");
		System.out.println("abc".concat("def"));
		System.out.println("abc"+"def");
		
	}

}
