package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.utils.Point;

public class NormalTile extends Tile {
    public NormalTile(String tileNames, Point position) {
        super(tileNames, TileType.NORMAL, position);
    }

    public NormalTile(Point position) {
        super(TileType.NORMAL, position);
    }
}
