package tp04.ex03;

public class Printer extends Thread {
   
    final char c;
    final int repeat, turno;
    final CylcedControl control;

    public Printer(char c, int repeat, int turno, CylcedControl control)
    {
        this.c = c;
        this.repeat = repeat;
        this.turno = turno;
        this.control = control;
    }

    @Override
    public void run()
    {
        for(int i=0; i<5; i++)
        {
            control.obtener(turno);

            for(int j=0; j<repeat; j++)
            {
                System.out.print(c);
                try { sleep(200); } catch (InterruptedException e) { }
            }
            control.dejar(turno);  
        }
    }
}
