public class ThreadRunnable implements Runnable{

    private String name;
    private Counter c;
    private int priority;

    ThreadRunnable(String name, Counter c, int priority){
        this.name = name;
        this.c = c;
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + name + " startig");

        c.increase(name, priority);
        
        System.out.println("Thread: " + name + " ending");
    }
    
}
