public class ThreadRunnable implements Runnable{

    private int index;
    Vettore v;

    /**
     * @param threadNumber numero del Thread
     */
    public ThreadRunnable(int threadNumber, Vettore v){
        index = threadNumber;
        this.v = v;
    }

    /**
     * compito del Thread
     */
    @Override
    public void run() {
        if(index == -1){
            v.printVettore();
            return;
        }
        v.sommaComponente(index);
    }
}
