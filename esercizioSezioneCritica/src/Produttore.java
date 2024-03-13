public class Produttore implements Runnable{

    private int counter;
    private int maxCounter;
    private boolean finished;

    Produttore(int counter, int maxCounter){
        this.counter = counter;
        this.maxCounter = maxCounter;
        finished = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxCounter; i++) {
            counter++;
        }
        finished = true;
    }
    
    public synchronized int getCounter() {
        if(counter > 0){
            counter--;
            return 1;
        }
        if(finished){
            return -1;
        }
        return 0;
    }
}
