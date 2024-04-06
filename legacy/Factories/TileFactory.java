package Factories;

import Models.Tile;
import Utils.TileTypes;


public class TileFactory {
    private Tile newTile;

    
    public TileFactory() {
        
    }

    public Tile createTile (int number) {
        
       for (TileTypes types : TileTypes.values()) {
            if (types.getTileNumber() == number) {
                newTile = new Tile(types);
            }
       }
       return newTile;
    }
}
