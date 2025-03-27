package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Stream01 {

	public static void main(String[] args) {
		/* Stream(스트림)
		 * - 자료구조를 복사하여 스트림 객체로 생성
		 * - 스트림을 이용하여 연산을 수행
		 * - 연산을 수행한 스트림은 소모됨.
		 * - 스트림은 기존 자료를 변경할 수 없음.
		 * - 메서드 체이닝 방식을 사용
		 * - 스트림 만의 연산을 가지고 있음.
		 * - 중간연산 / 최종연산
		 * - 중간연산 : 메서드를 이여서 사용가능. 
		 * 	 - filter() : 조건에 맞는 값만 다음 메서드로 넘김
		 *   - distinct() : 중복제거 
		 *   - limit() : 스트림의 일부를 잘라냄
		 *   - sorted() : 정렬
		 *   - map() : 스트림 종류를 변경
		 *   - peek():작업수행, - skip(): 스트림 일부를 건너뜀 ....
		 * 
		 * - 최종연산 : 반드시 마지막에 하나만.
		 *   - forEach(), count(), sum(), average(), max(), min()
		 *   - allMatch() : 스트림요소가 모두 일치하는지
		 *   - anyMatch() : 하나라도 일치하는지
		 *   - toArray() : 배열로 변환
		 *   - toList() : 리스트로 변환
		 *   - collect() : 스트림 수집
		 * */
		
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("--스트림을 이용한 합계구하기--");
		//배열을 스트림으로 구성
		int hap = Arrays.stream(arr).sum();
		System.out.println(hap);
		
		long count = Arrays.stream(arr).count();
		System.out.println(count);
		
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg);
		
		// 5이상만 합계
		int hap5 = 
				Arrays.stream(arr)
				.filter(n -> n>=5)
				.sum();
		System.out.println(hap5);
		
		// 점수 배열을 생성 한 후 70점 이상만 필터하여 합계, 평균
		// 가장 높은 점수를 출력
		
		int[] arr2 = {72,85,96,85,71,25,36,45,59,62};
		
		int s = Arrays.stream(arr2).filter(n->n>=70).sum();
		System.out.println("합계:"+s);
		OptionalDouble a = Arrays.stream(arr2).filter(n-> n>=70).average();
		System.out.println("평균:"+a);
		
		OptionalInt max= Arrays.stream(arr2).max();
		System.out.println(max);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(6);
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
		
		// list를 스트림으로 구성
		list.stream()
			.forEach(n-> System.out.print(n+" "));
		System.out.println();
		
		// 중복제거 distinct()
		list.stream()
			.distinct()
			.forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		// 정렬 sorted()
		list.stream()
			.sorted()
			.distinct()
			.forEach(n->System.out.print(n+" "));
		
		// 중복제거 후 합계(int만 가능)
		// map : 스트림 변경 (Integer -> int)
		list.stream()
			.distinct()
			.mapToInt(n->n.intValue())
			.sum();
		
		System.out.println();
		// 스트림 객체 생성
		Stream<Integer> stream01 = Stream.of(10,20,30,40,50);
		
		System.out.println("-- 스트림의 합계 --");
		int tot = stream01
				.mapToInt(n->n.intValue())
				.sum();
		System.out.println(tot);
	
		// 이미 스트림이 다 소모됨. 사용불가.
//		OptionalDouble avg2 = stream01
//				.mapToInt(n->n.intValue())
//				.average();
//		
//		System.out.println(avg2);
		

	}

}
