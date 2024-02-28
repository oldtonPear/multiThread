public class Main {
    public static void main(String[] args) {
        double[] v = new double[10];
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }
        Worker w = new Worker(v, 4, 0, v.length); 
        Thread th = new Thread(w);
        th.start();
    }
}
