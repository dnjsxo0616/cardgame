package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(final String input) {
        List<String> playerNames = Parse.parseName(input);
        this.players = createPlayers(playerNames);
    }

    public static Players createNewPlayers(final String input) {
        return new Players(input);
    }

    private List<Player> createPlayers(final List<String> playerNames) {
        List<Player> players = new ArrayList<>();

        for(String name : playerNames) {
            players.add(Player.createPlayer(name));
        }
        return players;
    }

    public Name winnerPlayer() {
        Player winnerPlayer = players.get(0);

        for (Player player : players) {
            winnerPlayer = compareScore(winnerPlayer, player);
        }

        if (winnerPlayer == null) {
            return null;
        } else {
            return winnerPlayer.getName();
        }
    }

    private Player compareScore(Player player1, Player player2) {
        if (player1.getScore() > player2.getScore()) {
            return player1;
        } else if (player1.getScore() < player2.getScore()) {
            return player2;
        } else {
            return null;
        }
    }
}
