package ru.vsu.cs.g72.goncharova_d_n.service;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;

import java.util.List;
import java.util.Scanner;

public class CRUD {
    private ConsoleService consoleService = new ConsoleService();
    private Cache cache = consoleService.getCache();
    private Scanner scanner = consoleService.getScanner();

    public Cache getCache() {
        return cache;
    }

    public void updatePlayer() {
        System.out.println("Введите id игрока для которого будут происходить изменения");
        int id = scanner.nextInt();
        System.out.println("Чтобы изменить данные игрока введите -u, удалить - -d, создать - -c, посмотреть -r, чтобы закончить - -e");
        String parameter = scanner.next();


        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-u":
                    consoleService.update(id);
                    break;

                case "-d":
                    consoleService.delete(id);
                    break;

                case "-c":
                    consoleService.create(id);
                    break;

                case "-r":
                    consoleService.read(id);
                    break;

            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();

        }

        //json
        cache.writeInJson();

    }


}
