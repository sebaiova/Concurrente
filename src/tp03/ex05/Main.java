package tp03.ex05;

public class Main {

    static private final int CANTIDAD_VEHICULOS = 5;

    public static void main(String args[]) throws InterruptedException 
    {
        Surtidor surtidor = new Surtidor(10000);
        Vehiculo[] vehiculos = new Vehiculo[CANTIDAD_VEHICULOS];
        
        for(int i=0; i<CANTIDAD_VEHICULOS; i++)
        {
            vehiculos[i] = new Auto(1000, new String("A"+i), surtidor);
            vehiculos[i].start();
        }

        for(int i=0; i<CANTIDAD_VEHICULOS; i++)
        {
            vehiculos[i].join();
        }
    }
}
