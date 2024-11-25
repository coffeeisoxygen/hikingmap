package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.utils.Point;

public class Board implements IBoard {
    private int width;
    private int height;
    private ITile[][] tiles;
    private ITileFactory tileFactory;
    private Point startPosition;
    private Point endPosition;

    protected Board(int width, int height, ITileFactory tileFactory) {
        this.width = width;
        this.height = height;
        this.tiles = new ITile[width][height];
        this.tileFactory = tileFactory;
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize all tiles as normal tiles
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = tileFactory.createTile(TileType.NORMAL, Point.of(x, y));
            }
        }

        // Place one start tile and one end tile
        startPosition = Point.of(width - 1, height - 1);
        endPosition = Point.of(0, 0);
        tiles[startPosition.getX()][startPosition.getY()] = tileFactory.createTile(TileType.START, startPosition);
        tiles[endPosition.getX()][endPosition.getY()] = tileFactory.createTile(TileType.END, endPosition);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public ITile[][] getTiles() {
        return tiles;
    }

    @Override
    public void placeTile(ITile tile) {
        Point position = tile.getPosition();
        if (isWithinBounds(position)) {
            tiles[position.getX()][position.getY()] = tile;
        } else {
            System.out.println("Position out of bounds: " + position);
        }
    }

    @Override
    public ITile getTile(Point position) {
        if (isWithinBounds(position)) {
            return tiles[position.getX()][position.getY()];
        }
        return null;
    }

    @Override
    public void removeTile(Point position) {
        if (isWithinBounds(position)) {
            tiles[position.getX()][position.getY()] = tileFactory.createTile(TileType.NORMAL, position);
        } else {
            System.out.println("Position out of bounds: " + position);
        }
    }

    @Override
    public boolean isWithinBounds(Point position) {
        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }

    @Override
    public Point getStartPosition() {
        return startPosition;
    }

    @Override
    public void setStartPosition(Point position) {
        if (isWithinBounds(position)) {
            tiles[startPosition.getX()][startPosition.getY()] = tileFactory.createTile(TileType.NORMAL, startPosition);
            startPosition = position;
            tiles[startPosition.getX()][startPosition.getY()] = tileFactory.createTile(TileType.START, startPosition);
        } else {
            System.out.println("Position out of bounds: " + position);
        }
    }

    @Override
    public Point getEndPosition() {
        return endPosition;
    }

    @Override
    public void setEndPosition(Point position) {
        if (isWithinBounds(position)) {
            tiles[endPosition.getX()][endPosition.getY()] = tileFactory.createTile(TileType.NORMAL, endPosition);
            endPosition = position;
            tiles[endPosition.getX()][endPosition.getY()] = tileFactory.createTile(TileType.END, endPosition);
        } else {
            System.out.println("Position out of bounds: " + position);
        }
    }
}