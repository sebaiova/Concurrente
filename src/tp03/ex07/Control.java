package tp03.ex07;

public class Control {
    
    private int turno;
    private int cantidadTurnos;

    public Control(int cantidadTurnos)
    {
        this.cantidadTurnos = cantidadTurnos;
        this.turno = 0;
    }

    public synchronized boolean esTurno(int i)
    {
        return turno == i;
    } 

    public synchronized void siguienteTurno()
    {
        turno++;
        if(turno >= cantidadTurnos)
            turno = 0;
    }
}
