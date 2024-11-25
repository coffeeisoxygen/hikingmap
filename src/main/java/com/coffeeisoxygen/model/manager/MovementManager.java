package com.coffeeisoxygen.model.manager;

import java.util.LinkedList;
import java.util.Queue;

import com.coffeeisoxygen.model.enums.GameState;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.IPlayerMovement;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.logger.MovementLogger;
import com.coffeeisoxygen.model.utils.Point;

public class MovementManager {
    private IPlayerMovement playerMovement;
    private MovementLogger movementLogger;
    private IPlayer player;
    private BoardManager boardManager;
    private GameManager gameManager;

    public MovementManager(IPlayerMovement playerMovement, MovementLogger movementLogger, IPlayer player,
            BoardManager boardManager, GameManager gameManager) {
        this.playerMovement = playerMovement;
        this.movementLogger = movementLogger;
        this.player = player;
        this.boardManager = boardManager;
        this.gameManager = gameManager;
    }

    public void processMovementPlan(String movementPlan) {
        Queue<Character> movements = new LinkedList<>();
        for (char move : movementPlan.toLowerCase().toCharArray()) {
            movements.add(move);
        }

        while (!movements.isEmpty()) {
            if (!player.isAlive() || gameManager.getGameState() != GameState.PLAYING) {
                System.out.println("Player is not alive or game is not in playing state. Stopping movement.");
                break;
            }

            char move = movements.poll();
            Point fromPosition = playerMovement.getPosition();
            switch (move) {
                case 'l' -> playerMovement.moveLeft();
                case 'u' -> playerMovement.moveUp();
                case 'r' -> playerMovement.moveRight();
                case 'd' -> playerMovement.moveDown();
                case 's' -> {
                    // Rest, do nothing
                }
                default -> System.out.println("Invalid movement command: " + move);
            }
            Point toPosition = playerMovement.getPosition();

            // Check if the new position is within bounds
            if (!boardManager.getBoard().isWithinBounds(toPosition)) {
                player.setAlive(false);
                gameManager.setGameState(GameState.LOST);
                System.out.println("Player moved out of bounds and is now dead.");
                break;
            }

            player.decreaseEnergy(1);
            ITile tile = boardManager.getTile(toPosition);
            if (tile != null) {
                tile.interact(player);
            }
            movementLogger.logMovement(move, fromPosition, toPosition, tile);
        }

        // Check if the player has reached the end tile
        if (player.isAlive() && !playerMovement.getPosition().equals(boardManager.getBoard().getEndPosition())) {
            player.setAlive(false);
            gameManager.setGameState(GameState.LOST);
            System.out.println("Player failed to reach the end tile and is now dead.");
        }
    }
}