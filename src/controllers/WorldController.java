package Controllers;

import Models.Character;
import Models.Entity;
import Models.Time;
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
        timeController.advanceTime(15);

        for (Entity entity : world.getEntities()) {
            movementController.moveCharacter((Character) entity);
        }
    }

    public void setWorldEntities(ArrayList<Entity> entities) {
        world.setEntities(entities);
    }

    public void setWorldTime(Time time) {
        world.setTime(time);
    }
}