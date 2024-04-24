package Models;


import Enums.TileTypes;

public class Tile {
    private TileTypes type;

    public Tile(TileTypes type) {
        this.type = type;
    }

    //TODO: No se usa el método changeType
    public void changeType(TileTypes newType) {
        this.type = newType;
    }

    public TileTypes getType() {
        return type;
    }

    public String getAsciiSymbol() {
        return type.getAsciiSymbol();
    }

    //TODO: No se usa el método getAsciiColor
    public String getAsciiColor() {
        return type.getAsciiColor();
    }
}
