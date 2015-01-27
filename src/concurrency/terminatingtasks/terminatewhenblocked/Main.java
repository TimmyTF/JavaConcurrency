package concurrency.terminatingtasks.terminatewhenblocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 27.01.2015.
 *
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptMeWhileImSleeping());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
