public class Main {
    public static void main(String[] args) {
        
        int arrLength = 17;
        double[] v = new double[arrLength];

        for (int i = 0; i < arrLength; i++) {
            v[i] = i;
        }

        //how many times do you wanna divide the array between threads
        int divisionFactor = 5;

        //gap between min and max
        int inverseDevisionFactor = arrLength/divisionFactor;

        //substractions between the arrLength and the max index on the array i can operate with
        int gap = arrLength-inverseDevisionFactor * divisionFactor;

        Worker[] w;
        Thread[] th;

        double finalResult = 0;

        int min = 0, max = inverseDevisionFactor;

        /*
        WE GOT A GAP
        example: arrLength = 17, divisionFactor = 3
        I am able to split the array up to index 15 (17/3)
        I have to create a Thread with index 15-16
        so I make a Thread using arrLength-gap(15) and arrLength-1(16)
        I'm operating the final section of the array before the other parts but it isn't a problem
        */
        if(gap != 0){
            w = new Worker[divisionFactor+1];
            th = new Thread[divisionFactor+1];
            w[w.length-1] = new Worker(v, arrLength-gap, arrLength-1); 
            th[th.length-1] = new Thread(w[w.length-1]);
            th[th.length-1].start();
        }
        else{
            w = new Worker[divisionFactor];
            th = new Thread[divisionFactor];
        }
        
        /*
        I split the array divisionFactor times
        min and max updates together using inverseDivisionFactor
        */
        for (int i = 0; i < divisionFactor; i++) {
            System.out.println(min + " " + max);
            w[i] = new Worker(v, min, max); 
            th[i] = new Thread(w[i]);
            th[i].start();
            min += inverseDevisionFactor;
            max += inverseDevisionFactor;
        }

        /*
        Joining Threads
        */
        for (int i = 0; i < th.length; i++) {
            try {
                th[i].join();
                finalResult += w[i].getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(finalResult);
    }
}