public class Main {

    private static int[] v1;
    private static int[] v2;
    private static int[] v3;
    public static void main(String[] args) {
        final int arrLength = 1000000;
        v1 = new int[arrLength];
        v2 = new int[arrLength];
        v3 = new int[arrLength];
        
        Thread[] threads = new Thread[arrLength];

        /*for (int i = 0; i < arrLength; i++) {
            v1[i] = (int)(Math.random()*1000);
            v2[i] = (int)(Math.random()*1000);
            v3[i] = v1[i] + v2[i];
            System.out.println(v3[i]);
        }*/
        
        for (int i = 0; i < arrLength; i++) {
            v1[i] = (int)(Math.random()*1000);
            v2[i] = (int)(Math.random()*1000);
            ThreadRunnable t = new ThreadRunnable(i);
            threads[i] = new Thread(t);
            threads[i].start();
            System.out.println("Thread " + i + " partito");
        }
        for (int i = 0; i < arrLength; i++) {
            try {
                threads[i].join();
                System.out.println(v3[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static int[] getV1() {
        return v1;
    }
    public static int[] getV2() {
        return v2;
    }
    public static int[] getV3() {
        return v3;
    }

}
