package tp05.ex04;

public class Pasajero extends Thread {
    
    private static int ID = 0;

    private final int id; 
    private TrenTuristico tren;

    public Pasajero(TrenTuristico tren)
    {
        this.id = ID++;
        this.tren = tren;
    }


    @Override
    public void run()
    {
        tren.comprarTicket(id);
        tren.subir(id);
        tren.bajar(id);
    }
}