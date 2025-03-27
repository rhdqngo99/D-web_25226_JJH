package day15;

import java.util.ArrayList;
import java.util.Comparator;

public class Steam03 {

	public static void main(String[] args) {
		// Student class List 생성
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("홍길동",56));
		list.add(new Student("김순이",89));
		list.add(new Student("이영이",78));
		list.add(new Student("박순철",51));
		list.add(new Student("이철수",53));
		list.add(new Student("홍순이",89));
		list.add(new Student("박길동",97));
		list.add(new Student("최수지",73));
		
		// 스트림을 이용하여 출력 => 홍길동 : 56
		// toString 사용
		list.stream().forEach(l->System.out.println(l));
		
		System.out.println("----------");
		
		//toString 미사용
		list.stream()
			.forEach(l -> {
				String name = l.getName();
				int score = l.getScore();
				System.out.println(name+":"+score);
			});
		
		System.out.println("-------");
		// list의 점수 합계 
		int sum = list.stream()
				.mapToInt(n -> n.getScore())
				.sum();
		System.out.println(sum);
		
		
		// list의 인원수
		long count = list.stream().count();
		System.out.println(count);
		
		// 정렬 : 이름을 가나다라 순으로 정렬 (오름차순)
		list.stream()
			.sorted(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			})
			.forEach(n -> System.out.println(n));
		
		System.out.println("-----------");
		// 정렬 : 점수가 높은 순으로 정렬 (점수 기준 내림차순)
		list.stream()
			.sorted(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o2.getScore() - o1.getScore();
				}
			})
			.forEach(n -> System.out.println(n));
		
		System.out.println("---Comparable 구현------");
		// Comparable<Student> 클래스에서 구현한 정렬
		list.stream().sorted().forEach(n -> System.out.println(n));

	}

}
