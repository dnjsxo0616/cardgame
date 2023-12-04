package domain;

public class Player {
    private static final int START_NUMBER = 0;

    private final Name name;
    private int score;

    private Player(final String name) {
        this.name = Name.createName(name);
        this.score = START_NUMBER;
    }
}