package Utils;

public enum Movement {
    UP('W'), DOWN('S'), LEFT('A'), RIGHT('D');

    char key;

    Movement(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }
}