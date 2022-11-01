package tp06.ex03;

//MON
public class Abridores {
    
    public static final String RED = "\u001B[31m";    
    public static final String PURPLE = "\u001B[35m";

    private int stock;
    
    public Abridores(int stock)
    {
        this.stock = stock;
    }

    public synchronized void agarrar(int id)
    {
        while(stock<=0)
            try {wait();} catch (InterruptedException e) {}
    
        stock--;
        System.out.printf("%sEl soldado [%d] ha agarrado un abridor. Quedan %d abridores.\n", RED ,id, stock);
    }

    public synchronized void dejar(int id)
    {
        stock++;
        notifyAll();
        System.out.printf("%sEl soldado [%d] ha dejado un abridor. Ahora hay %d abridores.\n", PURPLE, id, stock);
    }
}
