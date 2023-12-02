package domain;

import java.util.List;

public class CardBoard {
    public static int[][] cardBoard() {
        List<Integer> deck = ShuffleDeck.createPairsDeck(ShuffleDeck.createShuffleDeck());
        return SelectCard.selectCard(deck);
    }
}
