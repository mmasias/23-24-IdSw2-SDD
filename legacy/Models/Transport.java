package Models;

import Utils.TransportTypes;

public class Transport {
    private TransportTypes type;

    public Transport(TransportTypes type) {
        this.type = type;
    }

    public TransportTypes getType() {
        return type;
    }

    public int getSpeed() {
        return type.getSpeed();
    }

    public String getAsciiSymbol() {
        return type.getAsciiSymbol();
    }
}