package day14;

import java.util.HashMap;
import java.util.Map;

public class MapEx01 {
	
	public static void main(String[] args) {
		/* 상품과 가격을 추가하여 합계를 구하시오. 
		 * 1. main에 map을 생성하고, 메서드로 데이터를 채우는 형태
		 *    매개변수로 map을 받아 데이터를 채우는 메서드.
		 *    
		 * 2. 메서드 내부에서 map을 생성하여 map을 메인으로 리턴하는 형태
		 * 
		 * 3. map을 받아서 출력하는 메서드 합계도 출력 
		 * 
		 * ex) 연필 500
		 * 가위 1000
		 * 물감 3000
		 * 합계: OOO
		 * */
		
		Map<String, Integer> map = new HashMap<>();
		map.put("연필", 500);
		System.out.println(map);
		MapEx01 ex01 = new MapEx01();
		ex01.makeMap(map);
		System.out.println(map);
		
		Map<String, Integer> map2 = ex01.makeMap2();
		System.out.println(map2);
		ex01.printMap(map);
		System.out.println("---------");
		ex01.printMap(map2);
		
	}
	
	//매개변수로 map을 받아 데이터를 채우는 메서드.
	public void makeMap(Map<String,Integer> map) {
		map.put("지우개", 500);
		map.put("크래파스", 3000);
		map.put("물감", 3000);
	}
	
	// 메서드 내부에서 map을 생성하여 map을 메인으로 리턴하는 형태
	public Map<String, Integer> makeMap2(){
		Map<String, Integer> map = new HashMap<>();
		map.put("사과", 2000);
		map.put("바나나", 3000);
		return map;
	}
	
	// map을 받아서 출력하는 메서드 합계도 출력
	public void printMap(Map<String,Integer> map) {
		int sum = 0;
		for(String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
			sum += map.get(key);
		}
		System.out.println("총합:"+sum);
	}
	
}
