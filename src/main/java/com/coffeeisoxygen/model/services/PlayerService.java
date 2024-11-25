package com.coffeeisoxygen.model.services;

import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.IPlayerMovement;
import com.coffeeisoxygen.model.logger.MovementLogger;
import com.coffeeisoxygen.model.manager.BoardManager;
import com.coffeeisoxygen.model.manager.GameManager;
import com.coffeeisoxygen.model.manager.MovementManager;
import com.coffeeisoxygen.model.player.Player;
import com.coffeeisoxygen.model.player.PlayerMovement;
import com.coffeeisoxygen.model.utils.Point;

public class PlayerService {
    private IPlayer player;
    private IPlayerMovement playerMovement;
    private MovementManager movementManager;

    public void createPlayer(int plEnergy, String plName, BoardManager boardManager, GameManager gameManager) {
        this.player = Player.of(plEnergy, plName);
        this.playerMovement = new PlayerMovement(Point.of(0, 0)); // Default start position
        MovementLogger movementLogger = new MovementLogger(player, gameManager);
        this.movementManager = new MovementManager(playerMovement, movementLogger, player, boardManager, gameManager);
    }

    public void setStartPosition(Point position) {
        playerMovement.setPosition(position);
    }

    public void printPlayerStats() {
        System.out.println(player);
        System.out.println("Position: " + playerMovement.getPosition());
    }

    public void processMovementPlan(String movementPlan) {
        movementManager.processMovementPlan(movementPlan);
    }
}