package com.coffeeisoxygen.model.player;

import java.util.Objects;

import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.utils.Point;

public class Player implements IPlayer {
    private String plName;
    private int plScore;
    private int plEnergy;
    private boolean isAlive;
    private Point position;

    private Player(int plEnergy, String plName) {
        this.plEnergy = plEnergy;
        this.plName = plName;
        this.plScore = 0;
        this.isAlive = true;
    }

    public static Player of(int plEnergy, String plName) {
        return new Player(plEnergy, plName);
    }

    @Override
    public String getPlName() {
        return plName;
    }

    @Override
    public void setPlName(String plName) {
        this.plName = plName;
    }

    @Override
    public int getPlScore() {
        return plScore;
    }

    @Override
    public void setPlScore(int plScore) {
        this.plScore = plScore;
    }

    @Override
    public int getPlEnergy() {
        return plEnergy;
    }

    @Override
    public void setPlEnergy(int plEnergy) {
        this.plEnergy = plEnergy;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return plScore == player.plScore &&
                plEnergy == player.plEnergy &&
                isAlive == player.isAlive &&
                Objects.equals(plName, player.plName) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plName, plScore, plEnergy, isAlive, position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "plName='" + plName + '\'' +
                ", plScore=" + plScore +
                ", plEnergy=" + plEnergy +
                ", isAlive=" + isAlive +
                ", position=" + position +
                '}';
    }

    @Override
    public void decreaseEnergy(int energy) {
        this.plEnergy -= energy;
        if (this.plEnergy <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public void increaseEnergy(int energy) {
        this.plEnergy += energy;
    }
}
