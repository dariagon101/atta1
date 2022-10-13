package ru.vsu.cs.g72.goncharova_d_n.service;

import ru.vsu.cs.g72.goncharova_d_n.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayersService {

    private static Connection connection = DataBaseService.connect();

    //добавление игрока в БД

    //загружать пачками

    public static void addBD (Player player) {

        String sql = "insert into players (id, nickname) values (?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, player.getPlayerId());
            stm.setString(2, player.getNickname());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
