package tp03.ex03;

import java.util.BitSet;

class SistemaConcierto
{
    private BitSet butacas;

    public SistemaConcierto()
    {
        butacas = new BitSet(32);
    }

    public BitSet getButacas()
    {
        return this.butacas;
    }

    public synchronized boolean reservar(BitSet butaca)
    {
        boolean success = false;
        if( !this.butacas.intersects(butaca))
        {
            this.butacas.or(butaca);
            success = true; 
        } 
        return success;
    }
}