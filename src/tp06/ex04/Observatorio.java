package tp06.ex04;

public class Observatorio {
    
    private final Recepcion recepcion;
    private final Libro libro;

    public Observatorio()
    {
        this.recepcion = new Recepcion();
        this.libro = new Libro(); 
    }

    public void entrar(String tipo, int id)
    {
        switch(tipo)
        {
            case "Visitante"    : recepcion.entrarVisitante(id);        break;
            case "Investigador" : recepcion.entrarInvestigador(id);     break;
            case "Mantenimiento": recepcion.entrarMantenimiento(id);    break;
            case "SillaRuedas"  : recepcion.entrarSillaRueda(id);       break;
            default: break;
        }
    }

    public void salir(String tipo, int id)
    {
        switch(tipo)
        {
            case "Visitante"    : recepcion.salirVisitante(id);         break;
            case "Investigador" : recepcion.salirInvestigador(id);      break;
            case "Mantenimiento": recepcion.salirMantenimiento(id);     break;
            case "SillaRuedas"  : recepcion.salirSillaRueda(id);        break;
            default: break;
        } 
    }

    public void anotarObservacion(String observacion)
    {
        libro.anotar(observacion);
    }
}
