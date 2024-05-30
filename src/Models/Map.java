package Models;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import Enums.TileTypes;

public class Map {
    private Tile[][] tiles;

    public Map() {
        this.tiles = new Tile[64][64];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile(TileTypes.Floor);
            }
        }
    }

    public void updateTile(Point point, Tile newTile) {
        int x = point.getX();
        int y = point.getY();
        if (x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length) {
            tiles[x][y] = newTile;
        }
    }

    public Tile getTile(Point point) {
        int x = point.getX();
        int y = point.getY();
        if (x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length) {
            return tiles[x][y];
        }
        return null;
    }

    public Point getRandomTilePositionOfType(TileTypes type) {
        List<Point> validLocations = new ArrayList<>();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].getType() == type) {
                    validLocations.add(new Point(i, j));
                }
            }
        }
        if (!validLocations.isEmpty()) {
            Random random = new Random();
            return validLocations.get(random.nextInt(validLocations.size()));
        }
        return null;
    }

    public int getHeight() {
        return tiles.length;
    }

    public int getWidth() {
        return tiles[0].length;
    }
}
