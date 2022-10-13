package ru.vsu.cs.g72.goncharova_d_n;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;
import ru.vsu.cs.g72.goncharova_d_n.service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, SQLException {
        //Заполнение класса Игроки
        List<Player> players = Json.fromJson();
        //Заполнение БД
        for (Player player : players) {
            PlayersService.addBD(player);
            for (Currency currency : player.getCurrencies()) {
                CurrencyService.addBD(currency);
            }
            for (Progress progress : player.getProgresses()) {
                ProgressService.addBD(progress);
            }
            for (Item item : player.getItems()) {
                ItemService.addBD(item);
            }
        }


    }
}
