package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectCardTest {
    @Test
    @DisplayName("카드_행_테스트")
    void testRow() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();
        int[][] cardBoard = SelectCard.selectCard(deck);

        assertEquals(3, cardBoard.length);
    }
}