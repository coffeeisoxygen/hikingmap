package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.utils.Point;

public interface ITile extends Interactable {

    String getTileNames();

    void setTileNames(String tileNames);

    TileType getTileType();

    void setTileType(TileType tileType);

    Point getPosition();

    void setPosition(Point position);

}