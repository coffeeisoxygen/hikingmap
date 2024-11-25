package com.coffeeisoxygen;

import com.coffeeisoxygen.model.manager.GameManager;

public class App {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }
}