package project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardInfo {
	ConsoleView c = new ConsoleView();
	// 카드 풀 생성: 공격 3장, 회복 2장 포함
    public static List<Card> createCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("¶ 베기(1)", "공격", 1));
        cards.add(new Card("¶ 베기(2)", "공격", 2));
        cards.add(new Card("¶ 베기(3)", "공격", 3));
        cards.add(new Card("† 힐(1)", "회복", 1));
        cards.add(new Card("† 힐(2)", "회복", 2));
        return cards;
    }

    // 카드에서 무작위로 2장 뽑는 메서드
    public static List<Card> drawTwoRandomCards() {
        List<Card> deck = createCard();
        Collections.shuffle(deck);  // 카드 섞기
        return deck.subList(0, 2); // 상위 2장 반환
    }
	
	
}
