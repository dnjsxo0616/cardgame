package domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 4;

    private final String name;

    public Name(final String name) {
        validateLength(name);
        this.name = name;
    }

    private static void validateLength(final String input) {
        if (input.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 4자입니다.");
        }
    }

    public String getName() {
        return name;
    }
}