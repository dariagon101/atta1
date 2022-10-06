package ru.vsu.cs.g72.goncharova_d_n.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Json {

    private static ObjectMapper objectMapper = new ObjectMapper();

    //чтение файла из json

    public static List<Player> fromJson() throws IOException {
        return objectMapper.readValue(new FileReader("players.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
    }
}
