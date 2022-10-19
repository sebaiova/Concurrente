package tp05.ex02;

import java.util.concurrent.Semaphore;

public class Veterinaria {
    
    private final Semaphore perroSemaphore;
    private final Semaphore gatoSemaphore;
    private final Semaphore mutex;
    private final int capacidad;
   // private final int  

    public Veterinaria(int capacidad)
    {
        perroSemaphore = new Semaphore(capacidad);
        gatoSemaphore = new Semaphore(capacidad);
        mutex = new Semaphore(1);
        this.capacidad = capacidad;
    }

    public void entraPerro()
    {
        try { mutex.acquire();} catch (InterruptedException e1) { }
        
        


        if(noHayPerros()) 
            try { gatoSemaphore.acquire(capacidad);} catch (Exception e) {}
        
        try { perroSemaphore.acquire(1);} catch (Exception e) {}
        System.out.println("Entra perro.");

        mutex.release();
    }

    public void salePerro()
    {
        perroSemaphore.release(1);
        if(noHayPerros())
            gatoSemaphore.release(capacidad);
        System.out.println("Sale perro.");
    }

    public void entraGato()
    {
        try { mutex.acquire();} catch (InterruptedException e1) { }

        if(noHayGatos()) 
            try { perroSemaphore.acquire(capacidad); } catch (InterruptedException e) { }
        
        try { gatoSemaphore.acquire(); } catch (InterruptedException e) { }
        System.out.println("Entra gato.");

        mutex.release();
    }

    public void saleGato()
    {
        gatoSemaphore.release();
        if(noHayGatos())
            perroSemaphore.release(capacidad);
        System.out.println("Sale gato.");
    }

    public boolean noHayPerros()
    {
        return perroSemaphore.availablePermits() == capacidad;
    }

    public boolean noHayGatos()
    {
        return gatoSemaphore.availablePermits() == capacidad;
    }
}
