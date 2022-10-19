package tp05.ex02;

public class Gato extends Thread {
    
    private final Veterinaria veterinaria;

    public Gato(Veterinaria veterinaria)
    {
        this.veterinaria = veterinaria;
    }

    @Override
    public void run()
    {
        veterinaria.entraGato();
        try {sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
        veterinaria.saleGato();
    }

}
