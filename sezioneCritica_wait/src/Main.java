public class Main{
    public static void main(String[] args) {
        Counter counter = new Counter(0);

        int threadNumber = 2000;

        ThreadRunnable[] t = new ThreadRunnable[threadNumber];
        Thread[] th = new Thread[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            t[i] = new ThreadRunnable("th" + i, counter, i);
            th[i] = new Thread(t[i]);
            th[i].start();    
        }
        
        for (int i = 0; i < threadNumber; i++) {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Counter: " + counter.getCounter());
    }
}
