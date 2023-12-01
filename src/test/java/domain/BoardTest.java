package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("카드수_테스트")
    void cardBoardSize() {
        int initSize = board.cardBoardSize();
        assertEquals(18, initSize);
    }

    @Test
    @DisplayName("카드_제거_테스트")
    void removeNumber() {
        int[] input1 = new int[]{1, 1};
        int[] input2 = new int[]{1, 2};
        board.removeNumber(input1, input2);

        assertEquals(0, board.getCardBoard()[input1[0]][input1[1]]);
        assertEquals(0, board.getCardBoard()[input2[0]][input2[1]]);
    }


    @Test
    @DisplayName("제거된_카드의_빈_공간_테스트")
    void checkEmptySpace() {
        int[] input1 = new int[]{1, 1};
        int[] input2 = new int[]{1, 2};
        board.removeNumber(input1, input2);

        assertTrue(board.checkEmptySpace(input1, input2));
    }
}