import java.util.List;
import java.util.ArrayList;

public class Customer {

    private static List<Customer> customers = new ArrayList<>();
    private static int nextId = 1; 

    int id;
    int numberOfPacks;

    public void addCustomer() { 
        Customer newCustomer = new Customer();
        newCustomer.id = nextId++; 
        newCustomer.numberOfPacks = packsRandom();
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
