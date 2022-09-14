package tp03.ex05;

public class Surtidor {

    int carga;

    public Surtidor(int carga)
    {
        this.carga = carga;
    }

    public synchronized boolean tieneCarga()
    {
        return carga > 0;
    }

    public synchronized int sustraer(int lts, String patente)
    {
        int combustible = Math.min(lts, this.carga);
        this.carga -= combustible;
        System.out.printf("%s cargó %d lts. Al surtidor le quedan %d lts.\n", patente, combustible, carga);
        return combustible;
    }
}
