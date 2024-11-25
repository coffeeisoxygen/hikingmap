package com.coffeeisoxygen.model.interfaces;

public interface IPlayer {
    String getPlName();

    void setPlName(String plName);

    int getPlScore();

    void setPlScore(int plScore);

    int getPlEnergy();

    void setPlEnergy(int plEnergy);

    boolean isAlive();

    void setAlive(boolean isAlive);

    void decreaseEnergy(int energy);

    void increaseEnergy(int energy);
}