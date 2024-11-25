package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.utils.Point;

public class StartTile extends Tile {
    public StartTile(String tileNames, Point position) {
        super(tileNames, TileType.START, position);
    }

    public StartTile(Point position) {
        super(TileType.START, position);
    }
}
