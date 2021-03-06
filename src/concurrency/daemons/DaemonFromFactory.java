package concurrency.daemons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Timmy on 16.09.2014.
 *
 */
public class DaemonFromFactory implements Runnable {
    public DaemonFromFactory() {
    }

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());

        for (int i = 0; i < 10; i++)
            exec.execute(new DaemonFromFactory());

        System.out.println("All daemons started.");
        TimeUnit.MILLISECONDS.sleep(1275);
    }
}
