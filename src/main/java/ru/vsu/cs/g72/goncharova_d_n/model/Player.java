package ru.vsu.cs.g72.goncharova_d_n.model;

import java.util.List;
import java.util.Objects;

public class Player {

    private int playerId;
    private String nickname;
    private List<Progress> progresses;
    private List<Currency> currencies;
    private List<Item> items;


    public int getPlayerId() {
        return playerId;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
