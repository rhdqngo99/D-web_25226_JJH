package day12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		// LocalDateTime 클래스
		LocalDateTime today = LocalDateTime.now(); //오늘날짜 리턴
		System.out.println(today);
		System.out.println(today.getYear());
		
		// 객체를 String으로 변환
		String date = today.toString();
		System.out.println(date);
		
		//substring 사용하여
		// 날짜 2025-03-14 / 시간 15:28:19 으로 분리하여 출력
		String date1 = date.substring(0, date.indexOf("T"));
		System.out.println(date1);
		String time = date.substring(date.indexOf("T")+1, date.indexOf("."));
		System.out.println(date1+" / "+time);
		
		System.out.println();
		DateTimeFormatter dtf = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));
		
		LocalDateTime birth = 
				LocalDateTime.of(2009, 9,30, 8, 30); //날짜 생성
		System.out.println(dtf.format(birth));
		
		
		LocalDate t = LocalDate.now();
		System.out.println(t);
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
	}

}
