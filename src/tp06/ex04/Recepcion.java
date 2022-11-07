package tp06.ex04;

import java.util.HashMap;

//MON
public class Recepcion {
    
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";

    private final int CAPACIDAD_SILLAS = 30;
    private final int CAPACIDAD_TOTAL = 50;

    int capacidad;
    HashMap<String, Integer> personas;

    public Recepcion()
    {
        this.capacidad = CAPACIDAD_TOTAL;
        this.personas = new HashMap<>();
        this.personas.put("Visitante", 0);
        this.personas.put("SillaRuedas", 0);
        this.personas.put("Mantenimiento", 0);
        this.personas.put("Investigador", 0);
    }

    public synchronized void entrarInvestigador(int id)
    {
        while( hayVisitantes() ||  hayMantenimiento() || estaLleno() )
            try { wait(); } catch (InterruptedException e) {}

        personas.merge("Investigador", 1, Integer::sum);
        System.out.printf("%sEntra Investigador [%d] a la sala.%s\n", BLUE, id, estado());
    }

    public synchronized void salirInvestigador(int id)
    {
        personas.merge("Investigador", -1, Integer::sum);
        notifyAll();
        System.out.printf("%sSale Investigador [%d] de la sala. %s\n", CYAN, id, estado());
    }

    public synchronized void entrarMantenimiento(int id)
    {
        while( hayVisitantes() ||  hayInvestigadores() || estaLleno() )
            try { wait(); } catch (InterruptedException e) {}

        personas.merge("Mantenimiento", 1, Integer::sum);
        System.out.printf("%sEntra Mantenimiento [%d] a la sala. %s\n", BLUE, id, estado());
    }

    public synchronized void salirMantenimiento(int id)
    {
        personas.merge("Mantenimiento", -1, Integer::sum);
        notifyAll();
        System.out.printf("%sSale Mantenimiento [%d] de la sala %s.\n", CYAN, id, estado());
    }

    public synchronized void entrarVisitante(int id)
    {
        while( hayInvestigadores() ||  hayMantenimiento() || estaLleno() )
            try { wait(); } catch (InterruptedException e) {}

        personas.merge("Visitante", 1, Integer::sum);
        System.out.printf("%sEntra Visitante [%d] a la sala. %s\n", BLUE, id, estado());
    }

    public synchronized void salirVisitante(int id)
    {
        personas.merge("Visitante", -1, Integer::sum);
        notifyAll();
        System.out.printf("%sSale Visitante [%d] de la sala. %s\n", CYAN, id, estado());
    }

    public synchronized void entrarSillaRueda(int id)
    {
        while( hayInvestigadores() ||  hayMantenimiento() || estaLlenoParaSillas() )
            try { wait(); } catch (InterruptedException e) {}

        personas.merge("SillaRuedas", 1, Integer::sum);
        capacidad = CAPACIDAD_SILLAS;
        System.out.printf("%sEntra Silla de Ruedas [%d] a la sala. %s\n", BLUE, id, estado());
    }

    public synchronized void salirSillaRueda(int id)
    {
        personas.merge("SillaRuedas", -1, Integer::sum);
        if(!haySillas())
            capacidad = CAPACIDAD_TOTAL;
        notifyAll();
        System.out.printf("%sSale Silla de Ruedas [%d] de la sala. %s\n", CYAN, id, estado());
    }

    private boolean estaLlenoParaSillas()
    {
        return personas() >= CAPACIDAD_SILLAS;
    }

    private boolean estaLleno()
    {
        return personas() >= capacidad;
    }

    private int personas()
    {
        int cantidad = 0;
        for (int valor : personas.values())
            cantidad += valor;
        return cantidad;
    }

    private boolean hayVisitantes()
    {
        return (personas.get("Visitante") + personas.get("SillaRuedas")) != 0;
    }

    private boolean hayMantenimiento()
    {
        return personas.get("Mantenimiento") != 0;
    }

    private boolean hayInvestigadores()
    {
        return personas.get("Investigador") != 0;
    }

    private boolean haySillas()
    {
        return personas.get("SillaRuedas") != 0;
    }
    
    private String estado()
    {
        return String.format("%s\t[%d/%d]", RED, personas(), capacidad);
    }
}
