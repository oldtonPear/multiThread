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
        if(maxIndex-minIndex > inverseDivisionFactor){
            Worker w0 = new Worker(v, minIndex, (minIndex+maxIndex)/2, inverseDivisionFactor);
            Worker w1 = new Worker(v, (minIndex+maxIndex)/2, maxIndex, inverseDivisionFactor);
            Thread th0 = new Thread(w0);
            Thread th1 = new Thread(w1);

            th0.start();
            th1.start();
            
            try {
                th0.join();
                th1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = w0.getResult() + w1.getResult();
        }

        //standard situation
        else for (int i = minIndex; i < maxIndex; i++) {
            result += v[i];
        }
    }

    public double getResult() {
        return result;
    }
}
