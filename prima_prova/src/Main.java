public class Main {
    public static void main(String[] args) {

        System.out.println("Partenza del processo");

        ThreadManager tm1 = new ThreadManager("TH1");
        ThreadManager tm2 = new ThreadManager("TH2");
        ThreadManager tm3 = new ThreadManager("TH3");

        tm1.start();
        tm2.start();
        tm3.start();

        
        System.out.println("Fine del processo");
    }
}