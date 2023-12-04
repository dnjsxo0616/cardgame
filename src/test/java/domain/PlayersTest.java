package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    @DisplayName("players_객체_생성_테스트")
    void createNewPlayers() {
        String input = "Alex, Han, Kim";
        Players players = Players.createNewPlayers(input);

        assertEquals("Alex", players.getPlayers(0).getName().toString());
        assertEquals("Han", players.getPlayers(1).getName().toString());
        assertEquals("Kim", players.getPlayers(2).getName().toString());
    }

    @Test
    @DisplayName("우승자_찾기_테스트")
    void winnerPlayer() {
        String input = "Alex, Han, Kim";
        Players players = Players.createNewPlayers(input);

        players.getPlayers(0).plusScore(3);
        players.getPlayers(1).plusScore(2);
        players.getPlayers(2).plusScore(1);

        List<String> winnerNames = players.winnerPlayer();

        assertEquals(List.of("Alex"), winnerNames);
    }
}