public class Main {
    public static void main(String[] args) {
        final int arrLength = 10000000;
        int[] v1 = new int[arrLength];
        int[] v2 = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            v1[i] = (int)(Math.random()*1000);
            v2[i] = (int)(Math.random()*1000);
        }

        Vettore v = new Vettore(v1, v2);

        Thread[] threads = new Thread[arrLength];
        
        for (int i = 0; i < arrLength; i++) {
            ThreadRunnable t = new ThreadRunnable(i, v);
            threads[i] = new Thread(t);
            threads[i].start();
            System.out.println("Thread " + i + " partito");
        }
        for (int i = 0; i < arrLength; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreadRunnable t = new ThreadRunnable(-1, v);
        Thread th = new Thread(t);
        th.start();
        System.out.println("Thread finale partito");
    }
}
