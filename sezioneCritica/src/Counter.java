public class Counter {
    
    private int counter;
    
    Counter(int c){
        this.counter = c;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public synchronized void increase(int n, String threadName){
        System.out.println("Thread " + threadName + " increased " + counter + " by: " + n);
        counter += n;
    }
    public void decrease(int n, String threadName){
        synchronized(this){
            System.out.println("Thread " + threadName + " decreased " + counter + " by: " + n);
            counter -= n;
        }
    }
}
