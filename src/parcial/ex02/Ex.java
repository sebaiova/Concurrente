package parcial.ex02;

public class Ex extends Thread {
    
    private final BufferOscilante buffer;
    public Ex(BufferOscilante buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {  
        try { buffer.poll();} catch (InterruptedException e) {}
    }

}
