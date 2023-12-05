package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parse {
    private static final String COMMA = ",";
    private static final String INPUT_FORMAT = "[()\\s]";
    private static final String REPLACE_STRING = "";

    public static String[] parseComma(String input) {
        return input.replaceAll(INPUT_FORMAT, REPLACE_STRING).split(COMMA);
    }

    public static int[] covertToInt(String[] input) {
        try {
            return new int[]{Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 좌표를 정수로 변환할 수 없습니다.");
        }
    }

    public static List<String> parseName(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
