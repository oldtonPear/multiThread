public class Main {
    public static void main(String[] args) {

        System.out.println("Partenza del processo");

        //Thread with ThreadRunnable
        ThreadRunnable t1 = new ThreadRunnable("TH1");
        ThreadRunnable t2 = new ThreadRunnable("TH2");
        ThreadRunnable t3 = new ThreadRunnable("TH3");

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);

        th1.start();
        th2.start();
        th3.start();

/* 
        //Thread with ThreadExtendingThread
        
        ThreadExtendingThread th1 = new ThreadExtendingThread("TH1");
        ThreadExtendingThread th2 = new ThreadExtendingThread("TH2");
        ThreadExtendingThread th3 = new ThreadExtendingThread("TH3");

        th1.start();
        th2.start();
        th3.start();

        */
        
        System.out.println("Fine del processo");
    }
}