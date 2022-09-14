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

    private boolean lowEnergy()
    {
        return combustible < (capacidadTanque/10);
    }

    private int combustibleFaltante()
    {
        return this.capacidadTanque - this.combustible;
    }

    private boolean cargarCombustible()
    {
        int cantidadCargada = surtidor.sustraer(combustibleFaltante(), this.patente); 
       // System.out.printf("El vehiculo \"%s\" cargó %d lts.\n", patente, cantidadCargada);
        return cantidadCargada!=0;
    }
    

    @Override
    public void run()
    {
        do {
            while(!lowEnergy())
                combustible = combustible==0 ? combustible : combustible-1;
        }
        while( cargarCombustible() );
    }
}
