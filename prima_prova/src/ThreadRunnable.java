public class ThreadRunnable implements Runnable{

    private String nome;

    /**
     * costruttore passando il nome del Thread
     * @param nome
     */
    public ThreadRunnable(String nome){
        this.nome = nome;
    }

    /**
     * compito del Thread
     */
    @Override
    public void run() {
        System.out.println("Partenza del Thread: " + nome);


        System.out.println("Fine del Thread: " + nome);
    }
    
}
