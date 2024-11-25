package com.coffeeisoxygen.model.manager;

import com.coffeeisoxygen.model.board.BoardBuilder;
import com.coffeeisoxygen.model.enums.GameState;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.services.PlayerService;
import com.coffeeisoxygen.model.strategy.DefaultTilePlacementStrategy;
import com.coffeeisoxygen.model.tiles.TileFactory;

public class GameManager {
    private PlayerService playerService;
    private BoardManager boardManager;
    private GameState gameState;
    private ITileFactory tileFactory;

    public GameManager() {
        this.tileFactory = new TileFactory(this);
        this.boardManager = new BoardManager(new BoardBuilder()
                .setWidth(5)
                .setHeight(5)
                .setTileFactory(tileFactory)
                .build(), new DefaultTilePlacementStrategy());
        this.playerService = new PlayerService();
        initializePlayerService();
        this.gameState = GameState.PLAYING;
    }

    private void initializePlayerService() {
        this.playerService.createPlayer(100, "PlayerOne", getBoardManager(), this);
    }

    public BoardManager getBoardManager() {
        return boardManager;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void startGame() {
        // Set the player's start position
        playerService.setStartPosition(boardManager.getBoard().getStartPosition());

        // Place some tiles on the board
        //boardManager.placeTile(tileFactory.createTile(TileType.SAFE, Point.of(2, 2)));
        //boardManager.placeTile(tileFactory.createTile(TileType.DANGER, Point.of(1, 0)));

        // Print the board
        boardManager.printBoard();

        // Process the movement plan
        String movementPlan = "lllluuu";
        playerService.processMovementPlan(movementPlan);

        // Print player stats
        playerService.printPlayerStats();

        // Check game state
        if (gameState == GameState.WON) {
            System.out.println("Congratulations! You won the game.");
        } else if (gameState == GameState.LOST) {
            System.out.println("Game over. You lost the game.");
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}