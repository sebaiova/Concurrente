package tp02.ex01;

public class Cliente extends Thread {

    @Override
    public void run() { 
        System.out.println("soy"+Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
        
        }
    }
}
