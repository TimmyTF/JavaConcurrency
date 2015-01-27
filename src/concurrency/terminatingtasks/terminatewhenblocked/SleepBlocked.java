package concurrency.terminatingtasks.terminatewhenblocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 27.01.2015.
 * This class designed to show interruption of a thread, blocked by sleep() method
 */
class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
