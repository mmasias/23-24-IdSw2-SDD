import java.util.LinkedList;

public class Queue {

    LinkedList<Customer> queue;

    public Queue() {this.queue = new LinkedList<>();}

    public void Enqueue(Customer customer) {queue.addLast(customer);}

    public void Dequeue(){queue.pollFirst();}

    public int GetSize() {return queue.size();}
    
}
