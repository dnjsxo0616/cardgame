package domain;

import java.util.ArrayList;
import java.util.List;

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
        String[] strNames = input.split(COMMA);
        List<String> names = new ArrayList<>();
        for (String name : strNames) {
            names.add(name.trim());
        }
        return names;
    }
}
