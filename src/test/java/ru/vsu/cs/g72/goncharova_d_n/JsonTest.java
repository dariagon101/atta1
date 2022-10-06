package ru.vsu.cs.g72.goncharova_d_n;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.service.Json;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    @Test
    void fromJson() throws IOException {
        List<Player> players = Json.fromJson();
        assertEquals(players.get(0).getPlayerId(), 14681);
    }
}