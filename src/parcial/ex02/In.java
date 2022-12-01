package parcial.ex02;

public class In extends Thread {
    
    private final BufferOscilante buffer;
    public In(BufferOscilante buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {           
        buffer.add("Hello");
    }
}
