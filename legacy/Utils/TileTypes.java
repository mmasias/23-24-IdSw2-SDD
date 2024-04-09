package Utils;
public enum TileTypes {
    Floor(0, "Color1", " _ "),
    Sand(6, "Color2", " . "),
    Wall(8, "Color3", " | "),
    ShortGrass(1, "Color4", " - "),
    MediumGrass(2, "Color5", " = "),
    TallGrass(3, "Color6", " / "),
    Water(4, "Color7", " ~ "),
    DeepWater(5, "Color8", " @ "),
    Mountain(7, "Color9", " ^ ");

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