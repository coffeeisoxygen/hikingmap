package com.coffeeisoxygen.model.player;

import com.coffeeisoxygen.model.interfaces.IPlayerMovement;
import com.coffeeisoxygen.model.utils.Point;

public class PlayerMovement implements IPlayerMovement {
    private Point position;

    public PlayerMovement(Point startPosition) {
        this.position = startPosition;
    }

    @Override
    public void moveUp() {
        position = Point.of(position.getX() - 1, position.getY());
    }

    @Override
    public void moveDown() {
        position = Point.of(position.getX() + 1, position.getY());
    }

    @Override
    public void moveLeft() {
        position = Point.of(position.getX(), position.getY() - 1);
    }

    @Override
    public void moveRight() {
        position = Point.of(position.getX(), position.getY() + 1);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }
}
