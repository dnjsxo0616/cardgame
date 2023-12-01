package domain;

public class Parse {
    public static String[] parseComma(String input) {
        return input.replaceAll("[()\\s]", "").split(",");
    }
}
