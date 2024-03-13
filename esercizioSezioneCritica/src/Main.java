public class Main{
    public static void main(String[] args) {
        int threadNumber = 4;

        Produttore p = new Produttore(0, 1000000);
        Thread prodThread = new Thread(p);
        prodThread.start();

        Consumatore[] t = new Consumatore[threadNumber];
        Thread[] th = new Thread[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            t[i] = new Consumatore("th" + i, p);
            th[i] = new Thread(t[i]);
        }
        for (int i = 0; i < threadNumber; i++) {
            th[i].start();    
        }
        
        int sum = 0;
        for (int i = 0; i < threadNumber; i++) {
            try {
                th[i].join();
                sum += t[i].getItemConsumati();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
    }
}
