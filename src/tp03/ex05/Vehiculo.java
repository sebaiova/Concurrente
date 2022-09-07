package tp03.ex05;

abstract public class Vehiculo extends Thread {

    private final Surtidor surtidor;
    private final int capacidadTanque;
    private final String patente;

    private int combustible;

    public Vehiculo(String patente, int capacidadTanque, Surtidor surtidor) 
    {
        this.patente = patente;
        this.surtidor = surtidor;
        this.capacidadTanque = capacidadTanque;
        this.combustible = capacidadTanque;
    }

    public int getCapacidadTanque()
    {
        return capacidadTanque;
    }

    public int getCombustible() 
    {
        return combustible;
    }

    public void setCombustible(int x)
    {
        this.combustible = x;
    }
    
    public String getPatente() 
    {
        return patente;
    }

    private boolean lowEnergy()
    {
        return combustible < (capacidadTanque/10);
    }

    @Override
    public void run()
    {
        do {
            while(!lowEnergy())
                combustible = combustible==0 ? combustible : combustible-1;
        }
        while(surtidor.cargar(this));
    }
}
