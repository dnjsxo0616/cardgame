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

        for (String name : playerNames) {
            players.add(Player.createPlayer(name));
        }
        return players;
    }

    public List<Name> winnerPlayer() {
        int maxScore = players.get(0).getScore();
        List<Name> winnerNames = new ArrayList<>();

        for (Player player : players) {
            int playerScore = player.getScore();
            if (playerScore > maxScore) {
                maxScore = playerScore;
                winnerNames.clear();
                winnerNames.add(player.getName());
            } else if (playerScore == maxScore) {
                winnerNames.add(player.getName());
            }
        }
        return winnerNames;
    }
}
