package day16;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamEx01 {

	public static void main(String[] args) {
		/* 여행사 상품
		 * 여행비용이 15세 이상은 100만원, 15세 미만은 50만원으로 계산
		 * 
		 * 고객 5명이 패키지 여행을 떠난다고 했을 경우
		 * 1. 비용을 계산 => 출력
		 * 2. 고객명단 출력
		 * 
		 * 고객(Customer) 클래스 생성 ArrayList로 관리
		 * 
		 * 예)
		 * 이름:홍길동  나이:40  비용:100
		 * 이름:이순신  나이:40  비용:100
		 * 이름:김순길  나이:20  비용:100
		 * 이름:홍순찬  나이:15  비용:100
		 * 이름:홍수미  나이:10  비용:50
		 * 총 여행경비 : 000
		 * 
		 * 3. 20세 이상의 고객 명단 => 이름순으로 정렬
		 * 이름:김순길  나이:20  비용:100
		 * 이름:이순신  나이:40  비용:100
		 * 이름:홍길동  나이:40  비용:100
		 * */
		
		ArrayList<Customer> list = new ArrayList<>();
		list.add(new Customer("홍길동", 40));
		list.add(new Customer("이순신", 40));
		list.add(new Customer("김순길", 20));
		list.add(new Customer("홍순찬", 15));
		list.add(new Customer("홍수미", 10));
		
		list.stream().forEach(n->{
			System.out.println(n);
		});
		int total = list.stream()
				.mapToInt(n->n.getPrice())
				.sum();
		System.out.println("총 여행경비:"+total);
		
		System.out.println("--20살이상 이름으로 정렬--");
		list.stream()
			.filter(n->n.getAge()>=20)
			.sorted(new Comparator<Customer>() {

				@Override
				public int compare(Customer o1, Customer o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			})
			.forEach(s -> System.out.println(s));
	}

}
