package ru.vsu.cs.g72.goncharova_d_n;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.service.Cache;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    @Test
    void fromJson() throws IOException {
        Cache cache = new Cache();
        List<Player> players = cache.fromJson();
        assertEquals(players.get(0).getPlayerId(), 14681);
    }
}