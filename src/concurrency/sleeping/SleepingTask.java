package concurrency.sleeping;

import concurrency.the.very.basics.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Timmy on 31.08.2014.
 *
 */
public class SleepingTask extends LiftOff {
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
//                Thread.sleep(100); // old-style
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException ie) {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
