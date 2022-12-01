package tp06.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Mostrador {

    private static final String YELLOW = "\u001B[33m";
    private static final String WHITE = "\u001B[37m";

    Lock lock = new ReentrantLock();
    Condition hayPasteles = lock.newCondition();
    Queue<Pastel> que = new LinkedList<>();

    public void agregarPastel(Pastel pastel)
    {
        lock.lock();
        que.add(pastel);
        hayPasteles.signalAll();
        System.out.printf("%sSe agregó pastel al mostrador.\n", WHITE);
        lock.unlock();
    }

    public int retirarPastel() throws InterruptedException
    {
        lock.lock();
        while(que.isEmpty())
            hayPasteles.await();    

        int peso = que.poll().getPeso();
        System.out.printf("%sSe retiró un pastel del mostrador.\n", YELLOW);
        lock.unlock();
        return peso;
    }
}