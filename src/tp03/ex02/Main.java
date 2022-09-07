package tp03.ex02;

public class Main {
    
    public static void main(String args[]) throws InterruptedException
    {
        Personaje jugador = new Personaje("Jugador");
    
        Orco orco = new Orco("Thrall", jugador);
        Curandero curandero = new Curandero("Uther", jugador);

        orco.start();
        curandero.start();

        orco.join();
        curandero.join();

        System.out.println("Cada personaje ha realizado 5 acciones.");
        System.out.println("HP restante de jugador: " + jugador.getHP());
    }
}
