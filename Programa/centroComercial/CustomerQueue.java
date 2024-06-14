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
        customers.add(customer);
        maxQueueLength = Math.max(maxQueueLength, customers.size());
        System.out.println("Customer with ID " + customer.getId() + " added to the queue.");
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
