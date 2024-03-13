public class Consumatore implements Runnable{

    private Produttore p;
    private int itemConsumati;

    Consumatore(String name, Produttore p){
        this.p = p;
        itemConsumati = 0;
    }

    @Override
    public void run() {
        int item;
        do{
            item = p.getCounter();
            if(item == 1){
                itemConsumati++;
            }
        }while(item != -1);
    }

    public int getItemConsumati() {
        return itemConsumati;
    }
}
