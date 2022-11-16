package ru.vsu.cs.g72.goncharova_d_n.service.bd;

import ru.vsu.cs.g72.goncharova_d_n.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerService {

    private static Connection connection = DataBaseService.connect();

    //добавление игрока в БД

    //загружать пачками

    public void save(Player player) {

        String sql = "insert into players (id, nickname) values (?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, player.getPlayerId());
            stm.setString(2, player.getNickname());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void delete (int id) {
        String sql = "delete from players where id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update (Player player) {
        String sql = "update players set nickname=? where id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setString(1, player.getNickname());
            stm.setInt(2, player.getPlayerId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
