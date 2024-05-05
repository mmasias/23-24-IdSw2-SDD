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

    public String getAsciiSymbol() {
        return type.getAsciiSymbol();
    }
}
