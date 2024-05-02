import java.util.LinkedList;

public class Queue {
    private static Queue instance;
    private LinkedList<Customer> queue;

    private Queue() {
        this.queue = new LinkedList<>();
    }

    public static Queue getInstance() {
        if (instance == null) {
            instance = new Queue();
        }
        return instance;
    }

    public void Enqueue(Customer customer) {
        queue.addLast(customer);
    }

    public Customer Dequeue() {
        return queue.pollFirst();
    }

    public int GetSize() {
        return queue.size();
    }

    public LinkedList<Customer> GetQueue() {
        return queue;
    }
}
