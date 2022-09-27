package tp04.ex03;

import java.util.concurrent.Semaphore;

public class CylcedControl {

    Semaphore mutex[];
    final int AMOUNT_SEM;

    public CylcedControl(int amountSemaphores)
    {
        this.AMOUNT_SEM = amountSemaphores;
        mutex = new Semaphore[AMOUNT_SEM];
        for(int i=0; i<amountSemaphores; i++)
            mutex[i] = new Semaphore(i==0 ? 1 : 0);
    }

    public void obtener(int i)
    {
        try {mutex[i].acquire();} catch (InterruptedException e) {}
    }

    public void dejar(int i)
    {
        mutex[(i+1)%AMOUNT_SEM].release();
    }

}
