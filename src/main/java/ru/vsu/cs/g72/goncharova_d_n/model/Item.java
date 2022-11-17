package ru.vsu.cs.g72.goncharova_d_n.model;

import java.util.Objects;

public class Item {

    private int id;
    private int playerId;
    private int resourceId;
    private int count;
    private int level;


    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public int getCount() {
        return count;
    }

    public int getLevel() {
        return level;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item items = (Item) o;
        return id == items.id &&
                playerId == items.playerId &&
                resourceId == items.resourceId &&
                count == items.count &&
                level == items.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, resourceId, count, level);
    }

    @Override
    public String toString() {
        return " {" + "\n" +
                "\"id\" : " + id +
                ", \n \"playerId\" : " + playerId +
                ", \n \"resourceId\" : " + resourceId +
                ", \n \"count\" : " + count +
                ", \n \"level\" : " + level + "\n" +
                "} ";

    }
}
