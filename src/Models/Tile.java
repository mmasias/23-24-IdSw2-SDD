package Models;


import Enums.TileTypes;

public class Tile {
    private TileTypes type;

    public Tile(TileTypes type) {
        this.type = type;
    }

    public void changeType(TileTypes newType) {
        this.type = newType;
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
