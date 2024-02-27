public class Matriz {
    private Azulejo[][] matriz;

    public Matriz(Azulejo[][] matriz) {
        this.matriz = matriz;
    }

    public Azulejo getElemento(int fila, int columna) {
        return matriz[fila][columna];
    }

    public void setElemento(int fila, int columna, Azulejo valor) {
        matriz[fila][columna] = valor;
    }
}