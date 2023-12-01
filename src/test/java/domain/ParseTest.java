package domain;

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
}