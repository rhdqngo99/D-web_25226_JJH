package day17;

import java.io.IOException;

public class File01 {

	public static void main(String[] args) {
		// file: java.io.* 에서 제공하는 클래스들은 
		// 대부분 try~catch/ throws를 해줘야 함.
		/* java는 입력스트림, 출력스트림을 통해 데이터를 입출력함. 
		 * inputStream / outputStream(IOStream) : 단방향으로 데이터가 흘러가는 형태
		 * 다양한 장치에 독립적으로 운영, 일관성있게 입출력을 유지하기 위해 사용.
		 * 
		 * - 데이터 형태 => 바이트 / 문자 스트림
		 * - 바이트 : 그림, 영상, 실행파일
		 * - 문자 : 문자를 입출력할 때 사용
		 * 
		 * 바이트 : (입력) FileInputStream, BufferedInputStream,...
		 * 		   (출력) FileOutputStream, BufferedOutputStream 등...
		 * 문자 : Encoding 처리를 해줌.
		 *  - (입력) : FileReader, BufferedReader, InputStreamReader ...
		 *  - (출력) : FileWriter, BufferedWriter, PrintWriter...
		 *  
		 *  기반 스트림 / 보조스트림
		 *  기반스트림 : 직접 읽고 쓰는 기능이 있는 스트림
		 *   - FileInputStream, FileOutputStream, FileReader, FileWriter
		 *  보조 스트림 : 읽고 쓰는 기능이 없고, 추가적인 기능을 더해주기 위한 스트림
		 *   - Buffered ~
		 *  
		 * */
		
		// 표준 출력(모니터 = 콘솔) 스트림
		System.out.println("print");
		
		// 표준 에러 출력 스트림
		System.err.println("error");

		// 표준 입력(키보드) 스트림
		// 바이트 단위 스트림
		try {
			int b=0;
			while((b= System.in.read()) != '\n') { //enter 가 아니라면...
				System.out.print((char)b); // char 형태로 읽어들임	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

