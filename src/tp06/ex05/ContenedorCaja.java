package tp06.ex05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ContenedorCaja {

    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";    
    private static final String PURPLE = "\u001B[35m";

    private final Lock lock = new ReentrantLock();
    private final Condition cajaVacia = lock.newCondition();
    private final Condition cajaLlena = lock.newCondition();

    private final int pesoLimite;
    private       int pesoActual = 0; 

    public ContenedorCaja(int pesoLimite)
    {
        this.pesoLimite = pesoLimite;
    }

    public void agregar(int peso) throws InterruptedException
    {
        lock.lock();
        while(pesoActual+peso > pesoLimite)
        {
            cajaLlena.signalAll();
            cajaVacia.await();
        }
        pesoActual += peso;
        System.out.printf("%sSe agregaron %dkgs a la caja.\n", BLUE, peso);
        lock.unlock();
    }

    public void retirar() throws InterruptedException
    {
        lock.lock();
        cajaLlena.await();
        pesoActual = -1;
        System.out.printf("%sSe ha retirado la caja.\n", RED);
        lock.unlock();
    }

    public void reponer()
    {
        lock.lock();
        pesoActual = 0;
        cajaVacia.signalAll();
        System.out.printf("%sSe ha repuesto la caja.\n", PURPLE);
        lock.unlock();
    }

    public boolean esValida()
    {
        return pesoActual >= 0;
    }
}
