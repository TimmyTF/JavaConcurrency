package concurrency.terminatingtasks.terminatewhenblocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 27.01.2015.
 * This class designed to be interrupted while it's sleeping(in other words, when it's blocked)
 * <p>to show that in this case interruption will lead to throwing an InterruptedException
 */
public class InterruptMeWhileImSleeping implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
