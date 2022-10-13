package ru.vsu.cs.g72.goncharova_d_n.service;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProgressService {

    private static Connection connection = DataBaseService.connect();


    public static void addBD(Progress progress) {

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

}
