package domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 4;

    private final String name;

    public Name(final String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
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

    public String getName() {
        return name;
    }
}