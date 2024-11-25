package com.coffeeisoxygen.model.strategy;

import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.utils.Point;

public class DefaultTilePlacementStrategy implements TilePlacementStrategy {
    @Override
    public void placeTile(IBoard board, ITile tile) {
        Point position = tile.getPosition();
        if (board.getTile(position) != null) {
            board.removeTile(position);
            System.out.println("Removed existing tile at position: " + position);
        }
        board.placeTile(tile);
        System.out.println("Placed tile at position: " + position);
    }
}