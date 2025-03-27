package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx01 {

	public static void main(String[] args) {
		/* 숫자를 입력받아서 입력받은 숫자로 list를 구성
		 * 전체 출력 => 전체 합계 출력
		 * 
		 * ex) 입력 > 45,89,78,58,96,85,74,52,36 enter
		 * 각각의 값을 숫자로 변환 후 list에 추가
		 * 그리고 합계를 출력 
		 * - 점수가 70점 이상인 인원 수 : 5명
		 * 
		 * 배열을 List로 변환할 경우
		 * List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		 * */
		Scanner scan = new Scanner(System.in);
//		String num = scan.next();
		
		String num = "45,89,78,58,96,85,74,52,36"; //split(",")
		
		String[] numbers = num.split(",");
		
		List<Integer> list = new ArrayList<>();
		
		for(String n : numbers) {
			list.add(Integer.parseInt(n));
		}
		
		System.out.println(list);
		
		int sum = 0;
		int count = 0;
		for(int n : list) {
			sum += n;
			if(n >= 70) {
				count++;
			}
		}
		
		System.out.println("sum:"+ sum);
		System.out.println("70이상 인원수 : "+count+"명");
		
		scan.close();
		
	}

}
