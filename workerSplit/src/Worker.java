import java.util.Arrays;

public class Worker implements Runnable{

    private double result;
    private int minIndex;;
    private int maxIndex;
    private double v[];

    Worker(double v[], int minIndex, int maxIndex){
        this.v = v;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public void run() {
        //We've got a gap == 1 case
        if(minIndex == maxIndex){
            result = v[maxIndex];
            return;
        } 

        //We've got a gap == 2 case
        if(maxIndex-minIndex == 1){
            result += v[maxIndex];
        }

        //standard situation
        for (int i = minIndex; i < maxIndex; i++) {
            result += v[i];
        }
    }

    public double getResult() {
        return result;
    }
}
