package ru.vsu.cs.g72.goncharova_d_n.service;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyService {

    private static Connection connection = DataBaseService.connect();


    public static void addBD(Currency currency) {

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

}
