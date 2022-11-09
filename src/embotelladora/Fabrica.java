package embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fabrica {
    
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";

    private final int capacidadCaja = 10;  
    private final int capacidadAlmacen = 100;

    int cajaVino = 0;
    int cajaAgua = 0;
    int almacen = 0;

    final Lock lock = new ReentrantLock(true);
    final Condition cajaVinoNoLlena = lock.newCondition();
    final Condition cajaAguaNoLlena = lock.newCondition();
    final Condition cajaLlena = lock.newCondition();  

    final Lock lockAlmacen = new ReentrantLock(true);
    final Condition almacenLleno = lockAlmacen.newCondition();
    final Condition almacenVacio = lockAlmacen.newCondition();

    public void empaquetar()
    {
        lock.lock();
        try { 
            while(!cajaVinoLlena() && !cajaAguaLlena())
                cajaLlena.await(); 
            
            if(cajaVinoLlena())
            {
                cajaVino = 0;
                System.out.printf("%sEmpaquetada caja de Vino.%s\n", YELLOW, status());
                cajaVinoNoLlena.signalAll();
            }
            if(cajaAguaLlena())
            {
                cajaAgua = 0;
                System.out.printf("%sEmpaquetada caja de Agua.%s\n", YELLOW, status());
                cajaAguaNoLlena.signalAll();
            }
            
            } catch (InterruptedException e) {} 
        finally {        
            lock.unlock();
        }
    }

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

    public void embotellarVino()
    {
        lock.lock();
        try { 
            while(cajaVinoLlena())
                cajaVinoNoLlena.await(); } catch (InterruptedException e) {} 
        finally {
            cajaVino++;
            System.out.printf("%sEmbotellado Vino.\t%s\n", PURPLE, status());
            if(cajaVinoLlena())
                cajaLlena.signalAll();
            lock.unlock();
        }   
    }

    public void embotellarAgua()
    {
        lock.lock();
        try { 
            while(cajaAguaLlena())
                cajaAguaNoLlena.await(); } catch (InterruptedException e) {} 
        finally {
            cajaAgua++;
            System.out.printf("%sEmbotellada Agua.\t%s\n", BLUE, status());
            if(cajaAguaLlena())
                cajaLlena.signalAll();
            lock.unlock();
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

    private boolean cajaVinoLlena()
    {
        return cajaVino >= capacidadCaja;
    }

    private boolean cajaAguaLlena()
    {
        return cajaAgua >= capacidadCaja;
    }

    private String status()
    {
        return String.format("\t%sVino: [%d/%d] - Agua: [%d/%d] - Almacen: [%d/%d]", RED, cajaVino, capacidadCaja, cajaAgua, capacidadCaja, almacen, capacidadAlmacen);
    }
}
