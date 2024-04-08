package Models;

public abstract class Entity {
    private Point position;

    private Transport transportInUse;

    public Entity(Point startingPosition, Transport startingTransport) {
        this.position = startingPosition;
        this.transportInUse = startingTransport;
    }

    public Point getPosition() {
        return position;
    }

    public Transport getTransportInUse() {
        return transportInUse;
    }

    public void moveTo(Point newPosPoint) {
        this.position = newPosPoint;
    }

    public void changeTransport(Transport newTransport) {
        this.transportInUse = newTransport;
    }


}
