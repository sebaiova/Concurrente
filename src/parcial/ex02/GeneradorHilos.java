package parcial.ex02;

import java.util.Random;

public class GeneradorHilos extends Thread {
    
    BufferOscilante buffer;

    public GeneradorHilos(BufferOscilante buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        while(true)
        {
            if(random.nextInt(100) > 70)
                new In(buffer).start();
            else
                new Ex(buffer).start(); 
        }
    }

}
