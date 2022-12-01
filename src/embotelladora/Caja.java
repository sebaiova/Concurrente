package embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Caja {
    
    private final int capacidad = 10;
    private final String colorA, colorB, tipo;
    private int stock = 0;
    
    private final Lock lock = new ReentrantLock(true); 
    private final Condition cajaVacia = lock.newCondition(); 

    public Caja(String tipo, String colorA, String colorB)
    {
        this.tipo = tipo;
        this.colorA = colorA;
        this.colorB = colorB;
    }

    public void empaquetar() throws InterruptedException
    {
        lock.lock();
        stock = 0;
        System.out.printf("%sEmpaquetada caja de %s. [%d/%d]\n", colorB, tipo, stock, capacidad);
        lock.unlock();
    }

    public boolean agregar() throws InterruptedException
    {
        lock.lock();
        while(esLlena())
            cajaVacia.await();
        stock++;
        System.out.printf("%sEmbotellado %s. [%d/%d]\n", colorA, tipo, stock, capacidad);
        boolean llena = esLlena();
        lock.unlock();
        return llena;
    }

    private boolean esLlena()
    {
        return stock>=capacidad;
    }
}
