package tp05.ex01;

public class Main {
    
    static private final int EMPLEADOS = 3;

    static public void main(String[] args) throws InterruptedException
    {
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(confiteria);
        Cocinero cocinero = new Cocinero(confiteria);

        mozo.start();
        cocinero.start();

        Empleado[] empleado = new Empleado[EMPLEADOS];
        for(int i=0; i<EMPLEADOS; i++)
        {
            empleado[i] = new Empleado(i, confiteria);
            empleado[i].start();
        }

        for(int i=0; i<EMPLEADOS; i++)
        {
            empleado[i].join();
        }
    }
}
