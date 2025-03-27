package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File04 {

	public static void main(String[] args) throws IOException {
		/* test.txt 파일을 읽어들여 map에 저장
		 * 명단 출력 / 합계 / 평균 출력
		 * 점수가 80점 이상인 학생 명단
		 * 
		 * 읽어 들이는 파일은 모두 String 
		 * 점수는 => int => 계산이 가능.
		 * Integer.parseInt()
		 * */
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\web_0226_omr\\memo\\test.txt"));
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int sum = 0;
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
//			System.out.println(line);
			//name, score 분리 String method 로 직접 분리
//			String name = line.substring(0, line.indexOf(" "));
//			int score = Integer.parseInt(
//					line.substring(line.indexOf(" ")+1));
//			map.put(name, score);
//			sum += score;
			
			// 배열로 변환 => 값이 많을경우 유리
			String[] lines = line.split(" ");
			map.put(lines[0], Integer.parseInt(lines[1]));
			sum+=Integer.parseInt(lines[1]);
		}
		
//		System.out.println(map);
		System.out.println("--성적표--");
		for(String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		System.out.println("합계:"+sum+" / 평균:"+((double)sum/map.size()));
		
		System.out.println("------------------------");
		for(String key : map.keySet()) {
			if(map.get(key) >= 80) {
				System.out.println(key+":"+map.get(key));
			}
		}
		br.close();		

	}

}
