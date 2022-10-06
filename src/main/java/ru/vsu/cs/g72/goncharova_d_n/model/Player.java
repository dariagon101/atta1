package ru.vsu.cs.g72.goncharova_d_n.model;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private int playerId;
    private String nickname;
    private ArrayList<Progress> progresses;
    private ArrayList<Currency> currencies;
    private ArrayList<Item> items;


    public int getPlayerId() {
        return playerId;
    }

    public String getNickname() {
        return nickname;
    }

    public ArrayList<Progress> getProgresses() {
        return progresses;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player players = (Player) o;
        return playerId == players.playerId &&
                Objects.equals(nickname, players.nickname) &&
                Objects.equals(progresses, players.progresses) &&
                Objects.equals(currencies, players.currencies) &&
                Objects.equals(items, players.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, nickname, progresses, currencies, items);
    }

    @Override
    public String toString() {
        return "Players{" +
                "playerId=" + playerId +
                ", nickname='" + nickname + '\'' +
                ", progresses=" + progresses +
                ", currencies=" + currencies +
                ", items=" + items +
                '}';
    }
}
