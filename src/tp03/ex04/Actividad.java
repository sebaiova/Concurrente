package tp03.ex04;

public class Actividad {
    
    private final String nombre;

    public Actividad(String nombre)
    {
        this.nombre = nombre;
    }

    public synchronized void usar(Hamster hamster) throws InterruptedException 
    {
        System.out.printf("Hamster \"%d\" ha empezado a utilizar %s.\n", hamster.getNumero(), this.nombre);
        Thread.sleep(500);
        System.out.printf("Hamster \"%d\" ha dejado de utilizar %s.\n", hamster.getNumero(), this.nombre);
    }
}
