package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.utils.Point;

public class DangerTile extends Tile {
    public DangerTile(String tileNames, Point position) {
        super(tileNames, TileType.DANGER, position);
    }

    public DangerTile(Point position) {
        super(TileType.DANGER, position);
    }

    @Override
    public void interact(IPlayer player) {
        System.out.println("Player " + player.getPlName() + " stepped on a danger tile!");
        player.decreaseEnergy(player.getPlEnergy() - player.getPlEnergy());
        player.setAlive(false);
    }

}
