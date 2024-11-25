package com.coffeeisoxygen.model.logger;

import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.manager.GameManager;
import com.coffeeisoxygen.model.utils.Point;

public class MovementLogger {
    private IPlayer player;
    private GameManager gameManager;

    public MovementLogger(IPlayer player, GameManager gameManager) {
        this.player = player;
        this.gameManager = gameManager;
    }

    public void logMovement(char command, Point fromPosition, Point toPosition, ITile tile) {
        System.out.println("Command: " + command);
        System.out.println("From Position: (" + fromPosition.getX() + ", " + fromPosition.getY() + ")");
        System.out.println("To Position: (" + toPosition.getX() + ", " + toPosition.getY() + ")");
        if (tile != null) {
            System.out.println("Tile: " + tile.getTileType());
        } else {
            System.out.println("Tile: None (Out of bounds)");
        }
        System.out.println("Is Alive: " + player.isAlive());
        System.out.println("Energy: " + player.getPlEnergy());
        System.out.println("Game State: " + gameManager.getGameState());
        System.out.println();
    }
}