package day12;

import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/* 날짜시간 클래스 
		 * Date 클래스 => Depercated(비권장) / Calendar 클래스 / LocalDateTime 클래스
		 * Calendar : 추상클래스 => 객체를 생성할 수 없음.
		 * new 키워드로 객체를 생성할 수 없음.
		 * 싱글턴 패턴 
		 * getInstance() 메서드를 이용하여 객체를 얻어옴.
		 * */
		
		Date d = new Date(); 
		System.out.println(d);
		System.out.println(d.getDate());
		//d.getDate();
		
		//Calendar rightNow = Calendar.getInstance();
		
		Calendar c = Calendar.getInstance(); //오늘날짜 리턴
		System.out.println(c);
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		// 월 0~11 로 표현 +1
		System.out.println(c.get(Calendar.MONTH)+1);
		// 일
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		//요일 1(일)~ 7(토)
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		
		// 2025-03-14(금)
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		String weekString = null;
		switch(week) {
		case 1: weekString="일"; break;
		case 2: weekString="월"; break;
		case 3: weekString="화"; break;
		case 4: weekString="수"; break;
		case 5: weekString="목"; break;
		case 6: weekString="금"; break;
		case 7: weekString="토"; break;
		default: break;
		}
		
		System.out.println(year+"-"+month+"-"+day+"("+weekString+")");
		
		System.out.println();
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int ampm = c.get(Calendar.AM_PM);
		System.out.println((ampm==0? "오전":"오후")+" "+
				hour+":"+minute+":"+second);
		
	}

}
