package day05;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* 컴퓨터와 가위바위보 게임. 
		 * 컴퓨터는 랜덤으로 가위/바위/보 중 하나를 선택
		 * (0=가위 / 1= 바위 / 2=보)
		 * 내가 가위바위보 중 하나를 선택하여 입력
		 * ex)
		 * com = 0(가위) me = 보(2)
		 * com 승리~!!
		 * 패배 / 무승부 / 승리 중 하나 출력
		 * */ 
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("가위(0), 바위(1), 보(2)");
//		System.out.print("입력 : ");
//		int v = scan.nextInt();
//		
//		if(v==0) {
//			System.out.println("me : 가위");
//		}else if(v==1) {
//			System.out.println("me : 바위");
//		}else if(v==2) {
//			System.out.println("me : 보");
//		}else {
//			System.out.print("다시실행");
//		}
//		
//		int com = (int)(Math.random()*3);
//		
//		if(com==0) {
//			System.out.println("com : 가위");
//		}else if(com==1) {
//			System.out.println("com : 바위");
//		}else if(com==2) {
//			System.out.println("com : 보");
//		}
//		System.out.println("----결과----");
//		if(com-v==-2 || com-v==1) {
//			System.out.println("me : 패배");
//			System.out.print("com : 승리");
//		}else if(com-v==-1 || com-v==2) {
//			System.out.println("me : 승리");
//			System.out.print("com : 패배");
//		}else if(com-v==0){
//			System.out.println("무승부");
//		}
		
		String choice[] = new String[] {"가위","바위","보"};
		
		System.out.println("가위바위보 게임 시작>");
		int comNum = (int)(Math.random()*3); //0 1 2
		System.out.println("컴퓨터 결정 완료!!"+comNum);
		
		System.out.println("가위(0)/바위(1)/보(2) 중 선택 >");
//		String myChoice = scan.next(); //가위, 바위, 보 중 하나
//		String comChoice = (comNum == 0) ? "가위" : 
//			(comNum == 1) ? "바위" : "보";
		int myNum = scan.nextInt();
		String comChoice = choice[comNum];
		String myChoice = choice[myNum];
		
		System.out.println("comChoice > "+ comChoice);
		System.out.println("myChoice > "+myChoice);
		
		//비교
		if(!(myChoice.equals("가위")|| myChoice.equals("바위") || myChoice.equals("보"))){
			System.out.println("입력오류입니다.");
		}else {
			if(comChoice.equals(myChoice)) {
				System.out.println("무승부");
			}else {
				//승 / 패
				if(comChoice.equals("가위")) {
					// 바위 
					System.out.println(myChoice.equals("바위")? "승" : "패");
					
				}else if(comChoice.equals("바위")) {
					// 보
					System.out.println(myChoice.equals("보")? "승" : "패");
					
				}else {
					//가위
					System.out.println(myChoice.equals("가위")? "승" : "패");
				}
			}
		}
		
		System.out.println("종료");
		
		scan.close();

	}

}
