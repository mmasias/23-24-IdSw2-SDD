package Controllers;

import java.util.ArrayList;
import java.util.List;


import Factories.TileFactory;
import Models.Map;
import Models.Tile;

public class MapController {

    private Map map;
    private List<String[]> mapData;
    private FileReaderController fileReaderController;
    private TileFactory tileCreation;
    private Tile[] tiles;
    

    public MapController(Models.Map map2) {
        this.map = map2;
        mapData = new ArrayList<>();
        fileReaderController = new FileReaderController();
    }

    public void loadMapData() {
        mapData = fileReaderController.readCSV();
    }

    public void createMap() {

        loadMapData();
        String[] mapDataArray = new String[mapData.size()];
        mapDataArray =  (String[]) mapData.toArray();
        int[] integerMapData = new int[0];

        for (int i = 0; i < mapData.size(); i++) {
            integerMapData[i] = Integer.parseInt(mapDataArray[i]);
            tiles[i] = tileCreation.createTile(i);
        }

        map.setMapOneDimensional(tiles);
        
        
    }

    public Map getMap() {
        return map;
    }

}
