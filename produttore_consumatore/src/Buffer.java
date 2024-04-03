import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    
    private Queue<Product> queue;
    private boolean bufferFull;
    private boolean bufferEmpty;
    
    Buffer(){
        this.queue = new LinkedList<Product>();
        bufferFull = false;
        bufferEmpty = true;
    }
    
    public synchronized void addProduct(String threadName, Product p){
        try {
            while(bufferFull){
                //System.out.println("Thread: " + threadName + " waiting");
                wait();
                //System.out.println("Thread: " + threadName + " released");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread: " + threadName + " added product");
        queue.add(p);
        printQueue();

        if(queue.size() >= 4) bufferFull = true;
        bufferEmpty = false;

        notifyAll();
    }

    public synchronized void removeProduct(String threadName){
        try {
            while(bufferEmpty){
                //System.out.println("Thread: " + threadName + " waiting");
                wait();
                //System.out.println("Thread: " + threadName + " released");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread: " + threadName + " removed product");
        queue.poll();
        printQueue();

        bufferFull = false;
        if(queue.size() == 0) bufferEmpty = true;
        
        notifyAll();
    }
    public void printQueue(){
        for (Product product : queue) {
            System.out.println(product.getId());
        }
    }
}
