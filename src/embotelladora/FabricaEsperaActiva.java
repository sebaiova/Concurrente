package embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FabricaEsperaActiva {
    
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";

    private final int capacidadCaja = 10;  

    int cajaVino = 0;
    int cajaAgua = 0;

    final Lock lockVino = new ReentrantLock();
    final Condition cajaVinoNoLlena = lockVino.newCondition();

    final Lock lockAgua = new ReentrantLock();
    final Condition cajaAguaNoLlena = lockAgua.newCondition();

    public void empaquetar()
    {
        if(cajaVinoLlena())
        {
            lockVino.lock();
            cajaVino = 0;
            System.out.printf("%sEmpaquetada caja de Vino.%s\n", YELLOW, status());
            cajaVinoNoLlena.signalAll();
            lockVino.unlock();                
        }

        if(cajaAguaLlena())
        {
            lockAgua.lock();
            cajaAgua = 0;
            System.out.printf("%sEmpaquetada caja de Agua.%s\n", YELLOW, status());
            cajaAguaNoLlena.signalAll();
            lockAgua.unlock();
        }
    }

    public void embotellarVino()
    {
        lockVino.lock();
        try { 
            while(cajaVinoLlena())
                cajaVinoNoLlena.await(); } catch (InterruptedException e) {} 
        finally {
            cajaVino++;
            System.out.printf("%sEmbotellado Vino.%s\n", PURPLE, status());
            lockVino.unlock();
        }   
    }

    public void embotellarAgua()
    {
        lockAgua.lock();
        try { 
            while(cajaAguaLlena())
                cajaAguaNoLlena.await(); } catch (InterruptedException e) {} 
        finally {
            cajaAgua++;
            System.out.printf("%sEmbotellada Agua.%s\n", BLUE, status());
            lockAgua.unlock();
        }
    }

    private boolean cajaVinoLlena()
    {
        boolean ret;
        lockVino.lock();
        ret = cajaVino >= capacidadCaja;
        lockVino.unlock();
        return ret;
    }

    private boolean cajaAguaLlena()
    {
        boolean ret;
        lockAgua.lock();
        ret = cajaAgua >= capacidadCaja;
        lockAgua.unlock();
        return ret;
    }

    private String status()
    {
        return String.format("\t%sVino: [%d/%d] - Agua: [%d/%d]", RED, cajaVino, capacidadCaja, cajaAgua, capacidadCaja);
    }
}
