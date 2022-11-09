package embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Almacen {
    
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";

    private final int capacidadAlmacen = 100;
    private int almacen = 0;

    final Lock lockAlmacen = new ReentrantLock(true);
    final Condition almacenLleno = lockAlmacen.newCondition();
    final Condition almacenVacio = lockAlmacen.newCondition();

    public void guardarEnAlmacen()
    {
        lockAlmacen.lock();
        try {
            while(esAlmacenLleno())
                almacenVacio.await();
            almacen++;
            System.out.printf("%sGuardada caja en el almacen.%s\n", GREEN, status());
            if(esAlmacenLleno())
                almacenLleno.signalAll(); 
        } 
        catch (InterruptedException e) {}
        finally {

            lockAlmacen.unlock();
        }
    }

    public void transportar()
    {
        System.out.printf("%sLlega Camion de reparto.%s\n", WHITE, status());
        lockAlmacen.lock();
        try {
        while(!esAlmacenLleno())
            almacenLleno.await(); 
        almacen = 0;
        System.out.printf("%sSale Camion de reparto.\t%s\n", CYAN, status());
        } 
        catch (InterruptedException e) {}
        finally {
            almacenVacio.signalAll();
            lockAlmacen.unlock();
        }
    }

    private boolean esAlmacenLleno()
    {
        return almacen >= capacidadAlmacen;
    }

    private String status()
    {
        return String.format("\t%sAlmacen: [%d/%d]", RED, almacen, capacidadAlmacen);
    }
}
