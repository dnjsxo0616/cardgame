package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("이름_파싱_테스트")
    void parseName() {
        String input = "홍길동, 김바다";
        List<String> expected = Arrays.asList("홍길동", "김바다");

        assertEquals(expected, Parse.parseName(input));
    }
}