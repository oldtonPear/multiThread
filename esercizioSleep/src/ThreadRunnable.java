public class ThreadRunnable implements Runnable{

    private long time;
    private String nome;

    /**
     * costruttore passando il nome del Thread
     * @param nome
     */
    public ThreadRunnable(String nome, long time){
        this.nome = nome;
        this.time = time;
    }

    /**
     * compito del Thread
     */
    @Override
    public void run() {
        System.out.println("Partenza del Thread: " + nome);
        long start = System.currentTimeMillis();
        
        try {
            Thread.sleep((long) time);
        } catch (InterruptedException e) {e.printStackTrace();}

        long finish = System.currentTimeMillis();
        double totTime = finish-start;
        System.out.println("Fine del Thread: " + nome + " con tempo di: " + totTime + " ms");
    }
    
}
