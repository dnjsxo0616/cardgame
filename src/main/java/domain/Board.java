package domain;

public class Board {
    private final int[][] cardBoard;

    public Board() {
        this.cardBoard = SelectCard.selectCard(ShuffleDeck.createShuffleDeck());
    }

    public int[][] getCardBoard() {
        return cardBoard;
    }
}
