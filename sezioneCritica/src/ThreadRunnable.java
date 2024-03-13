public class ThreadRunnable implements Runnable{

    private String name;
    private Counter c;

    ThreadRunnable(String name, Counter c){
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + name + " startig");

        c.increase((int) (Math.random()*10), name);
        
        System.out.println("Thread: " + name + " ending");
    }
    
}
