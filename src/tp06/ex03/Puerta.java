package tp06.ex03;

//MON
public class Puerta {
    
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    private final int CAPACIDAD;
    private int soldadosDentro;

    public Puerta(int capacidad)
    {
        this.CAPACIDAD = capacidad;
        this.soldadosDentro = 0;
    }

    public synchronized void entrar(int id)
    {
        while(!puedeEntrar())
            try {wait();} catch (InterruptedException e) {}

        soldadosDentro++;
        System.out.printf("%sEl soldado [%d] ha entrado al Cuartel.\n", BLUE, id);
    }

    public synchronized void salir(int id)
    {
        soldadosDentro--;
        notify();
        System.out.printf("%sEl soldado [%d] ha salido del Cuartel.\n", CYAN, id);
    }

    private boolean puedeEntrar()
    {
        return soldadosDentro < CAPACIDAD;
    }
}
