package ru.vsu.cs.g72.goncharova_d_n.service;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ItemService {

    private static Connection connection = DataBaseService.connect();


    public static void addBD (Item item) {

        String sql = "insert into items (id, player_id, resource_id, count, level) values (?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, item.getId());
            stm.setInt(2, item.getPlayerId());
            stm.setInt(3, item.getResourceId());
            stm.setInt(4, item.getCount());
            stm.setInt(5, item.getLevel());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
