package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.manager.GameManager;
import com.coffeeisoxygen.model.utils.Point;

public class TileFactory implements ITileFactory {
    private GameManager gameManager;

    public TileFactory(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public ITile createTile(String tileNames, TileType tileType, Point position) {
        switch (tileType) {
            case SAFE:
                return new SafeTile(tileNames, position);
            case DANGER:
                return new DangerTile(tileNames, position);
            case START:
                return new StartTile(tileNames, position);
            case END:
                return new EndTile(tileNames, position, gameManager);
            case NORMAL:
            default:
                return new NormalTile(tileNames, position);
        }
    }

    @Override
    public ITile createTile(TileType tileType, Point position) {
        switch (tileType) {
            case SAFE:
                return new SafeTile(position);
            case DANGER:
                return new DangerTile(position);
            case START:
                return new StartTile(position);
            case END:
                return new EndTile(position, gameManager);
            case NORMAL:
            default:
                return new NormalTile(position);
        }
    }
}