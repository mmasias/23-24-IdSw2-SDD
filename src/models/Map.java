package Models;

public class Map {
    private static int maxHeight = 64;
    private static int maxLong = 64;

    private Tile[][] tiles;

    public Map() {
        tiles = new Tile[maxHeight][maxLong];
    }

    public Tile[][] getMap() {
        return tiles;
    }
    
}
