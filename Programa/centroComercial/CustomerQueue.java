import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<Customer> customers;
    private int maxQueueLength = 0;

    public CustomerQueue() {
        this.customers = new LinkedList<>();
    }

    public int getSize() {
        return customers.size();
    }

    public void addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
            System.out.println("Customer added to queue: " + customer.getId());
        }
    }

    public Customer serveNextCustomer() {
        return customers.poll();
    }
    public int getQueueSize() {
        return customers.size();
    }

    public boolean isEmpty() {
        return customers.isEmpty();
    }

    public void removeCustomer() {
        if (!this.customers.isEmpty()) {
            Customer servedCustomer = this.customers.poll();
            System.out.println("Customer with ID " + servedCustomer.getId() + " served and removed from the queue.");
        }
    }

    public Customer peekCustomer() {
        return this.customers.peek();
    }

    public Queue<Customer> getCustomers() {
        return customers;
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }
}
