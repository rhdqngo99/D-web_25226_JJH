package re01;

import java.util.ArrayList;
import java.util.HashMap;

public class New03 {

	public static void main(String[] args) {
		// 컬랙션 프레임워크
		/* List : 순서를 보장, 중복 저장 가능 => index 있음. 
		 * Set : 순서보장X, 중복X
		 * Map : 데이터를 쌍으로 저장 key:value 중복X, 순서보장X
		 * value(중복 가능) : key가 같으면 value의 값을 덮어씀
		 * */
		
		// 리스트를 생성하고, 1~10까지 등록한 후 출력
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		for(Integer tmp : list) {
			System.out.println(tmp);
		}
		
		//map을 이용하여 이름:점수 형태로 3명을 입력하고, 출력
		HashMap<String,Integer> map = new HashMap<>();
		map.put("kim", 89);
		map.put("lee", 78);
		map.put("hong", 98);
		
		System.out.println(map);
		
		// key:value
		for(String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}

	} // main

} // class
