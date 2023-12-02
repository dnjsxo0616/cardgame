package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleDeck {
    private static final int DECK_CREATE_COUNT = 3;
    private static final int DECK_MAX = 8;

    public static List<Integer> createShuffleDeck() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= DECK_MAX; i++) {
            for (int j = 1; j <= DECK_CREATE_COUNT; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public static List<Integer> createPairsDeck(List<Integer> deck) {
        List<Integer> pairsDeck = new ArrayList<>();
        int count = 0;

        for (int number : deck) {
            count++;
            pairsDeck.add(number);
            pairsDeck.add(number);
            if (count > 18) {
                break;
            }
        }
        Collections.shuffle(pairsDeck);
        return pairsDeck;
    }
}
