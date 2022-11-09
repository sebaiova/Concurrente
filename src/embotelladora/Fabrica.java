package embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fabrica {
    
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private Caja cajaVino = new Caja("Vino", PURPLE, YELLOW);
    private Caja cajaAgua = new Caja("Agua", BLUE, YELLOW);

    private final Lock lock = new ReentrantLock(true);
    private final Condition cajaLlena = lock.newCondition();
    
    private final int NADA = 0x0;
    private final int VINO = 0x1;
    private final int AGUA = 0x2; 
    private       int tarea = 0;

    public void empaquetar() throws InterruptedException
    {
        lock.lock();
        while(tarea==NADA)
            cajaLlena.await();

        if((tarea & AGUA) == AGUA)
        {
            cajaAgua.empaquetar();
            tarea &= ~AGUA;
        }
        if((tarea & VINO) == VINO)
        {
            cajaVino.empaquetar();
            tarea &= ~VINO;
        }
        lock.unlock();
    }

    public void embotellarVino() throws InterruptedException
    {
        if(cajaVino.agregar())
        {
            lock.lock();
            tarea |= VINO;
            cajaLlena.signalAll();
            lock.unlock();
        }
    }
    public void embotellarAgua() throws InterruptedException
    {
        if(cajaAgua.agregar())
        {
            lock.lock();
            tarea |= AGUA;
            cajaLlena.signalAll();
            lock.unlock();
        }
    }
}
