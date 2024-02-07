public class ThreadExtendingThread extends Thread{

    /**
     * costruttore passando il nome del Thread
     * @param nome
     */
    public ThreadExtendingThread(String nome){
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
