package project2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GameConsole {
    private GamePlayer player;
    private Scanner scanner;

    public GameConsole(GamePlayer player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public void Console() {
        // 13판 게임 진행
        for (int round = 1; round <= 13; round++) {
            System.out.println("\n==== Round " + round + " ====");
            System.out.println("주사위를 굴립니다...");
            
            // GameDice 객체 생성 및 첫 번째 주사위 굴리기
            GameDice gameDice = new GameDice();
            gameDice.rollDice();  // 5개의 주사위 던지기
            System.out.println("주사위 결과: " + gameDice.getDiceResults());

            List<Integer> keptDice = new ArrayList<>();
            int rollCount = 3; // 주사위는 최대 3번까지 굴릴 수 있다

            // 3번의 기회 동안 주사위를 굴리고 킵할 주사위 선택
            for (int i = 0; i < rollCount; i++) {
                System.out.println("현재 주사위: " + gameDice.getDiceResults());

                if (i == 0 || i == 1) { // 첫 번째, 두 번째 굴림에서는 주사위를 킵할지 말지를 물어본다
                    System.out.print("킵할 주사위를 선택하세요 (주사위 번호를 공백으로 구분, 없으면 Enter): ");
                    String input = scanner.nextLine();

                    if (!input.isEmpty()) {
                        // 사용자가 선택한 주사위 킵
                        String[] keepNumbers = input.split(" ");
                        for (String s : keepNumbers) {
                            try {
                                int number = Integer.parseInt(s);
                                if (gameDice.getDiceResults().contains(number)) {
                                    keptDice.add(number); // 킵할 주사위 추가
                                    gameDice.getDiceResults().remove(Integer.valueOf(number)); // 이미 킵한 주사위는 굴리지 않음
                                } else {
                                    System.out.println("잘못된 주사위 번호입니다.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("유효하지 않은 입력입니다.");
                            }
                        }
                    }

                    // 킵한 주사위 제외한 나머지 주사위 굴리기
                    gameDice.rollRemainingDice(); // 남은 주사위만 굴린다
                    gameDice.getDiceResults().addAll(keptDice); // 킵한 주사위 추가
                } else {
                    // 세 번째 굴림에서는 이미 킵한 주사위를 제외한 나머지만 굴린다
                    gameDice.rollRemainingDice(); // 남은 주사위만 굴린다
                    gameDice.getDiceResults().addAll(keptDice); // 킵한 주사위 추가
                }

                // 마지막 굴림 후 점수판에 기록
                if (i == 2) {
                    recordScore(round, gameDice.getDiceResults());
                }
            }
        }

        // 게임 종료 후 최종 점수 출력
        System.out.println("\n==== 게임 종료 ====");
        System.out.println("플레이어 " + player.getPlName() + "의 최종 점수: " + player.getScoreboardObj().getGrandTotal());
    }

    private void recordScore(int round, List<Integer> diceResults) {
        // 플레이어가 점수를 기록할 항목 선택
        System.out.println("점수를 기록할 항목을 선택하세요 (1~12): ");
        player.getScoreboardObj().displayScoreboard();

        int category = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 해당 항목에 점수 기록
        player.getScoreboardObj().recordScore(category, diceResults);
    }
}