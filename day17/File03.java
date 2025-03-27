package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File03 {

	public static void main(String[] args) throws IOException {
		// 파일 읽기
		/* 보조 스트림 사용. BufferedReader (FileReader)
		 * 라인 단위로 읽기 가능.
		 * 더이상 읽을 라인이 없다면 (null을 리턴) 그만.
		 * 보조스트림은 직접 읽고 쓰는 기능이 없기 때문에
		 * 기반스트림을 매개변수로 포함해야 함.
		 * */
		BufferedReader br = new BufferedReader(
				new FileReader("writer2.txt"));
		
		while(true) {
			String line = br.readLine();  // 한 라인으로 읽어들이기
			if(line == null) {
				break;
			}
			System.out.println(line);
		}
		br.close();

	}

}
