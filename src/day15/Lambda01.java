package day15;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda01 {

	public static void main(String[] args) {
		// Lambda + Stream : 람다식 (식을 단순하게 표현하는 방법)
		
		/* lambda : 외부 자료의 부수적인 영향(side effect) 을 주지 않도록
		 * 구현하는 방식
		 * stream : 자료의 대상과 상관없이 동일한 연산을 수행할 수 있도록
		 * 해주는 반복자
		 * - 메서드 체이닝 기법을 사용
		 * 
		 * lambda functions : 람다 함수 => 익명클래스를 사용하여 쓰는 함수
		 * 람다의 장점 : 코드 간결성, 병렬처리 가능, 불필요한 연산 최소화
		 * 단점 : 가독성이 떨어짐. 반복문 사용시 성능 저하
		 * 
		 * - 람다 표현식
		 * (매개변수) -> { 구현; }
		 * 매개변수가 1개면 () 생략가능.
		 * a -> { return a+1;}
		 * (a,b) => {return a+b;}
		 * 
		 * return이 없는 경우 -> { } 생략가능
		 * (a,b) -> a+b;
		 * x -> return x+1;  // 오류
		 * 
		 * */
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		
		for(Integer t : list) {
			System.out.print(t+" ");
		}
		System.out.println();
		
		// -- 람다식 표현
		list.forEach(n -> {
			System.out.print(n+" ");
		});
		
		
		Consumer<Integer> method1 = (n) -> {
			System.out.print(n+" ");
		};
		
		System.out.println();
		System.out.println("Consumer를 활용한 출력");
		list.forEach(method1);

	}

}