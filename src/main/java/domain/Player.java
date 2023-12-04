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

    public static Player createPlayer(final String name) {
        return new Player(name);
    }

    private int multiplicationPlusNumber(int count) {
        return PLUS_NUMBER * count;
    }

    public void plusScore(int count) {
        score += multiplicationPlusNumber(count);
    }

    public Name scoreComparison(Player player) {
        if (this.score > player.score) {
            return this.name;
        }

        if (this.score < player.score) {
            return player.name;
        }

        return null;
    }

    public Name getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
