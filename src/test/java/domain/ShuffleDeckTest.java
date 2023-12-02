package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleDeckTest {

    @Test
    @DisplayName("카드_크기_테스트")
    void deckSize() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();

        assertEquals(24, deck.size());
    }

    @Test
    @DisplayName("각_3장_여부_테스트")
    void cardNumber() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();

        for(int i=1; i<=8; i++) {
            assertEquals(3, Collections.frequency(deck, i));
        }
    }

    @Test
    @DisplayName("모든_카드_짝_테스트")
    void createPairsDeck() {
        List<Integer> deck = ShuffleDeck.createShuffleDeck();
        List<Integer> pairsDeck = ShuffleDeck.createPairsDeck(deck);
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int number : pairsDeck) {
            countMap.put(number, countMap.getOrDefault(number, 0) +1);
        }

        for(int count : countMap.values()) {
            assertEquals(0, count%2);
        }
    }
}