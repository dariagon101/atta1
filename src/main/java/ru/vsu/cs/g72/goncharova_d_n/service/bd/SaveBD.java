package ru.vsu.cs.g72.goncharova_d_n.service.bd;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;
import ru.vsu.cs.g72.goncharova_d_n.service.Cache;
import ru.vsu.cs.g72.goncharova_d_n.service.ConsoleService;

import java.io.IOException;
import java.util.List;

public class SaveBD {

    private static PlayerService playersService = new PlayerService();
    private static CurrencyService currencyService = new CurrencyService();
    private static ProgressService progressService = new ProgressService();
    private static ItemService itemService = new ItemService();
    private static Cache cache = new Cache();


    private List<Player> playerList() throws IOException {
        return cache.fromJson();
    }


    public void saveBD () throws IOException {
        //Заполнение БД
        List<Player> players = playerList();
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
}
