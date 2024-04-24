package Models;

import java.util.ArrayList;
import java.util.List;

public class World {
    private Map map;
    private List<Entity> entities;
    private Time time;

    public World() {
        this.map = new Map();
        this.entities = new ArrayList<>();
        this.time = new Time();
    }

    //TODO: No se usa el método simulateCycle
    public void simulateCycle() {
        updateTime();
    }

    public void addEntity(Entity newEntity) {
        this.entities.add(newEntity);
    }

    private void updateTime() {
        this.time.advanceTime();
    }

    public Map getMap() {
        return this.map;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public Time getTime() {
        return this.time;
    }

    //TODO: No se usa el método setMap
    public void setMap(Map map) {
        this.map = map;
    }

    //TODO: No se usa el método setEntities
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}