package day17;

import java.io.File;

public class File05 {

	public static void main(String[] args) {
		// File 객체 : 경로+파일명+확장자
		// D:\web_0226_omr\memo\test.txt
		// 파일 구분자 \ => 운영체제마다 다름. (윈도우, 맥, linux, unix)
		// 윈도우 \\ (/ \)
		// File.separator : 파일 구분자 생성
		// 한국 데이터 포털 : www.data.go.kr  => csv, xml, json(가장 많이 사용)
		
		File f = new File("D:\\web_0226_omr\\memo\\test.txt");
		System.out.println(File.separator);
		String name = f.getName();
		System.out.println(name); // 파일명.확장자
		System.out.println(f.getPath()); // 경로+파일명+확장자
		System.out.println(f.getParent()); //경로만
		
		System.out.println(f.toString()); // String 변환
		String f2 = f.toString();
		String fileName = f2.substring(f2.lastIndexOf(File.separator)+1);
		System.out.println(fileName);
	}

}
