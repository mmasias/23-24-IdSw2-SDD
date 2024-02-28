package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapController {

    private Map map;
    private List <String[]> mapData;
    private FileReaderController fileReaderController;

    public MapController(Map map) {
        this.map = map;
        mapData = new ArrayList<>();
    }

    public void loadMapData() {
        mapData = fileReaderController.readCSV();
    }

    public void createMap() {

    }

    public Map getMap() {
        return map;
    }

    
    
}
