package ru.vsu.cs.g72.goncharova_d_n;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;
import ru.vsu.cs.g72.goncharova_d_n.service.*;
import ru.vsu.cs.g72.goncharova_d_n.service.bd.CurrencyService;
import ru.vsu.cs.g72.goncharova_d_n.service.bd.ItemService;
import ru.vsu.cs.g72.goncharova_d_n.service.bd.PlayerService;
import ru.vsu.cs.g72.goncharova_d_n.service.bd.ProgressService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static PlayerService playersService = new PlayerService();
    private static CurrencyService currencyService = new CurrencyService();
    private static ProgressService progressService = new ProgressService();
    private static ItemService itemService = new ItemService();
    private static Cache cache = new Cache();


    public static List<Player> playerList() throws IOException {
        return cache.fromJson();
    }


    public static void saveBD (List<Player> players) throws IOException {
        //Заполнение БД
        for (Player player : players) {
            playersService.save(player);
            for (Currency currency : player.getCurrencies()) {
                currencyService.save(currency);
            }
            for (Progress progress : player.getProgresses()) {
                progressService.save(progress);
            }
            for (Item item : player.getItems()) {
                itemService.save(item);
            }
        }
    }


    public static void main(String[] args) throws IOException, SQLException {
        Player player = cache.findPlayerById(10000);
        System.out.println(player);
        ConsoleService consoleService = new ConsoleService();
        consoleService.delete(10000);
        Player player1 = cache.findPlayerById(10000);
        System.out.println(player1);







    }
}
