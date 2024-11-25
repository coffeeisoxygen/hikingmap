package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.utils.Point;

public interface ITileFactory {
    ITile createTile(String tileNames, TileType tileType, Point position);

    ITile createTile(TileType tileType, Point position);
}