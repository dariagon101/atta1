package ru.vsu.cs.g72.goncharova_d_n.service.bd;

import ru.vsu.cs.g72.goncharova_d_n.model.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgressService {

    private static Connection connection = DataBaseConnection.connect();


    public void save(Progress progress) {

        String sql = "insert into progresses (id, player_id, resource_id, score, max_score) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, progress.getId());
            stm.setInt(2, progress.getPlayerId());
            stm.setInt(3, progress.getResourceId());
            stm.setInt(4, progress.getScore());
            stm.setInt(5, progress.getMaxScore());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete (Progress progress) {
        String sql = "delete from progresses where id=? and player_id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, progress.getId());
            stm.setInt(2, progress.getPlayerId());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update (Progress progress) {
        String sql = "update progresses set resource_id=?, score=?, max_score=? where id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, progress.getResourceId());
            stm.setInt(2, progress.getScore());
            stm.setInt(3, progress.getMaxScore());
            stm.setInt(4, progress.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
