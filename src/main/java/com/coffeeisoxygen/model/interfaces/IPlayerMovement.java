package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.utils.Point;

public interface IPlayerMovement {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    Point getPosition();
    void setPosition(Point position);
}
