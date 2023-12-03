package domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 4;

    private final String name;

    public Name(final String name) {
        validateEmpty(name);
        validateLength(name);
        validateWhiteSpace(name);
        this.name = name;
    }

    public static Name createName(final String name) {
        return new Name(name);
    }

    private static void validateLength(final String input) {
        if (input.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 4자입니다.");
        }
    }

    private static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private static void validateWhiteSpace(final String input) {
        if (checkWhiteSpace(input)) {
            throw new IllegalArgumentException("공백이 포함되면 안됩니다.");
        }
    }

    private static boolean checkWhiteSpace(final String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    public String getName() {
        return name;
    }
}