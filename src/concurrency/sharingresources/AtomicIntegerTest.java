package concurrency.sharingresources;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tflomin on 10.12.2014.
 *
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger atomicInt = new AtomicInteger(0);

    public int getValue() {
        return atomicInt.get();
    }

    private void evenIncrement() {
        atomicInt.addAndGet(2);
    }

    public void run() {
        while(true)
            evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000); // Terminate after 5 seconds

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while(true) {
            int val = ait.getValue();
            if(val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
