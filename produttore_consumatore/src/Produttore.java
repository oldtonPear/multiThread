public class Produttore implements Runnable{

    private String name;
    private Buffer buffer;

    Produttore(String name, Buffer buffer){
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //System.out.println("Thread: " + name + " starting");

        buffer.addProduct(name, new Product("55151"));
        
        //System.out.println("Thread: " + name + " ending");
    }
    
}
