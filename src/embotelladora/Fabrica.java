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

    int cajaVino = 0;
    int cajaAgua = 0;

    final Lock lock = new ReentrantLock(true);
    final Condition cajaVinoNoLlena = lock.newCondition();
    final Condition cajaAguaNoLlena = lock.newCondition();
    final Condition cajaLlena = lock.newCondition();  

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
        return String.format("\t%sVino: [%d/%d] - Agua: [%d/%d]", RED, cajaVino, capacidadCaja, cajaAgua, capacidadCaja);
    }
}
