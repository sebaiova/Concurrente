package embotelladora;

public class Camion extends Thread {
    
    private Fabrica fabrica;

    public Camion(Fabrica fabrica)
    {
        this.fabrica = fabrica;
    }

    @Override 
    public void run()
    {
        while(true)
        {
            fabrica.transportar();
            try {sleep(5000);} catch (InterruptedException e) {}
        }
    }
}
