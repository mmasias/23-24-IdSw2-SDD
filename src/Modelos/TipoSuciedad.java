enum TipoSuciedad {
    LIMPIO(0),
    SUCIO(1),
    MUY_SUCIO(2),
    SUPER_SUCIO(3);

    private final int value;

    TipoSuciedad(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
   }
}