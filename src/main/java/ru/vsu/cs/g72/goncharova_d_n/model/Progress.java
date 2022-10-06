package ru.vsu.cs.g72.goncharova_d_n.model;

import java.util.Objects;

public class Progress {

    private int id;
    private int playerId;
    private int resourceId;
    private int score;
    private int maxScore;


    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Progress that = (Progress) o;
        return id == that.id &&
                playerId == that.playerId &&
                resourceId == that.resourceId &&
                score == that.score &&
                maxScore == that.maxScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, resourceId, score, maxScore);
    }

    @Override
    public String toString() {
        return "Progresses{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", resourceId=" + resourceId +
                ", score=" + score +
                ", maxScore=" + maxScore +
                '}';
    }
}
