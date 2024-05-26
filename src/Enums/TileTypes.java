package Enums;

public enum TileTypes {
    Floor(0, "\u001B[48;5;250m", " . "),    // Color gris claro para el piso
    Sand(6, "\u001B[48;5;229m\u001B[38;5;229m", " , "),     // Color amarillo para arena
    Wall(8, "\u001B[48;5;160m\u001B[38;5;160m", " # "),     // Color rojo para paredes
    ShortGrass(1, "\u001B[42m\u001B[32m", " \" "), // Color verde claro para pasto corto
    MediumGrass(2, "\u001B[48;5;22m\u001B[38;5;22m", " ' "), // Color verde oscuro para pasto medio
    TallGrass(3, "\u001B[48;5;22m\u001B[38;5;22m", " ; "),  // Color verde muy oscuro para pasto alto
    Water(4, "\u001B[48;5;123m\u001B[38;5;123m", " ~ "),     // Color azul claro para agua normal
    DeepWater(5, "\u001B[48;5;18m\u001B[38;5;18m", " = "),  // Color azul oscuro para agua profunda
    Mountain(7, "\u001B[48;5;238m\u001B[38;5;238m", " ^ ");   // Color gris oscuro para montañas

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
