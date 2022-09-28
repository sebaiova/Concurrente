package tp04.ex04;

import java.util.concurrent.Semaphore;

public class Imprenta {
    
    private final Semaphore[] semImpresoras;
    private final Semaphore[] semHojas;

    public Imprenta(int numeroImpresorasA, int numeroImpresorasB)
    {
        semImpresoras = new Semaphore[2];
        semHojas = new Semaphore[2];

        semImpresoras[0] = new Semaphore(numeroImpresorasA);
        semImpresoras[1] = new Semaphore(numeroImpresorasB);

        semHojas[0] = new Semaphore(0);
        semHojas[1] = new Semaphore(0);
    }

    public void procesarHoja(int tipo)
    {
        try { semHojas[tipo].acquire(); } catch (InterruptedException e) {}
        try { Thread.sleep(400);} catch (InterruptedException e) {}
        semImpresoras[tipo].release();
    }

    public void mandarAImprimir(int tipo)
    {
        if(tipo==2)
            tipo=0;

        try { semImpresoras[tipo].acquire(); } catch (InterruptedException e) {}
        semHojas[tipo].release();
    }
}
