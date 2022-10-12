package tp05.ex01;

public class Cocinero extends Thread {

    private final Confiteria confiteria;

    public Cocinero(Confiteria confiteria)
    {
        this.confiteria = confiteria;
    }
    
    @Override
    public void run()
    {
        while(true) {
            confiteria.prepararComida();
            System.out.println("Cocinero preparó una comida.");
        }
    }
}
