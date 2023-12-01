package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleDeckTest {

    @Test
    @DisplayName("카드_크기_테스트")
    void createShuffleDeck() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();

        assertEquals(24, deck.size());
    }
}