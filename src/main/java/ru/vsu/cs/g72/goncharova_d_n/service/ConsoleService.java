package ru.vsu.cs.g72.goncharova_d_n.service;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;

import java.util.Map;
import java.util.Scanner;

public class ConsoleService {
    private Scanner scanner = new Scanner(System.in);
    private Cache cache = new Cache();


    public Cache getCache() {
        return cache;
    }

    public void update(int id) {
        Player player = cache.findPlayerById(id);
        System.out.println("Чтобы изменить имя введите -n, прогресс - -p, валюту - -c, вещи -i, чтобы закончить - -e");
        String parameter = scanner.next();


        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-n":
                    System.out.println("Введите имя: ");
                    String name = scanner.next();
                    player.setNickname(name);
                    cache.getCache().put(id, player);
                    break;
                case "-p":
                    System.out.println("Введите количество прогрессов, которые хотите изменить: ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Введите id прогресса: ");
                        int progressId = scanner.nextInt();
                        Progress progress = player.getProgressById(progressId);
                        Progress progNew = updateProgress(progress);
                        player.getProgresses().remove(progress);
                        player.getProgresses().add(progNew);
                    }
                    break;
                case "-c":
                    System.out.println("Введите количество валют, которые хотите изменить: ");
                    int k = scanner.nextInt();
                    for (int i = 0; i < k; i++) {
                        System.out.println("Введите id валюты: ");
                        int currencyId = scanner.nextInt();
                        Currency currency = player.getCurrencyById(currencyId);
                        Currency currNew = updateCurrency(currency);
                        player.getCurrencies().remove(currency);
                        player.getCurrencies().add(currNew);
                    }
                    break;
                case "-i":
                    System.out.println("Введите количество вещей, которые хотите изменить: ");
                    int l = scanner.nextInt();
                    for (int i = 0; i < l; i++) {
                        System.out.println("Введите id вещи: ");
                        int itemId = scanner.nextInt();
                        Item item = player.getItemById(itemId);
                        Item itemNew = updateItem(item);
                        player.getItems().remove(item);
                        player.getItems().add(itemNew);
                    }
                    break;

            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();

        }
    }

    public void delete(int id) {
        Player player = cache.findPlayerById(id);
        System.out.println("Чтобы удалить игрока введите -pl, прогресс у игрока - -p, валюту - -c, вещи -i, чтобы закончить - -e");
        String parameter = scanner.next();

        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-pl":
                    cache.getCache().remove(id);
                    break;

                case "-p":
                    System.out.println("Введите количество прогрессов, которые хотите удалить: ");
                    int n = scanner.nextInt();
                    if (n > player.getProgresses().size()) {
                        throw new RuntimeException();
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.println("Введите id прогресса: ");
                        int progressId = scanner.nextInt();
                        Progress progress = player.getProgressById(progressId);
                        player.getProgresses().remove(progress);
                    }
                    break;

                case "-c":
                    System.out.println("Введите количество валют, которые хотите удалить: ");
                    int k = scanner.nextInt();
                    if (k > player.getCurrencies().size()) {
                        throw new RuntimeException();
                    }
                    for (int i = 0; i < k; i++) {
                        System.out.println("Введите id валюты: ");
                        int currencyId = scanner.nextInt();
                        Currency currency = player.getCurrencyById(currencyId);
                        player.getCurrencies().remove(currency);
                    }
                    break;

                case "-i":
                    System.out.println("Введите количество вещей, которые хотите изменить: ");
                    int l = scanner.nextInt();
                    if (l > player.getItems().size()) {
                        throw new RuntimeException();
                    }
                    for (int i = 0; i < l; i++) {
                        System.out.println("Введите id вещи: ");
                        int itemId = scanner.nextInt();
                        Item item = player.getItemById(itemId);
                        player.getItems().remove(item);
                    }
                    break;

            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();


        }

    }


    public void read(int id) {
        Player player = cache.findPlayerById(id);
        System.out.println("Чтобы посмотреть игрока введите -pl, прогресс у игрока - -p, валюту - -c, вещи -i, чтобы закончить - -e");
        String parameter = scanner.next();

        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-pl":
                    System.out.println(player);
                    break;

                case "-p":
                    System.out.println("Введите количество прогрессов, которые хотите посмотреть: ");
                    int n = scanner.nextInt();
                    if (n > player.getProgresses().size())
                        n = player.getProgresses().size();

                    for (int i = 0; i < n; i++) {
                        System.out.println("Введите id прогресса: ");
                        int progressId = scanner.nextInt();
                        System.out.println(player.getProgressById(progressId));
                    }
                    break;

                case "-c":
                    System.out.println("Введите количество валют, которые хотите посмотреть: ");
                    int k = scanner.nextInt();
                    if (k > player.getCurrencies().size()) {
                        k = player.getProgresses().size();
                    }
                    for (int i = 0; i < k; i++) {
                        System.out.println("Введите id валюты: ");
                        int currencyId = scanner.nextInt();
                        System.out.println(player.getCurrencyById(currencyId));
                    }
                    break;

                case "-i":
                    System.out.println("Введите количество вещей, которые хотите посмотреть: ");
                    int l = scanner.nextInt();
                    if (l > player.getItems().size()) {
                        l = player.getItems().size();
                    }
                    for (int i = 0; i < l; i++) {
                        System.out.println("Введите id посмотреть: ");
                        int itemId = scanner.nextInt();
                        System.out.println(player.getItemById(itemId));
                    }
                    break;

            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();

        }

    }

    public void create (int id) {
        System.out.println("Чтобы хотите создать: игрока введите -pl, прогресс у игрока - -p, валюту - -c, вещи -i, чтобы закончить - -e");
        String parameter = scanner.next();

        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-pl":
                    Player player = new Player();
                    System.out.println("Nickname: ");
                    String name = scanner.next();
                    player.setPlayerId(id);
                    player.setNickname(name);
                    break;

                case "-p":
                    Player player1 = cache.findPlayerById(id);
                    createProgresses(player1);
                    break;

                case "-c":
                    Player player2 = cache.findPlayerById(id);
                    createCurrencies(player2);
                    break;

                case "-i":
                    Player player3 = cache.findPlayerById(id);
                    createItems(player3);
                    break;

            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();

        }
    }

    private void createProgresses(Player player) {
        System.out.print("Сколько прогрессов хотите добавить у игрока?: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("-------------------");
            Progress progress = new Progress();
            System.out.print("id: ");
            int id = scanner.nextInt();
            progress.setId(id);
            System.out.print("resourceId: ");
            int resourceId = scanner.nextInt();
            progress.setResourceId(resourceId);
            System.out.print("score: ");
            int score = scanner.nextInt();
            progress.setScore(score);
            System.out.print("maxScore: ");
            int maxScore = scanner.nextInt();
            progress.setMaxScore(maxScore);

            progress.setPlayerId(player.getPlayerId());

            player.getProgresses().add(progress);
        }
    }


    private void createCurrencies(Player player) {
        System.out.print("Сколько валют хотите добавить у игрока?: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("-------------------");
            Currency currency = new Currency();
            System.out.print("id: ");
            int id = scanner.nextInt();
            currency.setId(id);
            System.out.print("resourceId: ");
            int resourceId = scanner.nextInt();
            currency.setResourceId(resourceId);
            System.out.print("name: ");
            String name = scanner.next();
            currency.setName(name);
            System.out.print("count: ");
            int count = scanner.nextInt();
            currency.setCount(count);

            currency.setPlayerId(player.getPlayerId());

            player.getCurrencies().add(currency);
        }
    }

    private void createItems(Player player) {
        System.out.print("Сколько вещей хотите добавить у игрока?: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("-------------------");
            Item item = new Item();
            System.out.print("id: ");
            int id = scanner.nextInt();
            item.setId(id);
            System.out.print("resourceId: ");
            int resourceId = scanner.nextInt();
            item.setResourceId(resourceId);
            System.out.print("level: ");
            int level = scanner.nextInt();
            item.setLevel(level);
            System.out.print("count: ");
            int count = scanner.nextInt();
            item.setCount(count);

            item.setPlayerId(player.getPlayerId());

            player.getItems().add(item);
        }
    }

    private Currency updateCurrency(Currency currency) {
        System.out.println("Чтобы изменить ресурс введите -r, имя - -n, количество - -c, чтобы закончить введите -e");
        String parameter = scanner.next();
        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-r":
                    System.out.println("Введите ресурс");
                    int resourceId = scanner.nextInt();
                    currency.setResourceId(resourceId);
                    break;
                case "-n":
                    System.out.println("Введите имя");
                    String name = scanner.next();
                    currency.setName(name);
                    break;
                case "-c":
                    System.out.println("Введите количество");
                    int count = scanner.nextInt();
                    currency.setCount(count);
                    break;
            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();
        }
        return currency;

    }

    private Item updateItem(Item item) {
        System.out.println("Чтобы изменить ресурс введите -r, уровень - -l, количество - -c, чтобы закончить введите -e");
        String parameter = scanner.next();
        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-r":
                    System.out.println("Введите ресурс");
                    int resourceId = scanner.nextInt();
                    item.setResourceId(resourceId);
                    break;
                case "-l":
                    System.out.println("Введите уровень");
                    int level = scanner.nextInt();
                    item.setLevel(level);
                    break;
                case "-c":
                    System.out.println("Введите количество");
                    int count = scanner.nextInt();
                    item.setCount(count);
                    break;
            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();
        }
        return item;

    }

    private Progress updateProgress(Progress progress) {
        System.out.println("Чтобы изменить ресурс введите -r, счет - -s, максимальный счет - -m, чтобы закончить введите -e");
        String parameter = scanner.next();
        while (!parameter.equals("-e")) {
            switch (parameter) {
                case "-r":
                    System.out.println("Введите ресурс");
                    int resourceId = scanner.nextInt();
                    progress.setResourceId(resourceId);
                    break;
                case "-s":
                    System.out.println("Введите счет");
                    int score = scanner.nextInt();
                    if (score < progress.getMaxScore())
                        progress.setScore(score);
                    else
                        System.out.println("Счет не может быть больше максимального");
                    break;
                case "-m":
                    System.out.println("Введите максимальный счет");
                    int maxScore = scanner.nextInt();
                    progress.setMaxScore(maxScore);
                    break;
            }
            System.out.println("Введите следующую команду");
            parameter = scanner.next();
        }
        return progress;
    }
}
