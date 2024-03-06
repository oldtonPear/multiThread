import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Insert the array length:\n-> ");

        int arrLength = scn.nextInt();

        double[] v = new double[arrLength];

        for (int i = 0; i < arrLength; i++) {
            v[i] = i;
        }

        System.out.print("Insert how many divisions do you wanna make:\n-> ");
        //how many times do you wanna divide the array between threads
        int divisionFactor = scn.nextInt();

        scn.close();

        //gap between min and max
        int inverseDevisionFactor = arrLength/divisionFactor;

        int min = 0, max = v.length;

        Worker w = new Worker(v, min, max, inverseDevisionFactor);
        Thread th = new Thread(w);

        long startTime = System.currentTimeMillis();

        th.start();

        double finalResult = 0;

        try {
            th.join();
            finalResult = w.getResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finalTime = System.currentTimeMillis();
        double time = finalTime-startTime;
        System.out.println("Obtained " + finalResult + " with a total time of: " + time + " ms");
    }
}