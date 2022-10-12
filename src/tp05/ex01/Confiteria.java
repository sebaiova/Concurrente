package tp05.ex01;

import java.util.concurrent.Semaphore;

public class Confiteria {
    
    Semaphore bebidasPedidas;
    Semaphore comidasPedidas;
    Semaphore bebidasPreparadas;
    Semaphore comidasPreparadas;
    Semaphore lugarConfiteria;

    public Confiteria()
    {
        lugarConfiteria = new Semaphore(2);
        bebidasPedidas = new Semaphore(0);
        comidasPedidas = new Semaphore(0);
        bebidasPreparadas = new Semaphore(0);
        comidasPreparadas = new Semaphore(0);
    }

    public void entrar()
    {
        try {lugarConfiteria.acquire();} catch (InterruptedException e) { }
    }

    public void salir()
    {
        lugarConfiteria.release();
    }

    public void pedirComida()
    {
        comidasPedidas.release();
    } 

    public void pedirBebida()
    {
        bebidasPedidas.release();
    }

    public void beber()
    {
        try {bebidasPreparadas.acquire();} catch (InterruptedException e) { }
    }

    public void comer()
    {
        try {comidasPreparadas.acquire();} catch (InterruptedException e) { }
    }

    public void prepararComida()
    {
        try {comidasPedidas.acquire();} catch (InterruptedException e) { }
        comidasPreparadas.release();
    }

    public void prepararBebida()
    {
        try {bebidasPedidas.acquire();} catch (InterruptedException e) { }
        bebidasPreparadas.release();
    }
}
