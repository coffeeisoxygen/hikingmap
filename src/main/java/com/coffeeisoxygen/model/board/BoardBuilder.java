package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.interfaces.ITileFactory;

public class BoardBuilder {
    private int width;
    private int height;
    private ITileFactory tileFactory;

    public BoardBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public BoardBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public BoardBuilder setTileFactory(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
        return this;
    }

    public Board build() {
        return new Board(width, height, tileFactory);
    }
}