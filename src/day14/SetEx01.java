package day14;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx01 {

	public static void main(String[] args) {
		/* Set에 로또번호 6개 생성 후 출력
		 * */
		Set<Integer> set = new HashSet<>();
		
		//set : 중복값이 나오면 버림
		// set이 6개가 찰때까지 random 생성 
		while(set.size() < 6) {
			int random = (int)(Math.random()*45)+1;
			set.add(random);
		}
		System.out.println(set);
		
		System.out.println("------------------");
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		while(treeSet.size() < 6) {
			int random = (int)(Math.random()*45)+1;
			treeSet.add(random);
		}
		
		System.out.println(treeSet);
		
		//first() : 가장 앞에 있는 값 / last() : 가장 뒤에 있는 값
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		
		// headSet()  / tailSet() : 기준값의 앞쪽 / 뒷쪽 값을 출력
		System.out.println(treeSet.headSet(20));
		System.out.println(treeSet.tailSet(20));
		
		// subSet(시작, 끝) : 검색 범위 출력 (시작값은 포함, 끝 값은 미포함)
		System.out.println(treeSet.subSet(10, 20));
		
	}

}

