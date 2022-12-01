package parcial.ex02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferOscilante {

    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";    

    private Queue<Object> in = new LinkedList<Object>();
    private Queue<Object> ex = new LinkedList<Object>();

    private final Lock inMutex = new ReentrantLock(true);
    private final Lock exMutex = new ReentrantLock(true);
    private final Condition hayObjetos = inMutex.newCondition();
    
    private void swap() throws InterruptedException
    {
        inMutex.lock();
        while(in.isEmpty())
            hayObjetos.await();
        Queue<Object> tmp = in;
        in = ex;
        ex = tmp;
        System.out.println(RED+"SWAP.");
        inMutex.unlock();
    }

    public void add(Object object)
    {
        inMutex.lock();
        in.add(object);
        hayObjetos.signalAll();
        System.out.println(GREEN+"Elemento insertado.");
        inMutex.unlock();
    }

    public Object poll() throws InterruptedException
    {
        Object obj;
        exMutex.lock();
        if(ex.isEmpty())
            swap();
        obj = ex.poll();
        System.out.println(YELLOW+"Elemento extraido.");
        exMutex.unlock();
        return obj;
    }
}