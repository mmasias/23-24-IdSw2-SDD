package factory;

public class TileFactory {
    
    public TileFactory() {

    }

    public String createTile(int tileType) {
        String result = " ";
        switch(tileType) {
            case 1:
                result = "Floor";
                break;
            case 2:
                result = "Sand";
                break;
            case 3:
                result = "Wall";
                break;
            case 4:
                result = "ShortGrass";
                break;
            case 5:
                result = "MediumGrass";
                break;
            case 6:
                result = "TallGrass";
                break;
            case 7: 
                result = "Water";
                break;
            case 8:
                result = "DeepWater";
                break;
            case 9:
                result = "Mountain";
                break;
        
            
        }

        return result;
    }
}
