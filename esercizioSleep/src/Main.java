public class Main {
    public static void main(String[] args) {

        System.out.println("Partenza del processo");
        long start = System.currentTimeMillis(); //start time

        ThreadRunnable[] t = new ThreadRunnable[100];

        Thread[] th = new Thread[t.length];

        for (int i = 0; i < th.length; i++) {
            t[i] = new ThreadRunnable("TH" + i, (long) (Math.random()*10));

            th[i] = new Thread(t[i]);

            th[i].start();
        }

        for (int i = 0; i < th.length; i++) {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        long finish = System.currentTimeMillis();
        double totTime = finish-start;
        System.out.println("Fine del processo con tempo di: " + totTime + " ms");
    }
}