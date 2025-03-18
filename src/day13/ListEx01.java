package day13;

import java.util.ArrayList;
import java.util.Comparator;

public class ListEx01 {

	public static void main(String[] args) {
		// 두 배열을 합쳐 하나의 list로 생성
		// 정렬해서 출력
		String[] arr1 = new String[] {"c","f","a","d"};
		String[] arr2 = new String[] {"e","b","g","f"};
		
		ArrayList<String> list = new ArrayList<>();
//		int cnt = arr1.length + arr2.length;
//		int i=0,j=0;
//		
//		while(cnt > list.size()) {
//			if(i<arr1.length) {
//				list.add(arr1[i]);
//				i++;
//			}
//			if(j<arr2.length) {
//				list.add(arr2[j]);
//				j++;
//			}
//		}
		
		for(String a : arr1) {
			list.add(a);
		}
		for(String b : arr2) {
			list.add(b);
		}
		
		System.out.println(list);
		
		//정렬
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(list);
		
		
	}

}
