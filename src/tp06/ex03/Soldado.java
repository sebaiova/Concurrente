package tp06.ex03;

public class Soldado extends Thread {
    
    private static int ID = 0;
    private final int id;
    private final Cuartel cuartel;
    private final boolean gaseosa;
    private final int lentitud;

    public Soldado(boolean gaseosa, int lentitud, Cuartel cuartel)
    {
        id = ID++;
        this.gaseosa = gaseosa;
        this.cuartel = cuartel;
        this.lentitud = lentitud;
    }

    @Override
    public void run()
    {
        cuartel.entrar(id);
        cuartel.comerAlmuerzo(id, lentitud);
        if(gaseosa)
            cuartel.destaparGaseosa(id, lentitud);
        cuartel.comerPostre(id, lentitud);
        cuartel.salir(id);
    }
}
