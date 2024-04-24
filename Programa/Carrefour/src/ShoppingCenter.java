

public class ShoppingCenter implements TimeObserver {

    public void onTimeChange(String time, boolean isOpen) {
        if (isOpen) {
            System.out.println("La hora es " + time + ". La tienda está abierta.");// Aqui realizar tareas cuadno esta abierto
            
        } else {
            System.out.println("La hora es " + time + ". La tienda está cerrada.");// Aqui realizar tareas cuadno esta cerrado
            
        }
    }

    //Agregar metodos de cliente
    
}


