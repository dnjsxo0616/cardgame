package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectCardTest {
    @Test
    @DisplayName("카드_행_테스트")
    void testRow() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();
        int[][] cardBoard = SelectCard.selectCard(deck);

        assertEquals(3, cardBoard.length);
    }

    @Test
    @DisplayName("카드_열_테스트")
    void testCol() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();
        int[][] cardBoard = SelectCard.selectCard(deck);

        for (int i = 0; i < 3; i++) {
            assertEquals(6, cardBoard[i].length);
        }
    }
}