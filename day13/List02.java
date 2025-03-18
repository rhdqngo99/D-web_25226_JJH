package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class List02 {

	public static void main(String[] args) {
		/* List 생성 후 1~10까지 채운 후 출력
		 * */
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		//for 문으로 요소 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----");
		
		//향상된 for문으로 요소 출력
		for(Integer t : list) {  // 오토언박싱 Integer => int
			System.out.println(t);
		}
		
		System.out.println("-----");
		// Iterator : index가 없는 값을 출력하기 위해 사용
		// list는 순서를 보장하지만(index가 있음), set map은 
		// index가 없음. 일반 for문을 사용할 수 없음.
		// 순서와 상관없이 값을 가져올 수 있는 구문을 사용
		// map은 향상된 for, iterator나 직접 사용 불가. 
		
		System.out.println("iterator 출력");
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {  //hasNext() 다음 요소가 있는지 체크
			Integer tmp = it.next(); // next() 다음요소 가져오기
			System.out.println(tmp);
		}
		
		// indexOf(값) : 해당 값의 index 반환 / 없으면 -1
		
		System.out.println(list.indexOf(11));
		
		// Collections.sort(list) // 정렬 => 오름차순만 가능.
		
		list.clear();
		list.add(56);
		list.add(78);
		list.add(12);
		list.add(59);
		list.add(35);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		// list.sort(Comparator를 구현한 객체) : 정렬
		// Comparator 인터페이스를 구현한 구현체를 넣어야 함(익명클래스 사용)
		// compareTo 메서드를 구현하여 객체를 정렬
		// - compareTo : 사전상 앞에 있으면 -1 같으면 0 뒤에 있으면 1
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// o1 - o2 : 오름차순 / o2 - o1 : 내림차순
				// 결과가 -면 앞으로 보내고, +면 뒤로 보내는 역할 
				return o2 - o1;
			}
			
		});
		
		System.out.println(list);

	}

}
