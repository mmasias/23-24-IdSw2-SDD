import java.time.LocalTime;
import java.util.Random;

public class ShoppingCenter implements TimeObserver {


    private LocalTime startTime = LocalTime.of(8, 30); // 8:30 AM
    private LocalTime endTime = LocalTime.of(21, 30);  // 9:30 PM
    //private String Time;
    private Random arrivalProbability = new Random();
    Customer initCustomer;    
    TIME inTime = new TIME(startTime, endTime);
    
    public void Start(){inTime.StarDay();}
    CashRegister inCashRegister;
    public void onTimeChange(String time, boolean isOpen) {

    
        if (isOpen) {
            System.out.println("La hora es " + time + ". La tienda está abierta.");// Aqui realizar tareas cuadno esta abierto

            if(time.equals("9:00 AM")){ inCashRegister = new CashRegister();}            
            
            if (arrivalProbability.nextInt(100) < 40){ initCustomer.addCustomer();}
            
        } else {
            System.out.println("La hora es " + time + ". La tienda está cerrada.");// Aqui realizar tareas cuadno esta cerrado
            
        }
    }


    

    //Agregar metodos de cliente
    
}


