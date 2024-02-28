public class Vettore {
    private int[] v1;
    private int[] v2;
    private int[] v3;
    Vettore(int[] v1, int[] v2){
        this.v1 = v1;
        this.v2 = v2;
        v3 = new int[v1.length];
    }

    public void printVettore(){
        for (int i = 0; i < v3.length; i++) {
            System.out.println(v3[i]);
        }
    }
    public void sommaComponente(int index){
        v3[index] = v1[index] + v2[index];
    }
}