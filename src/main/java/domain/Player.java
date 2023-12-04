package domain;

public class Player {
    private static final int PLUS_NUMBER = 10;
    private static final int START_NUMBER = 0;

    private final Name name;
    private int score;

    private Player(final String name) {
        this.name = Name.createName(name);
        this.score = START_NUMBER;
    }

    private int multiplicationPlusNumber(int count) {
        return PLUS_NUMBER * count;
    }

    public void plusScore(int count) {
        score += multiplicationPlusNumber(count);
    }

    public Name getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}