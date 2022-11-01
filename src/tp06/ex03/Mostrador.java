package tp06.ex03;

import java.util.LinkedList;
import java.util.Queue;

//MON
public class Mostrador {

    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";

    Queue<Integer> fila = new LinkedList<>();
    private final String tipo;
    private final int id;

    public Mostrador(String tipo, int id)
    {
        this.tipo = tipo;
        this.id = id;
    }

    public synchronized void hacerFila(int soldado)
    {
        fila.add(soldado);
        System.out.printf("%sSoldado [%d] hace fila en mostrador de %s número [%d].\n", GREEN, soldado, tipo, id);
    }

    public synchronized void agarrarBandeja(int soldado)
    {
        while(fila.peek()!=soldado)
            try {wait();} catch (InterruptedException e) {}

        fila.poll();
        notifyAll();
        System.out.printf("%sSoldado [%d] agarró una bandeja del mostrador de %s número [%d].\n", YELLOW, soldado, tipo, id);
    }

    public synchronized int sizeFila()
    {
        return fila.size();
    }
}
