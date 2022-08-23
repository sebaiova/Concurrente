package tp02.ex04;

public class ThreadEjemplo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++)
            System.out.println(i + " " + Thread.currentThread().getName());
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }

    public static void main (String [] args) {

        new Thread(new ThreadEjemplo(), "Jose Maria").start();
        new Thread(new ThreadEjemplo(), "Maria Jose").start();
        System.out.println("Termina thread main");        
    }
}
