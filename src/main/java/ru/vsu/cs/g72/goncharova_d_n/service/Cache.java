package ru.vsu.cs.g72.goncharova_d_n.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Cache {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private final Map<Integer, Player> cache;


    public Cache() {
        this.cache = fromJson()
                .stream()
                .collect(Collectors.toMap(Player::getPlayerId, Function.identity()));
    }


    //чтение файла из json

    public List<Player> fromJson() {
        try {
            return objectMapper.readValue(new FileReader("players.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeInJson() {
        try {
            List<Player> players = new ArrayList<>(cache.values());
            objectMapper.writeValue(new FileWriter("players.json"), players);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // поиск игрока по id
    public Player findPlayerById(int id) {
        return cache.get(id);
    }

    public Map<Integer, Player> getCache() {
        return cache;
    }

    @Override
    public String toString() {
        return "Cache: " + cache.toString();
    }

    //удаление
    //добавление
    //изменение


}
