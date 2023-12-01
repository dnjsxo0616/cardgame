package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardPosition {
    private static final int MIN_POSITION = 0;
    private static final String INPUT_FORM = "\\(\\d+,\\s*\\d+\\)";
    private static void validateForm(String input) {
        Pattern pattern = Pattern.compile(INPUT_FORM);
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }
    }

    private static void validateNumber(int[] position) {
        if (!(MIN_POSITION <= position[0] && position[0] <= SelectCard.CARD_BOARD_ROW)
                || !(MIN_POSITION <= position[1] && position[1] <= SelectCard.CARD_BOARD_COL-1)) {
            throw new IllegalArgumentException("입력된 좌표의 범위가 올바르지 않습니다.");
        }
    }
}
