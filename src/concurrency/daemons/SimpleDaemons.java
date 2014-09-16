package concurrency.daemons;

import java.util.concurrent.TimeUnit;

/**
 * Created by Timmy on 16.09.2014.
 *
 */
public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException ie) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()!
            daemon.start();
        }
        System.out.println("All daemons started.");
        TimeUnit.MILLISECONDS.sleep(1275);
    }
}
