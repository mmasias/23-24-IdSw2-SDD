package Controllers;

import Models.World;

import java.util.ArrayList;

import Models.Map;

public class WorldController {
    private World world;
    private TimeController timeController;
    private MovementController movementController;
    private MapController mapController;

    public WorldController(World world, TimeController timeController, MovementController movementController,
            MapController mapController) {
        this.world = world;
        this.timeController = timeController;
        this.movementController = movementController;
        this.mapController = mapController;
    }

    public void loadWorld() {
        mapController.loadMapData();
        mapController.createMap();
        world.setMap(mapController.getMap());
    }

    public void simulateWorldCycle() {
        timeController.advanceTime();

        for (Entity entity : world.getEntities()) {
            movementController.moveCharacter(entity);
        }
    }

    public void setWorldEntities(ArrayList<Entity> entities) {
        world.setEntities(entities);
    }

    public void setWorldTime(long currentTimeMillis) {
        timeController.setCurrentTime(currentTimeMillis);
    }
}