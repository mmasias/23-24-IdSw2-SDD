public enum TileTypes {
    Floor(1, "Color1", "Symbol1"),
    Sand(1, "Color2", "Symbol2"),
    Wall(0, "Color3", "Symbol3"),
    ShortGrass(1, "Color4", "Symbol4"),
    MediumGrass(2, "Color5", "Symbol5"),
    TallGrass(1, "Color6", "Symbol6"),
    Water(1, "Color7", "Symbol7"),
    DeepWater(2, "Color8", "Symbol8"),
    Mountain(1, "Color9", "Symbol9");

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