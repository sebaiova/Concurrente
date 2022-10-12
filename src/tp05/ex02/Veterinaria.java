package tp05.ex02;

import java.util.concurrent.Semaphore;

public class Veterinaria {
    
    private final Semaphore lugaresSemaphore;
    private final Semaphore perrosSemaphore;
    private final Semaphore gatoSemaphore;

    public Veterinaria(int lugares)
    {
        lugaresSemaphore = new Semaphore(lugares);
        perrosSemaphore = new Semaphore(1);
        gatoSemaphore = new Semaphore(1);
    }

    public void entraPerro() throws InterruptedException
    {
        perrosSemaphore.acquire();
        lugaresSemaphore.acquire();
        perrosSemaphore.release();
    }

    public void salirPerro()
    {
        lugaresSemaphore.release();
    }
}
