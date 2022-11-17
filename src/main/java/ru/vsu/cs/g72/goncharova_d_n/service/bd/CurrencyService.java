package ru.vsu.cs.g72.goncharova_d_n.service.bd;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CurrencyService {

    private static Connection connection = DataBaseConnection.connect();


    public void save(Currency currency) {

        String sql = "insert into currencies (id, player_id, resource_id, name, count) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, currency.getId());
            stm.setInt(2, currency.getPlayerId());
            stm.setInt(3, currency.getResourceId());
            stm.setString(4, currency.getName());
            stm.setInt(5, currency.getCount());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete (Currency currency) {
        String sql = "delete from currencies where id=? and player_id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, currency.getId());
            stm.setInt(2, currency.getPlayerId());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update (Currency currency) {
        String sql = "update currencies set resource_id=?, name=?, count=? where id=?";
        try (PreparedStatement stm = connection.prepareStatement(sql);) {
            stm.setInt(1, currency.getResourceId());
            stm.setString(2, currency.getName());
            stm.setInt(3, currency.getCount());
            stm.setInt(4, currency.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
