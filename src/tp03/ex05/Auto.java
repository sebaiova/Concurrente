package tp03.ex05;

public class Auto extends Vehiculo {
    
    private int km;

    public Auto(int capacidadTanque, String patente, Surtidor surtidor) 
    {
        super(patente, capacidadTanque, surtidor);
        this.km = 0;
    }

    public int getKm() 
    {
        return km;
    }
}
