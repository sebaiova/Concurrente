package tp05.ex04;

public class ControlTren extends Thread {
    
    private final TrenTuristico tren;
    private int viajes;

    public ControlTren(int viajes, TrenTuristico tren)
    {
        this.viajes = viajes;
        this.tren = tren;
    }

    @Override
    public void run()
    {
        while(viajes-->0)
            tren.viajar();
    }
}