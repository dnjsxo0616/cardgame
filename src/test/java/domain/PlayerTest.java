package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    @Test
    @DisplayName("player_객체_생성_테스트")
    void createPlayer() {
        Player player = Player.createPlayer("Han");

        assertEquals("Han", player.getName().toString());
        assertEquals(0, player.getScore());
    }

    @Test
    @DisplayName("점수_더하기_테스트")
    void plusScore() {
        Player player = Player.createPlayer("Han");
        player.plusScore(2);

        assertEquals(20, player.getScore());
    }
}