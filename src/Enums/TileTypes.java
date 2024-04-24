package Enums;

public enum TileTypes {
    Floor(0, "\u001B[37m", " _ "), 
    Sand(6, "\u001B[33m", " . "), 
    Wall(8, "\u001B[31m", " | "), 
    ShortGrass(1, "\u001B[35m", " - "),
    MediumGrass(2, "\u001B[31m", " = "),
    TallGrass(3, "\u001B[32m", " / "),
    Water(4, "\u001B[36m", " ~ "), 
    DeepWater(5, "\u001B[34m", " @ "), 
    Mountain(7, "\u001B[30m", " ^ "); 

    private final int tileNumber;
    private final String asciiColor;
    private final String asciiSymbol;

    TileTypes(int tileNumber, String asciiColor, String asciiSymbol) {
        this.tileNumber = tileNumber;
        this.asciiColor = asciiColor;
        this.asciiSymbol = asciiSymbol;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public String getAsciiColor() {
        return asciiColor;
    }

    public String getAsciiSymbol() {
        return asciiSymbol;
    }
}
