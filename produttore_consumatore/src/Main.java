import java.util.Scanner;
public class Main{

    private static int[] menu(){
        int[] data = new int[2];

        Scanner scn = new Scanner(System.in);

        System.out.print("Inserisci la capienza della coda:\n->");
        int capienzaCoda = scn.nextInt();

        System.out.print("Inserisci il numero di Produttori:\n->");
        int numeroProduttori = scn.nextInt();

        System.out.print("Inserisci il numero di Consumatori:\n->");
        int numeroConsumatori = scn.nextInt();

        if(Math.abs(numeroConsumatori-numeroProduttori)>capienzaCoda){
            System.out.println("Non è possibile eseguire questa operazione!");
            System.out.println("Il numero di Produttori e Consumatori è troppo sbilanciato rispetto alla capienza!");
            menu();
        }

        data[0] = numeroProduttori;
        data[1] = numeroConsumatori;

        scn.close();

        return data;
    }
    public static void main(String[] args) {
        int[] data = menu();

        int numeroProduttori = data[0];
        int numeroConsumatori = data[1];
        
        Buffer buffer = new Buffer();

        Produttore[] produttori = new Produttore[numeroProduttori];
        Consumatore[] consumatori = new Consumatore[numeroConsumatori];

        Thread[] th = new Thread[numeroConsumatori + numeroProduttori];

        for (int i = 0; i < numeroProduttori; i++) {
            produttori[i] = new Produttore("Produttore " + i, buffer);
        }
        for (int i = 0; i < numeroConsumatori; i++) {
            consumatori[i] = new Consumatore("Consumatore " + i, buffer);
        }
        for (int i = 0; i < numeroProduttori; i++) {
            th[i] = new Thread(produttori[i]);
            th[i].start();
        }
        for (int i = 0; i < numeroConsumatori; i++) {
            th[i+numeroProduttori] = new Thread(consumatori[i]);
            th[i+numeroProduttori].start();
        }
        
        for (int i = 0; i < th.length; i++) {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Lista alla fine:");
        //verifica che sia vuota se n produttori == n consumatori
        buffer.printQueue();
    }
}
