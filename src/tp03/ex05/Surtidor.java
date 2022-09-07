package tp03.ex05;

public class Surtidor {

    int carga;

    public Surtidor(int carga)
    {
        this.carga = carga;
    }

    public synchronized boolean cargar(Vehiculo vehiculo)
    {
        boolean success = true;
        int combustible = vehiculo.getCombustible();
        int faltante = vehiculo.getCapacidadTanque() - combustible;
        if(carga < faltante)
        {
            faltante = carga;
            success = false;
        }

        vehiculo.setCombustible(combustible+faltante);
        try { Thread.sleep(10);} catch (InterruptedException e) {}

        carga -= faltante;

        System.out.printf("Cargando %d lts. a vehiculo \"%s\". Combustible restante: %d.\n", faltante, vehiculo.getPatente(), carga);

        return success;
    }
}
