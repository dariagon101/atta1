package ru.vsu.cs.g72.goncharova_d_n;

import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.service.JDBC;
import ru.vsu.cs.g72.goncharova_d_n.service.Json;
import ru.vsu.cs.g72.goncharova_d_n.service.PlayersService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, SQLException {
        //Заполнение класса Игроки
        List<Player> players = Json.fromJson();
        System.out.println(players.size());

        Player player = players.get(0);
        System.out.println(player);

        PlayersService.addBD(player);



    }
}
