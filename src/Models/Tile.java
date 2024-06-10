package Models;


import Enums.TileTypes;

public class Tile {
    private TileTypes type;

    public Tile(TileTypes type) {
        this.type = type;
    }

    public TileTypes getType() {
        return type;
    }

    public String getAsciiSymbol() {
        return type.getAsciiSymbol();
    }
    
    public String getAsciiColor() {
        return type.getAsciiColor();
    }
}
