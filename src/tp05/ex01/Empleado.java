package tp05.ex01;

public class Empleado extends Thread {
    
    private final Confiteria confiteria;
    private final int numero;

    public Empleado(int n, Confiteria confiteria)
    {
        this.numero = n;
        this.confiteria = confiteria;
    }

    public void run()
    {
        confiteria.entrar();
        System.out.printf("Empleado [%d] entṕ a la confitería.\n", numero);

        confiteria.pedirBebida();
        System.out.printf("Empleado [%d] pidió una bebiba.\n", numero);

        confiteria.beber();
        System.out.printf("Empleado [%d] bebe la bebida.\n", numero);

        confiteria.pedirComida();
        System.out.printf("Empleado [%d] pidió la comida.\n", numero);

        confiteria.comer();
        System.out.printf("Empleado [%d] come la comida.\n", numero);

        confiteria.salir();
        System.out.printf("Empleado [%d] salió de la confitería.\n", numero);
    }
}
