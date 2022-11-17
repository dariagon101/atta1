package ru.vsu.cs.g72.goncharova_d_n;

import ru.vsu.cs.g72.goncharova_d_n.model.Currency;
import ru.vsu.cs.g72.goncharova_d_n.model.Item;
import ru.vsu.cs.g72.goncharova_d_n.model.Player;
import ru.vsu.cs.g72.goncharova_d_n.model.Progress;
import ru.vsu.cs.g72.goncharova_d_n.service.*;
import ru.vsu.cs.g72.goncharova_d_n.service.bd.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static CRUD crud = new CRUD();
    public static Cache cache = crud.getCache();




    public static void main(String[] args) throws IOException, SQLException {
        System.out.println(cache.findPlayerById(10000));
        crud.updatePlayer();
        System.out.println(cache.findPlayerById(10000));

    }
}
