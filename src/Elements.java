
public enum Elements{
    ZONA_LIMPIA("."),
    ZONA_SUCIA("..."),
    ZONA_MAS_SUCIA("ooo"),
    ZONA_MUY_SUCIA("OOO"),
    ZONA_SUCISIMA("***"),
    ASPIRADORA("(0)"),
    GATO("^-^"),
    SOFA("[####]");

    private String value;

    private Elements(String value){
        this.value = value;
    }
    
    public String getElement(){
        return value;
    }

    public void setElement(String elemento) {
        this.value = elemento;
    }
}