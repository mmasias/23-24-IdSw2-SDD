package Models;

import java.sql.Time;
import java.util.ArrayList;

public class World {
    private Map map;
    private ArrayList<Entity> entities;
    private Time time;

    public World() {
        this.map = new Map();
        this.entities = new ArrayList<>();
        this.time = new Time();
    }

    // Getters y Setters
    public Map getMap() {
        return this.map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
