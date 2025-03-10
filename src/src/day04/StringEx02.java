package day04;

public class StringEx02 {

	public static void main(String[] args) {
		// file 파일명.확장자
		// 파일명과 확장자로 분리하여 출력
		// 확장자가 java면 자바파일 입니다. 출력 (기타파일입니다. 출력)
		
		String file = "자바의정석.java";
		int lastIndex = file.lastIndexOf(".");
		
		String fileName = file.substring(0, lastIndex);
		String str = file.substring(lastIndex + 1);
		
		System.out.println("파일명 : "+ fileName);
		System.out.println("확장자 : " + str);
		
		//equals() : 같은지 확인 == 주소가 같은지 확인.  suffix.equals("java")
		if(str.equals("java")) {
			System.out.println("java 파일입니다");
		}else {
			System.out.println("기타 파일입니다");
		}

	}

}
