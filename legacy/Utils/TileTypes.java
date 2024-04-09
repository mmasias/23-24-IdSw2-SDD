package Utils;
public enum TileTypes {
    Floor(0, "#8B4513", " _ "),
    Sand(6, "#F5DEB3", " . "),
    Wall(8, "#8B008B", " | "),
    ShortGrass(1, "#32CD32", " - "),
    MediumGrass(2, "#228B22", " = "),
    TallGrass(3, "#006400", " / "),
    Water(4, "	#00BFFF", " ~ "),
    DeepWater(5, "#00008B", " @ "),
    Mountain(7, "#696969", " ^ ");

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