package tp05.ex02;

public class Perro extends Thread {
    
    private final Veterinaria veterinaria;

    public Perro(Veterinaria veterinaria)
    {
        this.veterinaria = veterinaria;
    }

    public void run()
    {
        veterinaria.entraPerro();
        try {sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
        veterinaria.salePerro();
    }

}
