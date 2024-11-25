package com.coffeeisoxygen.model.strategy;

import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.ITile;

public interface TilePlacementStrategy {
    void placeTile(IBoard board, ITile tile);
}