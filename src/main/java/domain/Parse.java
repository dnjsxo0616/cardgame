package domain;

public class Parse {
    public static String[] parseComma(String input) {
        return input.replaceAll("[()\\s]", "").split(",");
    }

    public static int[] covertToInt(String[] input) {
        try {
            return new int[]{Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 좌표를 정수로 변환할 수 없습니다.");
        }
    }
}
