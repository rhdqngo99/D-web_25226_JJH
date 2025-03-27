package project2;

import java.util.Scanner;

public class GameMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 게임 시작 메인 메뉴
        while (true) {
            System.out.println("==== Yacht Dice 게임 ====");
            System.out.println("1. 게임 실행");
            System.out.println("2. 게임 종료");
            System.out.println("3. 게임 룰 보기");

            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // 게임 실행
                scanner.nextLine(); // 버퍼 비우기 (nextInt 이후에 nextLine 처리)
                System.out.print("플레이어1 이름을 입력하세요: ");
                String playerName = scanner.nextLine();
                System.out.print("플레이어2 이름을 입력하세요: ");
                String playerName2 = scanner.nextLine();

                // 게임 객체 생성
                GamePlayer gamePlayer1 = new GamePlayer(playerName);
                GameConsole gameConsole = new GameConsole(gamePlayer1);
                GamePlayer gamePlayer2 = new GamePlayer(playerName);
                GameConsole gameConsole2 = new GameConsole(gamePlayer2);

                // 게임 실행
                gameConsole.Console();
            } else if (choice == 2) {
                // 게임 종료
                System.out.println("게임을 종료합니다.");
                break;
            } else if (choice == 3) {
                // 룰 확인
                GameRule gameRule = new GameRule();
                gameRule.printRules();
            } else {
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

        scanner.close();
    }
}