package tp05.ex04;

public class VendedorTickets extends Thread {
    
    private TrenTuristico tren;
    private int pasajerosRestantes;

    public VendedorTickets(int pasajerosRestantes, TrenTuristico tren)
    {
        this.pasajerosRestantes = pasajerosRestantes;
        this.tren = tren;
    }

    @Override
    public void run()
    {
        while(pasajerosRestantes-->0)
        {
            try {sleep(200);} catch (InterruptedException e) {}
            tren.venderTicket();
        }
    }
}
