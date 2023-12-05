package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return playerNames.stream()
                .map(Player::createPlayer)
                .collect(Collectors.toList());
    }

    public List<String> winnerPlayer() {
        int maxScore = players.get(0).getScore();
        List<String> winnerNames = new ArrayList<>();

        for (Player player : players) {
            int playerScore = player.getScore();
            if (playerScore > maxScore) {
                maxScore = playerScore;
                winnerNames.clear();
                winnerNames.add(player.getName().toString());
            } else if (playerScore == maxScore) {
                winnerNames.add(player.getName().toString());
            }
        }
        return winnerNames;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getPlayersSize() {
        return players.size();
    }
}
