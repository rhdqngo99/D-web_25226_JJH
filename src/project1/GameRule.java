package project1;

public class GameRule {
	
	/* 다이스 룰
	 * 주시위 1 Aces (의 값만 합 계 출력 ex) 1 눈 3개면 -> x3 = 3)
	 * 주시위 2 Deuces
	 * 주시위 3 Threes
	 * 주시위 4 Fours
	 * 주시위 5 Fives
	 * 주시위 6 Sixes
	 * ------------------------------
	 * 서브합계 sub total(보너스) (상단 항목의 점수 합계가 63점 이상일 때, 35점을 추가로 얻는다.)
	 * ------------------------------
	 * 초이스			  (주사위 눈 5개의 총합. 최대 30점)
	 * 4 or Kind	  (동일한 주사위 눈이 4개 이상일 때, 동일한 주사위 눈 4개의 총합. 최대 24점.)
	 * Full House	  (같은 번호 동일한 주사위 눈 한 종류가 3개, 다른 종류가 2개일 때, 주사위 눈 5개의 총합 최대 28점)
	 * 스몰(S) 스트레이트 (주사위 눈이 각각 1,2,3,4 / 2,3,4,5 / 3,4,5,6 일 때 고정 15점)
	 * 라지(L) 스트레이트 (주사위 눈이 각각 1,2,3,4,5 / 2,3,4,5,6 일 때 고정 30점.)
	 * 야추  			  (동일한 주사위 눈이 5개일 때. 고정 50점.)
	 * ------------------------------
	 * 합계 :			  (보너스 + 총 합)
	 * 
	 * */
	
	  public void printRules() {
	        System.out.println("==== 게임 룰 ====");
	        System.out.println("1. 각 플레이어는 주사위를 3번 던질수 있으며 해당 번호를 킵 할수 있다.");
	        System.out.println("  - 예: 처음 3,3,1,2,5 3번 킵 / 킵 된 주사위 - 3,3");
	        System.out.println("  - 예: 2번째 3개를 리 롤 5,3,1 킵 / 킵 된 주사위 - 3,3,3");
	        System.out.println("  - 예: 마지막 2개 리 롤 5,6 - 최종 3,3,3,5,6 ");
	        
	        System.out.println("\n2. 각 주사위 종류에 따른 점수 계산:");
	        System.out.println("  - Aces (1): 주사위에서 1이 나온 개수만큼 점수 합산 (예: 1이 3개 나오면 3점)");
	        System.out.println("  - Deuces (2): 주사위에서 2가 나온 개수만큼 점수 합산 (예: 2가 3개 나오면 6점)");
	        System.out.println("  - Threes (3): 주사위에서 3이 나온 개수만큼 점수 합산");
	        System.out.println("  - Fours (4): 주사위에서 4가 나온 개수만큼 점수 합산");
	        System.out.println("  - Fives (5): 주사위에서 5가 나온 개수만큼 점수 합산");
	        System.out.println("  - Sixes (6): 주사위에서 6이 나온 개수만큼 점수 합산");
	        
	        System.out.println("\n3. 각 서브합계 (sub-total):");
	        System.out.println("  - 1~6까지의 점수 합계가 63점 이상일 경우 보너스 35점 추가");
	        
	        System.out.println("\n4. 각 추가 점수 항목:");
	        System.out.println("  - 초이스 (Choice): 주사위 눈 5개의 합계 (최대 30점)");
	        System.out.println("  - 4 or Kind: 동일한 주사위 눈 4개 이상일 경우, 4개가 나온 눈의 총합");
	        System.out.println("  - Full House (풀 하우스): 같은 숫자 3개 + 다른 숫자 2개일 경우 총합 (최대 28점)");
	        System.out.println("  - 스몰 스트레이트 (Small Straight): 1, 2, 3, 4 또는 2, 3, 4, 5 또는 3, 4, 5, 6 일 때 15점");
	        System.out.println("  - 라지 스트레이트 (Large Straight): 1, 2, 3, 4, 5 또는 2, 3, 4, 5, 6 일 때 30점");
	        System.out.println("  - 야추 (Yacht): 임의의 동일한 주사위 눈 5개가 나오면 50점");

	        System.out.println("\n5. 각 게임 점수 합계:");
	        System.out.println("  - 각 항목의 점수를 더한 후 서브합계 및 최종 점수를 계산.");
	    }

}