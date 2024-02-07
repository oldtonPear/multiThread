public class ThreadManager extends Thread{

    /**
     * costruttore passando il nome del Thread
     * @param nome
     */
    public ThreadManager(String nome){
        super(nome);
    }

    /**
     * compito del Thread
     */
    @Override
    public void run(){
        System.out.println("Partenza del Thread: " + getName());


        System.out.println("Fine del Thread: " + getName());
    }
}
