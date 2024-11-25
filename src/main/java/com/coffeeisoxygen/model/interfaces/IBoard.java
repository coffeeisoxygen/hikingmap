package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.utils.Point;

public interface IBoard {
    int getWidth();

    int getHeight();

    ITile[][] getTiles();

    void placeTile(ITile tile);

    ITile getTile(Point position);

    void removeTile(Point position);

    boolean isWithinBounds(Point position);

    Point getStartPosition();

    void setStartPosition(Point position);

    Point getEndPosition();

    void setEndPosition(Point position);
}