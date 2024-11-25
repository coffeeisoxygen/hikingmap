package com.coffeeisoxygen.model.manager;

import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.strategy.TilePlacementStrategy;
import com.coffeeisoxygen.model.utils.Point;

public class BoardManager {
    private IBoard board;
    private TilePlacementStrategy placementStrategy;

    public BoardManager(IBoard board, TilePlacementStrategy placementStrategy) {
        this.board = board;
        this.placementStrategy = placementStrategy;
    }

    public void placeTile(ITile tile) {
        placementStrategy.placeTile(board, tile);
    }

    public ITile getTile(Point position) {
        return board.getTile(position);
    }

    public IBoard getBoard() {
        return board;
    }

    public void printBoard() {
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                ITile tile = board.getTile(Point.of(x, y));
                if (tile != null) {
                    System.out.print(tile.getTileType().name().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}