package day13;

import java.util.ArrayList;
import java.util.List;

public class Collection01 {

	public static void main(String[] args) {
		
		/* 컬렉션 프레임워크 : 표준화된 방식의 자료구조
		 * List, Set, Map => 인터페이스. 반드시 구현 클래스로 객체를 생성
		 * 데이터를 묶어서 관리할 때 사용
		 * 주로 배열대신 사용
		 * 
		 * List(배열과 동일)
		 * - 값을 하나씩 저장
		 * - 순서를 보장 (index)
		 * - 중복허용
		 * - 배열대신에 가장 많이 사용하는 구조
		 * 
		 * Set
		 * - 값을 하나씩 저장
		 * - 순서를 보장하지 않음(index가 없음)
		 * - 중복을 허용하지 않음. (같은 자료가 입력되면 덮어쓰기)
		 * 
		 * Map
		 * - 값을 두개씩 저장 key/value 쌍으로 묶어서 저장
		 * - 순서를 보장하지 않음(index가 없음)
		 * - key 중복 불가능 / value 중복 가능.
		 * - key가 중복되면 덮어쓰기 (value도 같이 덮어쓰기 됨)
		 * - 물건명/가격  아이디/패스워드  학생명/성적 
		 * - 두 값을 하나의 자료로 묶어서 사용해야 할 때 map을 씀.
		 * 
		 * 
		 * 배열은 기본자료형, 클래스 자료형의 배열도 가능. (여러가지 구성이 가능)
		 * - int arr[], String arr[], Student arr[]
		 * 
		 * Collection에서는 기본자료형은 불가능. 클래스 자료형만 가능.
		 * 기본자료형에 맞는 클래스 자료형(Wrapper Class)을 사용하면 됨. 
		 * 
		 * Wrapper Class(래퍼클래스)
		 * 기본타입에 대응되는 클래스 타입을 래퍼 클래스라고 함. 
		 * 기본타입		래퍼클래스
		 * int			Integer
		 * char			Character
		 * double		Double
		 * long			Long
		 * byte			Byte
		 * boolean		Boolean
		 * 
		 * int, char 를 제외한 다른 자료형은 
		 * 본인 자료형에 첫글자만 대문자로 변경 
		 * 
		 * 기본타입 => 클래스타입 (박싱 : Boxing)
		 * 클래스타입 => 기본타입 (언박싱 : UnBoxing)
		 * 
		 * - 언박싱 이유
		 * - 래퍼 클래스는 산술 연산을 위해 정의된 클래스가 아님. 
		 * - 객체의 값만 참조할 수 있기 때문에 그 안의 저장된 값은 
		 *   직접 변경이 불가능함.
		 * - 그래서 래퍼 클래스로 언박싱 한 뒤 값을 변경한 후 다시
		 *   박싱 해야함.
		 *   
		 * List<클래스명> 객체명 = new 구현클래스<클래스명>();
		 * List => 구현 클래스 ArrayList, LinkedList... 
		 * Set => 구현 클래스 HashSet, TreeSet...
		 * Map => 구현 클래스 HashMap, TreeMap... 
		 * 
		 * */
		
		/* ArrayList : 검색이 빠르다. (배열과 비슷)
		 * - 미리 길이를 지정하지 않음.  
		 * - 추가되면 자동 늘어남.
		 * - 삭제되면 자동 줄어듦.
		 * - 추가, 삭제가 쉽다.(속도는 느림) 검색이 쉽다.(빠름) 
		 *  
		 * LinkedList
		 * - 추가, 삭제가 빠름. 검색이 느림.
		 * */
		//List<클래스명> 객체명 = new 구현클래스<클래스명>();
		
		//부모를 기준으로 자식을 생성
		List<Integer> list = new ArrayList<Integer>();
		
		//자식을 기준으로 자식을 생성
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		// 클래스명을 생략하고 생성
		ArrayList list3 = new ArrayList();  // object 로 생성
		
		// 앞에 클래스는 반드시 지정, 뒷쪽 클래스는 생략가능
		ArrayList<Integer> list4 = new ArrayList<>();
		
	}

}
