package ru.vsu.cs.g72.goncharova_d_n.service.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseService {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/players_db";
    private static final String USER = "postgres";
    private static final String PASS = "Dasha2003!";

    //Коннект с БД
    public static Connection connect() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }
}
