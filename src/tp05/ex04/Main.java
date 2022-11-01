package tp05.ex04;

public class Main {
    
    private static int LUGARES_TREN = 8;
    private static int VIAJES = 3;
    private static int PASAJEROS = LUGARES_TREN*VIAJES;
    
    static public void main(String[] args)
    {
        TrenTuristico trenTuristico = new TrenTuristico(LUGARES_TREN);

        ControlTren control = new ControlTren(VIAJES, trenTuristico);
        control.start();

        VendedorTickets vendedor = new VendedorTickets(PASAJEROS, trenTuristico);
        vendedor.start();

        for(int i=0; i<PASAJEROS; i++)
            new Pasajero(trenTuristico).start();
    }
}
