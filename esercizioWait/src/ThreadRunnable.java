public class ThreadRunnable implements Runnable{

    private String name;
    private ListHandler listHandler;
    private int priority;
    private Person person;

    ThreadRunnable(String name, ListHandler listHandler, int priority, Person person){
        this.name = name;
        this.listHandler = listHandler;
        this.priority = priority;
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + name + " startig");

        listHandler.addPerson(name, priority, person);
        
        System.out.println("Thread: " + name + " ending");
    }
    
}
