package tp02.ex07;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        long initialTime = System.currentTimeMillis();

        Thread cajero1 = new Thread(new CajeroRunnable("Cajero 1", cliente1, initialTime));
        Thread cajero2 = new Thread(new CajeroRunnable("Cajero 2", cliente2, initialTime));

        cajero1.start();
        cajero2.start();
    }
}