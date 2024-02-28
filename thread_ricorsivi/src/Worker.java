import java.util.Arrays;

public class Worker implements Runnable{

    private double result;
    private int maxNumbers;
    private int minIndex;;
    private int maxIndex;
    private double v[];

    Worker(double v[], int max, int minIndex, int maxIndex){
        this.v = v;
        this.maxNumbers = max;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public void run() {
        if(maxIndex-minIndex > maxNumbers){
            Worker w1 = new Worker(v, maxNumbers, minIndex, (maxIndex+maxNumbers)/2);
            Worker w2 = new Worker(v, maxNumbers, (maxIndex+maxIndex)/2, maxIndex);
            Thread th1 = new Thread(w1);
            Thread th2 = new Thread(w2);
            th1.start();
            th2.start();
            try {
                th1.join();
                th2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(w1.getResult() + w2.getResult());
        }
        else sumNumbers();
    }
    public void sumNumbers(){
        System.out.println(minIndex);
        System.out.println(maxIndex);
        System.out.println();
        double sum = 0;
        for (int i = minIndex; i < maxIndex; i++) {
            sum += v[i];
        }
        result = sum;
    }

    public double getResult() {
        return result;
    }
}
