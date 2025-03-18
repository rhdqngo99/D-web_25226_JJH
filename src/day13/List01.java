package day13;

import java.util.ArrayList;
import java.util.List;

public class List01 {

	public static void main(String[] args) {
		// List => ArrayList
		// List<클래스명> 객체명 = new 구현클래스<클래스명>();
		List<Integer> list = new ArrayList<Integer>();
		
		//add() : 요소를 추가
		list.add(1); //오토 박싱 : int => Integer 박싱되서 저장
		list.add(new Integer(2)); // 직접 객체 생성 후 저장
		list.add(3);
		System.out.println(list);
		
		// get(index) : index번지의 값을 가져오기
		System.out.println(list.get(0));  // arr[0]  같은 의미
		System.out.println(list.get(1));  // arr[1]  같은 의미
		System.out.println(list.get(2));  // arr[2]  같은 의미
		
		// set(index, 값) : index 번지에 값 변경하기
		list.set(0, 5);
		
		System.out.println("--for문을 이용하여 출력--");
		
		// size() : list의 총 갯수
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// remove(index) : index 번지의 값을 삭제 
		// remove(object) : object 요소를 삭제
		list.remove(0); //0 번지 삭제
		System.out.println(list);
		Integer r = 3; //오토박싱
		list.remove(r);
		System.out.println(list);

		// list1 을 생성하여, 1~10까지 추가하고 출력 (for문 이용)
		
		ArrayList<Integer> list1 = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list1.add(i+1);
		}
		System.out.println(list1);
		
		// index 4에 있는 값을 11로 변경 set
		list1.set(4, 11);
		System.out.println(list1);
		
		// index 0에 있는 요소를 삭제
		list1.remove(0);
		System.out.println(list1);
		list1.remove(r); 
		System.out.println(list1);
		
		//contains(object) : list에 object 값이 있는지 체크
		System.out.println(list1.contains(1));
		
		//clear() : 리스트 비우기 (요소 전부 삭제)
		list1.clear();
		System.out.println(list1);
		
		//isEmpty() : 리스트가 비어있는지 체크 
		System.out.println(list1.isEmpty());
		System.out.println(list.isEmpty());
		
	}

}
