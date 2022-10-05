package buffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    
    final private Queue<Object> que;
    final private Semaphore sem;

    public Buffer() 
    {
        que = new LinkedList<Object>();
        sem = new Semaphore(0);
    }

    public boolean add(Object obj)
    {
        boolean success;
        sem.release();
        synchronized(que)
        {
            success = que.add(obj);
        }
        return success;
    }

    public synchronized Object poll()
    {
        Object obj;
        try {sem.acquire();} catch (Exception e) {}   
        synchronized(que)
        {
            obj = que.poll();
        }
        return obj;
    }
}
