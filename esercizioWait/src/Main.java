public class Main{
    public static void main(String[] args) {
        ListHandler listHandler = new ListHandler(0);

        int threadNumber = 100;

        ThreadRunnable[] t = new ThreadRunnable[threadNumber];
        Thread[] th = new Thread[threadNumber];
        Person[] people = new Person[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            people[i] = new Person("gigi", "verde", "prova");
            t[i] = new ThreadRunnable("th" + i, listHandler, i, people[i]);
            th[i] = new Thread(t[i]);
            th[i].start();    
        }
        
        for (int i = 0; i < threadNumber; i++) {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Counter: " + listHandler.getCounter());
        listHandler.printList();
    }
}
