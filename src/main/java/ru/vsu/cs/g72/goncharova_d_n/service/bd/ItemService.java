package ru.vsu.cs.g72.goncharova_d_n.service.bd;

import ru.vsu.cs.g72.goncharova_d_n.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemService {

    private static Connection connection = DataBaseService.connect();


    public void save(Item item) {

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


    public void delete(int id) {
        String sql = "delete from items where id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update (Item item) {
        String sql = "update items set resource_id=?, count=?, level=? where id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, item.getResourceId());
            stm.setInt(2, item.getCount());
            stm.setInt(3, item.getLevel());
            stm.setInt(4, item.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
