package Enums;

public enum TileTypes {
    Floor(0, "\u001B[37m", "."),    // White dot for floor
    Sand(6, "\u001B[33m", ","),     // Yellow comma for sand
    Wall(8, "\u001B[31m", "#"),     // Red hash for walls
    ShortGrass(1, "\u001B[35m", "\""), // Purple double quotes for short grass
    MediumGrass(2, "\u001B[32m", "'"), // Green single quote for medium grass
    TallGrass(3, "\u001B[34m", ";"),  // Blue semicolon for tall grass
    Water(4, "\u001B[36m", "~"),     // Cyan tilde for water
    DeepWater(5, "\u001B[34m", "="),  // Dark blue equals for deep water
    Mountain(7, "\u001B[30m", "^");   // Black caret for mountains

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
