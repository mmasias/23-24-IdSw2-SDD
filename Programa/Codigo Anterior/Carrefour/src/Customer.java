import java.util.List;
import java.util.ArrayList;



public class Customer implements TimeObserver {
    
    private static List<Customer> customers = new ArrayList<>();
    private static int nextId = 1;     
    int id;
    int numberOfPacks;
    int TimeShopping;

    public void onTimeChange(String time, boolean isOpen) {
        if (isOpen) {
            Queue colaSuper = Queue.getInstance();
            for (Customer customer : customers) {
                if (customer.TimeShopping <= 0) {
                    colaSuper.Enqueue(customer);
                }
                customer.TimeShopping--;
            }
        }  
    }

    public void addCustomer() { 
        Customer newCustomer = new Customer();
        newCustomer.id = nextId++; 
        newCustomer.numberOfPacks = packsRandom();
        newCustomer.TimeShopping = 5 + (int)(Math.random()*(10-5)+1);
        customers.add(newCustomer); 
    }

    public int getPacks(int id) { 
        for (Customer customer : customers) {
            if (customer.id == id) {
                return customer.numberOfPacks;
            }
        }
        return 0;
    }

    private int packsRandom() {
        return 5 + (int)(Math.random() * ((15 - 5) + 1));
    }
}
