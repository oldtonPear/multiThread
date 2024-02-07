public class ThreadRunnable implements Runnable{

    private String nome;
    private int index;

    
    /**
     * costruttore passando il nome del Thread
     * @param nome
     */
    public ThreadRunnable(String nome){
        this.nome = nome;
        index = Integer.parseInt("" + nome.substring(2));
    }

    /**
     * compito del Thread
     */
    @Override
    public void run() {
        Main.getV3()[index] = Main.getV1()[index] + Main.getV2()[index];
    }
    
}
