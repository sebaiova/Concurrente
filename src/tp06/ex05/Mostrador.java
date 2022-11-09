package tp06.ex05;

import java.util.LinkedList;
import java.util.Queue;

class Mostrador {

    Queue<Pastel> que = new LinkedList<>();

    public synchronized void agregarPastel(Pastel pastel)
    {
        que.add(pastel);
        notifyAll();
    }

    public synchronized int retirarPastel(Pastel pastel)
    {
        while(que.isEmpty())
            try {wait();} catch (InterruptedException e) {}

        return que.poll().getPeso();
    }
}