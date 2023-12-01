package domain;

import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("입력_형식_오류_테스트")
    void validateForm() {
        String input = "1, 2";

        Assertions.assertThatThrownBy(() -> BoardPosition.boardPosition(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 형식이 잘못되었습니다.");
    }
}