public class ThreadRunnable implements Runnable{

    private int index;

    
    /**
     * costruttore passando il nome del Thread
     * @param nome
     */
    public ThreadRunnable(int threadNumber){
        index = threadNumber;
    }

    /**
     * compito del Thread
     */
    @Override
    public void run() {
        Main.getV3()[index] = Main.getV1()[index] + Main.getV2()[index];
    }
    
}
