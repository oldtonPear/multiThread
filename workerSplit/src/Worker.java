public class Worker implements Runnable{

    private double result;
    private int minIndex;
    private int maxIndex;
    private int inverseDivisionFactor;
    private double v[];

    /**
     * Creates a new Worker Class
     * @param v array with values to operate with
     * @param minIndex the min index of the array in wich this worker will operate
     * @param maxIndex the max index of the array in wich this worker will operate
     * @param inverseDivisionFactor maxIndex - minIndex, needed to find the remaining parts of the array
     */
    Worker(double v[], int minIndex, int maxIndex, int inverseDivisionFactor){
        this.v = v;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.inverseDivisionFactor = inverseDivisionFactor;
    }

    @Override
    public void run() {
        //We've got a gap
        if(maxIndex-minIndex < inverseDivisionFactor){
            result = v[maxIndex];
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
