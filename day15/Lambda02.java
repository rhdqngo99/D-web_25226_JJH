package day15;

import java.util.HashMap;

public class Lambda02 {

	public static void main(String[] args) {
		// map을 구성하여 forEach로 출력
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("길동", 89);
		map.put("영이", 78);
		map.put("순이", 59);
		map.put("철수", 53);
		map.put("영철", 69);
		map.put("순자", 95);
		
		map.forEach((x,y)->{
			System.out.println(x+":"+y);
		});
		
		Number sum = (a,b) -> {
			return a+b;
		};
		
//		int hap = sum.add(10, 30);
//		System.out.println(hap);
//		
//		System.out.println(sum.add(50, 60));
		
		Number max = (a,b) -> (a>=b)? a: b; //함수 구현
		
		System.out.println(max.add(5, 3));

	}

}
// 람다 용 함수형 인터페이스 생성
// 메서드는 1개 여야만 함.
@FunctionalInterface
interface Number{
	//메서드 추가
	int add(int a, int b);
//	int add(int a, int b); //메서드가 2개면 error
}


