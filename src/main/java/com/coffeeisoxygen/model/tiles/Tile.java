package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.utils.Point;

public abstract class Tile implements ITile {

    private String tileNames;
    private TileType tileType;
    private Point position;

    protected Tile(String tileNames, TileType tileType, Point position) {
        this.tileNames = tileNames;
        this.tileType = tileType;
        this.position = position;
    }

    protected Tile(TileType tileType, Point position) {
        this.tileType = tileType;
        this.position = position;
    }

    @Override
    public String getTileNames() {
        return tileNames;
    }

    @Override
    public void setTileNames(String tileNames) {
        this.tileNames = tileNames;
    }

    @Override
    public TileType getTileType() {
        return tileType;
    }

    @Override
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void interact(IPlayer player) {
        // Default interaction does nothing
    }

}
