package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BoardPositionTest {
    @Test
    @DisplayName("문자열_좌표_변환_테스트")
    void boardPosition() {
        String input = "(1, 2)";
        int[] testInput = {0, 1};

        assertArrayEquals(testInput, BoardPosition.boardPosition(input));
    }

}