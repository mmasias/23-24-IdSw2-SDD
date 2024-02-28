package Models;

public abstract class Character extends Entity {
    private Transport transportInUse;
    private Transport[] availableTransports;

    public Character(int x, int y, Transport[] availableTransports) {
        super(x, y);
        this.availableTransports = availableTransports;
        transportInUse = availableTransports[0];
    }

    public Transport getTransportInUse() {
        return transportInUse;
    }

    public Transport[] getAvailableTransports() {
        return availableTransports;
    }

    public void setTransportInUse(Transport transportInUse) {
        this.transportInUse = transportInUse;
    }

    public void setAvailableTransports(Transport[] availableTransports) {
        this.availableTransports = availableTransports;
    }
}

