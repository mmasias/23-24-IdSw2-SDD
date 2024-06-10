package Enums;

import java.util.Arrays;
import java.util.List;

public enum TransportTypes {
    Foot(1, "_Θ_", Arrays.asList(TileTypes.Floor, TileTypes.Sand, TileTypes.ShortGrass, TileTypes.MediumGrass)),
    Horse(2, "┌▄»", Arrays.asList(TileTypes.ShortGrass, TileTypes.MediumGrass, TileTypes.TallGrass)),
    Boat(1, "<≡>", Arrays.asList(TileTypes.Water, TileTypes.DeepWater)),
    MagicCarpet(2, "~Θ~", Arrays.asList(TileTypes.Mountain));

    private final int speed;
    private final String asciiSymbol;
    private final List<TileTypes> tilesItCanMoveThrough;

    TransportTypes(int speed, String asciiSymbol, List<TileTypes> tilesItCanMoveThrough) {
        this.speed = speed;
        this.asciiSymbol = asciiSymbol;
        this.tilesItCanMoveThrough = tilesItCanMoveThrough;
    }

    public String getAsciiSymbol() {
        return asciiSymbol;
    }

    public List<TileTypes> getTilesItCanMoveThrough() {
        return tilesItCanMoveThrough;
    }
}
