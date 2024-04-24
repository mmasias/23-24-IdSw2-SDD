package Models;

public class Map {
    private Tile[][] tiles;

    public Map() {
        this.tiles = new Tile[64][64];
    }

    public void updateTile(Point point, Tile newTile) {
        Tile oldTile = getTile(point);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] == oldTile) {
                    tiles[i][j] = newTile;
                }
            }
        }

    }
    public Tile getTile(Point point) {
        int[] tileLocation = point.getLocation();
        int xCoord = tileLocation[0];
        int yCoord = tileLocation[1];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (i == xCoord && j == yCoord) {
                    return tiles[i][j];
                }
            }
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
