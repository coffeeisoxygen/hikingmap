package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.GameState;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.manager.GameManager;
import com.coffeeisoxygen.model.utils.Point;

public class EndTile extends Tile {
    private GameManager gameManager;

    public EndTile(String tileNames, Point position, GameManager gameManager) {
        super(tileNames, TileType.END, position);
        this.gameManager = gameManager;
    }

    public EndTile(Point position, GameManager gameManager) {
        super(TileType.END, position);
        this.gameManager = gameManager;
    }

    @Override
    public void interact(IPlayer player) {
        System.out.println("Player " + player.getPlName() + " reached the end tile!");
        player.setAlive(false);
        gameManager.setGameState(GameState.WON);
    }
}