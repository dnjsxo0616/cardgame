package domain;

import java.util.HashMap;

public class Board {
    private final int[][] cardBoard;

    public Board() {
        this.cardBoard = CardBoard.cardBoard();
    }

    public int[][] getCardBoard() {
        return cardBoard;
    }

    public int cardBoardSize() {
        int count = 0;
        for (int i = 0; i < cardBoard.length; i++) {
            for (int j = 0; j < cardBoard[i].length; j++) {
                if (cardBoard[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public void removeNumber(int[] input1, int[] input2) {
        cardBoard[input1[0]][input1[1]] = 0;
        cardBoard[input2[0]][input2[1]] = 0;
    }

    public boolean checkEqualNumber(int[] input1, int[] input2) {
        return cardBoard[input1[0]][input1[1]] == cardBoard[input2[0]][input2[1]];
    }

    public boolean checkEmptySpace(int[] input1, int[] input2) {
        return cardBoard[input1[0]][input1[1]] == 0 || cardBoard[input2[0]][input2[1]] == 0;
    }

    public boolean checkBoard() {
        for (int i = 0; i < cardBoard.length; i++) {
            for (int j = 0; j < cardBoard[i].length; j++) {
                if (cardBoard[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
