package ru.vsu.cs.g72.goncharova_d_n.model;

import java.util.Objects;

public class Currency {

    private int id;
    private int playerId;
    private int resourceId;
    private String name;
    private int count;


    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency that = (Currency) o;
        return id == that.id &&
                playerId == that.playerId &&
                resourceId == that.resourceId &&
                count == that.count &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, resourceId, name, count);
    }

    @Override
    public String toString() {
        return " {" + "\n" +
                " \"id\" : " + id +
                ", \n \"playerId\" : " + playerId +
                ", \n \"resourceId\" : " + resourceId +
                ", \n \"name\" : " + name +
                ", \n \"count\" : " + count + "\n" +
                "} ";

    }
}
