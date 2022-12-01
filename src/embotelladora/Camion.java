package embotelladora;

public class Camion extends Thread {
    
    private Almacen almacen;

    public Camion(Almacen almacen)
    {
        this.almacen = almacen;
    }

    @Override 
    public void run()
    {
        while(true)
        {
            almacen.transportar();
            try {sleep(5000);} catch (InterruptedException e) {}
        }
    }
}
