package domain;

import java.util.List;

public class SelectCard {
    public static final int CARD_BOARD_ROW = 3;
    public static final int CARD_BOARD_COL = 6;

    public static int[][] selectCard(List<Integer> cardDeck) {
        int[][] cardBoard = new int[CARD_BOARD_ROW][CARD_BOARD_COL];

        for (int i = 0; i < CARD_BOARD_ROW; i++) {
            for (int j = 0; j < CARD_BOARD_COL; j++) {
                cardBoard[i][j] = cardDeck.remove(0);
            }
        }
        return cardBoard;
    }
}
