package tp03.ex07;

public class Printer extends Thread {
   
    char c;
    int repeat, turno;
    Control control;

    public Printer(char c, int repeat, int turno, Control control)
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
            while(!control.esTurno(turno))
            {
               // Thread.yield();
            }

            for(int j=0; j<repeat; j++)
            {
                System.out.print(c);
                try { sleep(200); } catch (InterruptedException e) { }
            }
                
            control.siguienteTurno();  
        }
    }
}
