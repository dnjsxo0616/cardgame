package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseTest {

    @Test
    @DisplayName("파싱_테스트")
    void parseComma() {
        String input = "(1, 2)";
        String[] expected = {"1", "2"};

        assertArrayEquals(expected, Parse.parseComma(input));
    }

    @Test
    @DisplayName("정수_변환_테스트")
    void covertToInt() {
        String[] input = {"1", "2"};
        int[] expected = {0, 1};

        assertArrayEquals(expected, Parse.covertToInt(input));
    }

    @Test
    @DisplayName("정수_변환_오류_테스트")
    void covertToIntFail() {
        String[] input = {"a", "n"};

        Assertions.assertThatThrownBy(() -> Parse.covertToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 좌표를 정수로 변환할 수 없습니다.");
    }
}