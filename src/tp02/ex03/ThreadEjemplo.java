package tp02.ex03;

public class ThreadEjemplo extends Thread {

    public ThreadEjemplo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10 ; i++)
            System.out.println(i + " " + getName());
        System.out.println("Termina thread " + getName());
    }

    public static void main (String [] args) {

        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
        
    }
    }
