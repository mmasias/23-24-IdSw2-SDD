package Models;

import Enums.TransportTypes;

public class Transport {
    private TransportTypes type;

    public Transport(TransportTypes type) {
        this.type = type;
    }

    public TransportTypes getType() {
        return type;
    }

    //TODO: No se usa el método getSpeed
    public int getSpeed() {
        return type.getSpeed();
    }

    public String getAsciiSymbol() {
        return type.getAsciiSymbol();
    }
}
