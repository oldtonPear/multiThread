public class Consumatore implements Runnable{

    private String name;
    private Buffer buffer;

    Consumatore(String name, Buffer buffer){
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //System.out.println("Thread: " + name + " starting");

        buffer.removeProduct(name);
        
        //System.out.println("Thread: " + name + " ending");
    }
    
}
