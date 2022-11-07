package tp06.ex04;

import java.util.LinkedList;
import java.util.List;

// MON
public class Libro {
    
    private List<String> observaciones = new LinkedList<>();

    public synchronized void anotar(String s)
    {
        observaciones.add(s);
    }
}
