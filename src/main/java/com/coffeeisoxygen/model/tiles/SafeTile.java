package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.utils.Point;

public class SafeTile extends Tile {
    public SafeTile(String tileNames, Point position) {
        super(tileNames, TileType.SAFE, position);
    }

    public SafeTile(Point position) {
        super(TileType.SAFE, position);
    }
}
