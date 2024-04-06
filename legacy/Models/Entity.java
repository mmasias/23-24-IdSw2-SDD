package Models;

import Utils.Point;

public abstract class Entity {
    private Point position;

    public Entity(int x, int y) {
        this.position = new Point(x, y);
    }

    public Point getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setPosition(int x, int y) {
        this.position.setLocation(x, y);
    }
}
