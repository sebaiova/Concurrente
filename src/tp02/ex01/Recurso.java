package tp02.ex01;


public class Recurso {

    static void uso() {
        Thread t=Thread.currentThread();
        System.out.println("en Recurso:  Soy" + t.getName());
    }

}
