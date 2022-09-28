package tp04.ex05;

public class Cliente extends Thread {
    
    private final Taxi taxi;

    public Cliente(Taxi taxi)
    {
        this.taxi = taxi;
    }

    @Override
    public void run()
    {
        taxi.tomarTaxi();
    }

}
