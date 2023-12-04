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
}