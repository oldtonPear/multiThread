import java.util.LinkedList;

public class ListHandler {
    
    private int counter;
    private LinkedList<Person> ll;
    
    ListHandler(int c){
        this.counter = c;
        this.ll = new LinkedList<Person>();
    }
    
    public int getCounter() {
        return counter;
    }
    
    public synchronized void addPerson(String threadName, int priority, Person p){
        try {
            while(counter != priority){
                System.out.println("Thread: " + threadName + " waiting");
                wait();
                System.out.println("Thread: " + threadName + " released");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread " + threadName + " increased " + counter);
        counter += 1;
        ll.push(p);
        notifyAll();
    }
    public void printList(){
        for (Person person : ll) {
            System.out.println(person.toString());
        }
    }
}
