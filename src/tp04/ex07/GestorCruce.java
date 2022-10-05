package tp04.ex07;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    
    private Semaphore semA;
    private Semaphore semB;
    private boolean turno;

    public GestorCruce()
    {
        this.semA = new Semaphore(0);
        this.semB = new Semaphore(1);
        this.turno = true;    
    }

    public void cambiar()
    {
        if(turno)
        {
            semA.release();
            try { semB.acquire(); } catch (InterruptedException e) { }
        }
        else 
        {
            try { semA.acquire(); } catch (InterruptedException e) { }            
            semB.release();
        }
        turno = !turno;
    }

    public void llegarNorte()
    {
        semA.();;
    }

    
}
