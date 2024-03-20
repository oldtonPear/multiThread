public class Counter {
    
    private int counter;
    
    Counter(int c){
        this.counter = c;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public synchronized void increase(String threadName, int priority){
        try {
            while(counter != priority){
                System.out.println("Thread: " + threadName + " waiting");
                wait();
                System.out.println("Thread: " + threadName + " released");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread " + threadName + " increased " + counter);
        counter += 1;
        notifyAll();
    }
}
