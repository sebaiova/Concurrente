package tp06.ex03;

class Cuartel {

    private final int CAPACIDAD = 50;
    private final int MOSTRADORES_ALMUERZO = 5;
    private final int MOSTRADORES_POSTRE = 3;
    private final int ABRIDORES = 10;

    private final Puerta puerta;
    private final Abridores abridores;
    private final Mostrador[] mostradorAlmuerzo;
    private final Mostrador[] mostradorPostre;

    public Cuartel()
    {
        puerta = new Puerta(CAPACIDAD);
        abridores = new Abridores(ABRIDORES);

        mostradorAlmuerzo = new Mostrador[MOSTRADORES_ALMUERZO];
        for(int i=0; i<MOSTRADORES_ALMUERZO; i++)
            mostradorAlmuerzo[i] = new Mostrador("Almuerzo", i);

        mostradorPostre = new Mostrador[MOSTRADORES_POSTRE];
        for(int i=0; i<MOSTRADORES_POSTRE; i++)
            mostradorPostre[i] = new Mostrador("Postre", i);
    }

    public void entrar(int id)
    {
        puerta.entrar(id);
    }

    public void salir(int id)
    {
        puerta.salir(id);
    }

    public void destaparGaseosa(int id, int lentitud)
    {
        abridores.agarrar(id);
        try {Thread.sleep(10*lentitud);} catch (InterruptedException e) {}
        abridores.dejar(id);
    }

    public void comerAlmuerzo(int id, int lentitud)
    {
        int idMostrador;
        synchronized(mostradorAlmuerzo)
        {
            idMostrador = mejorMostrador(mostradorAlmuerzo);
            mostradorAlmuerzo[idMostrador].hacerFila(id);
        }
        try {Thread.sleep(20*lentitud);} catch (InterruptedException e) {}
        mostradorAlmuerzo[idMostrador].agarrarBandeja(id);
    }

    public void comerPostre(int id, int lentitud)
    {
        int idMostrador;
        synchronized(mostradorPostre)
        {
            idMostrador = mejorMostrador(mostradorPostre);
            mostradorPostre[idMostrador].hacerFila(id);
        }
        try {Thread.sleep(10*lentitud);} catch (InterruptedException e) {}
        mostradorPostre[idMostrador].agarrarBandeja(id);
    }

    private int mejorMostrador(Mostrador[] mostrador)
    {
        int id = 0;
        int menorSize = mostrador[id].sizeFila();
        for(int i=1; i< mostrador.length; i++)
        {
            int size = mostrador[i].sizeFila();
            if(menorSize > size)
            {
                menorSize = size;
                id = i;
            }
        }
        return id;
    }
}