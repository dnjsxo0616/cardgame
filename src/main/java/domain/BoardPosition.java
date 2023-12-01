package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardPosition {
    private static final String INPUT_FORM = "\\(\\d+,\\s*\\d+\\)";
    private static void validateForm(String input) {
        Pattern pattern = Pattern.compile(INPUT_FORM);
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }
    }
}
