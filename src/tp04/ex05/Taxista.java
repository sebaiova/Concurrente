package tp04.ex05;

public class Taxista extends Thread {
    
    private final Taxi taxi;

    public Taxista(Taxi taxi)
    {   
        this.taxi = taxi;
    }

    public void run()
    {
        while(true)
        {
            taxi.realizarViaje();
        }
    }
}
