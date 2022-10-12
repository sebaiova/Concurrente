package tp05.ex01;

public class Mozo extends Thread {
   
    private final Confiteria confiteria;

    public Mozo(Confiteria confiteria)
    {
        this.confiteria = confiteria;
    }

    @Override
    public void run()
    {
        while(true) 
        {
            confiteria.prepararBebida();
            System.out.println("Mozo sirvió una bebida.");
        }
    }

}
